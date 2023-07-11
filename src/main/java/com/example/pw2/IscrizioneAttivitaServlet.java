package com.example.pw2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "iscrizioneAttivitaServlet", value = "/iscrizioneAttivita")
public class IscrizioneAttivitaServlet extends HttpServlet {

    Connection conn = connect.connectDb();
    PreparedStatement ps = null;
    ResultSet rs = null;

    ModelSessione ms;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String attivita = request.getParameter("attivita");
        String query;

        try{

            query = "SELECT * FROM ISCRIZIONIATTIVITATABLE WHERE ID_UTENTE = ? AND USERNAME_UTENTE = ? AND ATTIVITA=?";

            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, username);
            ps.setString(3, attivita);

            rs = ps.executeQuery();

            if(rs.next()) { //Esiste già l'associazione all'attività

                response.setHeader("message", "Errore, sei già iscritto a quest'attività");
                response.setStatus(HttpServletResponse.SC_CONFLICT);

            }
            else {

                query = "INSERT INTO ISCRIZIONIATTIVITATABLE (ID_UTENTE, USERNAME_UTENTE, ATTIVITA)  VALUES (?, ?, ?)";

                ps = conn.prepareStatement(query);
                ps.setInt(1, id);
                ps.setString(2, username);
                ps.setString(3, attivita);

                if (ps.executeUpdate() > 0){  //Inserimento completato
                    response.setHeader("message", "Ti sei iscritto correttamente all'attività " + attivita);
                    response.setStatus(HttpServletResponse.SC_OK);

                    ms.updateSessionAttivita(request.getSession(false));

                } else {
                    response.setHeader("message", "Errore, impossibile iscriversi all'attività");
                    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                }
            }

            // Imposta il tipo di contenuto della risposta
            response.setContentType("text/plain");

        } catch (SQLException e) {
            System.out.println("(IscrizioneAttivitaServlet) Errore: " + e);
            throw new RuntimeException(e);
        }

    }
}
