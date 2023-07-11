package com.example.pw2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "DonazioniUtenti", value = "/DonazioniUtenti")
public class DonazioniUtentiServlet extends HttpServlet {

    Connection conn = connect.connectDb();
    PreparedStatement ps = null;

    ResultSet rs = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Ottieni la data odierna
        LocalDate currentDate = LocalDate.now();

        // Formatta la data nel formato desiderato (yyyy-mm-dd)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Date dataOdierna = Date.valueOf(currentDate.format(formatter));

        String username = request.getParameter("username").toString();
        int importo = Integer.parseInt(request.getParameter("importoDonazione"));
        String message = request.getParameter("messaggioDonazione").toString();

        try {
            String query = "INSERT INTO DONATIONTABLE (USERNAME_DONATORE, DONATION_DATE, IMPORTO, MESSAGE)  VALUES (?, ?, ?, ?)";

            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setDate(2, dataOdierna);
            ps.setInt(3, importo);
            ps.setString(4, message);

            if(ps.executeUpdate() > 0){

                query = "SELECT SUM(IMPORTO) AS total_sum FROM DONATIONTABLE WHERE USERNAME_DONATORE = ?";

                ps = conn.prepareStatement(query);
                ps.setString(1, username);

                rs = ps.executeQuery();

                if (rs.next()) {
                    int totalSum = rs.getInt("total_sum");

                    if(totalSum == importo){
                        // Imposta il parametro nella risposta
                        response.setHeader("message", "Grazie per la tua prima donazione");
                    }
                    else {
                        // Imposta il parametro nella risposta
                        response.setHeader("message", "Donazione effettuata, totale denaro donato da " + username + " = " + totalSum);
                    }
                    response.setIntHeader("sumDonazioni", totalSum);
                    response.setStatus(HttpServletResponse.SC_OK);

                } else {
                    //Impossibile, essendo che ne ho appena inserita una, lo metto per sicurezza
                    response.setHeader("message", "Errore, nessuna donazione trovata");
                    response.setIntHeader("sumDonazioni", 0);
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                }
            }
            else {
                // Imposta il parametro nella risposta
                response.setHeader("message", "Errore nell'inserimento");
                response.setIntHeader("sumDonazioni", 0);
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }

            // Imposta il tipo di contenuto della risposta
            response.setContentType("text/plain");

        } catch (SQLException e) {
            System.out.println("(DonazioniUtentiServlet) Errore: " + e);
            throw new RuntimeException(e);
        }


    }
}


/*
        String query = "SELECT * FROM DONATIONTABLE WHERE ID_DONATORE=? AND USERNAME_DONATORE=?";

        System.out.println("------------------------------------");
        System.out.println("Dentro DonazioniUtente, id=" + id + ", username=" + username);
        System.out.println("Importo=" + importo + ", data=" + dataOdierna + ", messaggio=" + message);

        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, username);
            rs = ps.executeQuery();

            while (rs.next()){
                System.out.println("---------");
                System.out.println("Donazione: " + rs.getString("ID_DONAZIONE"));
                System.out.println("Donatore: id=" + rs.getString("ID_DONATORE") + ", username=" + rs.getString("USERNAME_DONATORE"));
                System.out.println("Data: " + rs.getString("DONATION_DATE"));
                System.out.println("Importo: " + rs.getString("IMPORTO"));
                System.out.println("Messaggio: " + rs.getString("MESSAGE"));
                System.out.println("----------");
            }

            System.out.println("----------------Stampato tutto-----------------");
*/