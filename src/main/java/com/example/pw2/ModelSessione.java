package com.example.pw2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelSessione {

    static public HttpSession initSessione(HttpServletRequest request, ResultSet rs, Connection conn) throws SQLException {
        String username = request.getParameter("username");

        //System.out.println("Cerco attivita associate all'utente " + username);

        String listaAttivita = takeAttivita(username,conn);

        /*
        query2 = "SELECT ATTIVITA FROM ISCRIZIONIATTIVITATABLE WHERE USERNAME_UTENTE = ?";
        ps2 = conn.prepareStatement(query2);
        ps2.setString(1, username);
        rs2 = ps2.executeQuery();

        StringBuilder listaAttivita = new StringBuilder("[");
        boolean anotherOne = rs2.next();
        while (anotherOne) {
            System.out.println("Attivita trovata: " + rs2.getString("ATTIVITA"));
            listaAttivita.append(rs2.getString("ATTIVITA"));
            System.out.println("Ora la stringa è: " + listaAttivita);
            anotherOne = rs2.next();
            if (anotherOne) {
                listaAttivita.append(" - ");
            }
        }
        listaAttivita.append("]");
        */

        //Recupero la sessione
        HttpSession oldSession = request.getSession(false); //Verifico se esiste già una sessione (false mi permette di evitare che se ne crei una nuova nel caso non ce ne sia una già esistente)
        if (oldSession != null) {
            oldSession.invalidate();    //Elimino la vecchia sessione se esistente
        }
        //Creo una nuova sessione, con i nuovi parametri username e password
        HttpSession currentSession = request.getSession();  //Di default è true, crea una nuova sessione
        currentSession.setAttribute("id", rs.getInt("ID"));
        currentSession.setAttribute("username", username);
        //currentSession.setAttribute("password", rs.getString("PASSWORD"));
        currentSession.setAttribute("role", rs.getString("ROLE"));
        currentSession.setAttribute("name", rs.getString("NAME"));
        currentSession.setAttribute("surname", rs.getString("SURNAME"));
        currentSession.setAttribute("date_of_birth", rs.getDate("BIRTH"));
        currentSession.setAttribute("mail", rs.getString("MAIL"));
        currentSession.setAttribute("phone_number", rs.getString("PHONE_NUMBER"));
        currentSession.setAttribute("listaAttivita", listaAttivita);
        currentSession.setAttribute("logged", true);

        return currentSession;
    }

    static private String takeAttivita(String username, Connection conn) throws SQLException {
        PreparedStatement ps2 = null;
        ResultSet rs2 = null;
        String query2;

        query2 = "SELECT ATTIVITA FROM ISCRIZIONIATTIVITATABLE WHERE USERNAME_UTENTE = ?";
        ps2 = conn.prepareStatement(query2);
        ps2.setString(1, username);
        rs2 = ps2.executeQuery();

        StringBuilder listaAttivita = new StringBuilder("");
        boolean anotherOne = rs2.next();
        while (anotherOne) {
            //System.out.println("Attivita trovata: " + rs2.getString("ATTIVITA"));
            listaAttivita.append(rs2.getString("ATTIVITA"));
            //System.out.println("Ora la stringa è: " + listaAttivita);
            anotherOne = rs2.next();
            if (anotherOne) {
                listaAttivita.append(" - ");
            }
        }


        return listaAttivita.toString();
    }

    static public boolean updateSessionAttivita(HttpSession session) throws SQLException {
        Connection conn = connect.connectDb();
        String username = session.getAttribute("username").toString();
        if(session.getAttribute("listaAttivita") == null){
            return false;
        }else{
            session.removeAttribute("listaAttivita");
            session.setAttribute("listaAttivita",takeAttivita(username,conn));
            return true;
        }
    }

}
