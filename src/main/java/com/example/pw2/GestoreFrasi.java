package com.example.pw2;

import org.json.JSONObject;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.Connection;


@WebServlet(name = "GestoreFrasi", value = "/GestoreFrasi")
public class GestoreFrasi extends HttpServlet {

    Connection conn;
    FrasiModel fm;
    String[] frasi;   // array delle frasi
    String[] cit;     // array delle citazioni delle frasi

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Dentro GestoreFrasi");
        // prendo dal DataBase le frasi e citazioni da mostrare
        Connection conn = connect.connectDb();
        if(conn != null){
            fm = new FrasiModel(conn);
            frasi= fm.getFrasi();
            cit=fm.getCit();
        }
        else {
            System.out.println("(GestoreFrasi) Errore: conn == null");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("GETSORE FRASI CHIAMAT0");
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        //allego alla risposta le frasi e le citazioni
        try(PrintWriter out = response.getWriter()){

            //definisco l'oggetto che contiene gli array
            JSONObject contenuto = new JSONObject();
            contenuto.put("frasi",frasi);
            contenuto.put("cit",cit);


            //inserisco gli array nella risposta
            out.println(contenuto);
            out.flush();

        }catch (IOException ex){
            System.out.println("(GestoreFrasi) Errore - " + ex);
            response.sendRedirect("error.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void destroy(){
        connect.closeConnection(conn);
    } //chiudo la connessione
}