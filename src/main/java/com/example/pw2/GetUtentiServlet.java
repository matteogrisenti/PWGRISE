package com.example.pw2;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "GetUtentiServlet", value = "/GetUtentiServlet")
public class GetUtentiServlet extends HttpServlet {

    String query, query2;
    PreparedStatement ps, ps2;
    ResultSet rs, rs2;
    Connection conn = connect.connectDb();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String scelta = request.getParameter("categoriaCercata");

        System.out.println("--------------------------Inizio----------------------");
        System.out.println("Dentro getUtentiServlet ,scelta = " + scelta);

        try {

            if(scelta.equals("aderente")||scelta.equals("simpatizzante")){    //Solo una categoria
                query = "SELECT ID, USERNAME, ROLE, NAME, SURNAME, BIRTH, MAIL, PHONE_NUMBER, totSum AS sumDonation " +
                        "FROM LOGINTABLE " +
                        "LEFT JOIN (" +
                        "   SELECT USERNAME_DONATORE, SUM(IMPORTO) AS totSum" +
                        "   FROM DONATIONTABLE " +
                        "   GROUP BY USERNAME_DONATORE" +
                        ") AS D ON LOGINTABLE.USERNAME = D.USERNAME_DONATORE " +
                        "WHERE ROLE = ? ";
                ps = conn.prepareStatement(query);
                ps.setString(1, scelta);
            }
            else{   //Entrambe le categorie
                //System.out.println("Scelte entrambe le categorie");
                query = "SELECT ID, USERNAME, ROLE, NAME, SURNAME, BIRTH, MAIL, PHONE_NUMBER, totSum AS sumDonation " +
                        "FROM LOGINTABLE " +
                        "LEFT JOIN (" +
                        "   SELECT USERNAME_DONATORE, SUM(IMPORTO) AS totSum" +
                        "   FROM DONATIONTABLE " +
                        "   GROUP BY USERNAME_DONATORE" +
                        ") AS D ON LOGINTABLE.USERNAME = D.USERNAME_DONATORE ";
                ps = conn.prepareStatement(query);
            }

            rs = ps.executeQuery();

            StringBuilder jsonBuilder = new StringBuilder("[");

            boolean anotherOne = rs.next();

            while (anotherOne){

                query2 = "SELECT ATTIVITA FROM ISCRIZIONIATTIVITATABLE WHERE USERNAME_UTENTE = ?";
                ps2 = conn.prepareStatement(query2);
                ps2.setString(1, rs.getString("USERNAME"));
                rs2 = ps2.executeQuery();

                StringBuilder listaAttivita = new StringBuilder("[");
                boolean anotherOne2 = rs2.next();
                while (anotherOne2){
                    System.out.println("Attivita trovata: " + rs2.getString("ATTIVITA"));
                    listaAttivita.append(rs2.getString("ATTIVITA"));
                    System.out.println("Ora la stringa è: " + listaAttivita);
                    anotherOne2 = rs2.next();
                    if(anotherOne2){
                        listaAttivita.append(" - ");
                    }
                }
                listaAttivita.append("]");

                System.out.println("Elemento trovato, username = " + rs.getString("USERNAME"));
                jsonBuilder.append("{");
                jsonBuilder.append("\"ID\": \"").append(rs.getInt("ID")).append("\",");
                jsonBuilder.append("\"USERNAME\": \"").append(rs.getString("USERNAME")).append("\",");
                jsonBuilder.append("\"ROLE\": \"").append(rs.getString("ROLE")).append("\",");
                jsonBuilder.append("\"NAME\": \"").append(rs.getString("NAME")).append("\",");
                jsonBuilder.append("\"SURNAME\": \"").append(rs.getString("SURNAME")).append("\",");
                jsonBuilder.append("\"BIRTH\": \"").append(rs.getDate("BIRTH")).append("\",");
                jsonBuilder.append("\"MAIL\": \"").append(rs.getString("MAIL")).append("\",");
                jsonBuilder.append("\"PHONE_NUMBER\": \"").append(rs.getString("PHONE_NUMBER")).append("\",");
                jsonBuilder.append("\"LISTA_ATTIVITA\": \"").append(listaAttivita).append("\",");
                jsonBuilder.append("\"SUM_DONATION\": ").append(rs.getInt("SUMDONATION"));
                jsonBuilder.append("}");

                System.out.println("LISTA_ATTIVITA=" + listaAttivita);

                anotherOne = rs.next();
                if (anotherOne) {   //ce ne è ancora (almeno) uno
                    jsonBuilder.append(",");
                }
            }
            jsonBuilder.append("]");
            String json = jsonBuilder.toString();
            response.setContentType("application/json");
            response.getWriter().write(json);


        } catch (SQLException e) {
            System.out.println("(GetUtentiServlet) Errore: " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
