package com.example.pw2;

import org.json.JSONObject;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "PagineVisitateServlet", value = "/PagineVisitateServlet")
public class PagineVisitateServlet extends HttpServlet {

    PreparedStatement ps, ps2;
    ResultSet rs;
    Connection conn = connect.connectDb();
    String query;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String nomePagina = request.getParameter("nomePagina");

        System.out.println("-----------------------------------------------");
        System.out.println("Visitata pagina " + nomePagina);
        System.out.println("-----------------------------------------------");

        query = "SELECT * FROM COUNTERPAGETABLE WHERE NOME_PAGINA=?";
        String query2;

        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, nomePagina);
            rs = ps.executeQuery();


            if(rs.next()){   //Se la pagina è già presente nel db
                query2 = "UPDATE COUNTERPAGETABLE SET COUNTER = COUNTER + 1 WHERE NOME_PAGINA = ?";

            }
            else {          //Inserisco la pagina nel db
                query2 = "INSERT INTO COUNTERPAGETABLE VALUES (?, 1)";
            }

            ps2 = conn.prepareStatement(query2);
            ps2.setString(1, nomePagina);
            ps2.executeUpdate();

        } catch (SQLException e) {
            System.out.println("(PagineVisitateServlet) Errore: " + e);
            throw new RuntimeException(e);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String action = request.getParameter("action");

        try {

            if(action.equals("reset")){
                query = "UPDATE COUNTERPAGETABLE SET COUNTER = 0 WHERE COUNTER >= 0";
                ps = conn.prepareStatement(query);
                ps.executeUpdate();

            }
            else {
                ArrayList<String> nomi = new ArrayList<>();
                ArrayList<Integer> numeroDiVisite = new ArrayList<>();

                query = "SELECT * FROM COUNTERPAGETABLE";

                ps = conn.prepareStatement(query);

                rs = ps.executeQuery();

                while (rs.next()){
                    nomi.add(rs.getString("NOME_PAGINA"));
                    numeroDiVisite.add((rs.getInt("COUNTER")));
                }

                JSONObject contenuto = new JSONObject();
                contenuto.put("nomi", nomi.toArray());
                contenuto.put("numeroDiVisite", numeroDiVisite.toArray());

                response.getWriter().println(contenuto);
                response.getWriter().flush();
            }

        } catch (SQLException e) {
            System.out.println("(pagineVisitateServlet) Errore: " + e);
            throw new RuntimeException(e);
        }


    }
}
