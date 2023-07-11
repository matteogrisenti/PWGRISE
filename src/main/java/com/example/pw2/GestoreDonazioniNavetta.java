package com.example.pw2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "GestoreDonazioniNavetta", urlPatterns ={"/GestoreDonazioniNavetta"} )
public class GestoreDonazioniNavetta extends HttpServlet {

    Connection conn = connect.connectDb();
    DonazioniNavettaModel dn = new DonazioniNavettaModel();    //model per le donazioni navetta
    int donazioniNavetta;
    int obbiettivoDonazioni = 100000;

    @Override
    public void init() throws ServletException {
        super.init();

        // prendo dal DataBase le donazioni navette
        donazioniNavetta = dn.getDonazioniNavetta(conn);    //Salvo le donazioni presenti
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //System.out.println("GET "+ conn);
        donazioniNavetta = dn.getDonazioniNavetta(conn);    //Aggiorno le donazioni

        // elaborazione dati
        float percentuale = ((float)donazioniNavetta/obbiettivoDonazioni) *100;   // calcolo la percentuale
        float percentualeDonazioni = (float) (Math.round(percentuale*100)/100.0);         // arrotondo la percentuale a due cifre dopo la virgola
        request.setAttribute("percentualeDonazioni",percentualeDonazioni);             // inserisco nella richiesta la percentuale calcolata

        // chiama il file JSP per la parte view
        try{
            RequestDispatcher requestDispatcher;
            requestDispatcher=request.getRequestDispatcher("/navetta.jsp");
            requestDispatcher.forward(request, response);
        }
        catch( Exception ex){
            System.out.println("Error");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int improve = Integer.parseInt(request.getParameter("importo"));
        System.out.println("improve: " + improve);

        //Aumento le donazioni totali
        //System.out.println("prima di post:"+donazioniNavetta);
        dn.setDonazioniNavetta(conn, improve);
        donazioniNavetta=dn.getDonazioniNavetta(conn);
        //System.out.println("dopo di post:"+donazioniNavetta);

        float percentuale = ((float)donazioniNavetta /obbiettivoDonazioni) *100;   // trovo la percentuale
        float percentualeDonazioni = (float) (Math.round(percentuale*100)/100.0);         // arrotondo la percentuale
        request.setAttribute("percentualeDonazioni",percentualeDonazioni);

        RequestDispatcher requestDispatcher;
        requestDispatcher=request.getRequestDispatcher("/navetta.jsp");
        requestDispatcher.forward(request, response);

    }

    public void destroy(){
        connect.closeConnection(conn);  //chiudo la connessione
        super.destroy();
    }
}
