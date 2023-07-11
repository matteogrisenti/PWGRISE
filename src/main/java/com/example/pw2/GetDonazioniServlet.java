package com.example.pw2;

import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "GetDonazioniServlet", value = "/GetDonazioniServlet")
public class GetDonazioniServlet extends HttpServlet {


    Connection conn = connect.connectDb();
    PreparedStatement ps = null, ps2 = null;
    ResultSet rs = null, rs2 = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int[] donazioniDenaroTot = new int[12];
        int[] donazioniEffettuateTot = new int[12];
        int[] donatoriTot = new int[12];

        int[] donazioniDenaroCurrentYear = new int[12];
        int[] donazioniEffettuateCurrentYear = new int[12];
        int[] donatoriCurrentYear = new int[12];

        String query = "SELECT COUNT(ID_DONAZIONE) AS NumeroDonazioni, COUNT(DISTINCT USERNAME_DONATORE) AS NumeroDonatori, MONTH(DONATION_DATE) AS Mese, SUM(importo) AS SommaDonazioni FROM DONATIONTABLE GROUP BY MONTH(DONATION_DATE)";
        String query2 = "SELECT COUNT(ID_DONAZIONE) AS NumeroDonazioni, COUNT(DISTINCT USERNAME_DONATORE) AS NumeroDonatori, MONTH(DONATION_DATE) AS Mese, SUM(importo) AS SommaDonazioni FROM DONATIONTABLE WHERE YEAR(DONATION_DATE) = YEAR(CURRENT_DATE) GROUP BY MONTH(DONATION_DATE)";

        try(PrintWriter out = response.getWriter()) {

            ps = conn.prepareStatement(query);
            ps2 = conn.prepareStatement(query2);

            rs = ps.executeQuery();
            rs2 = ps2.executeQuery();

            //Nel caso vi sia un mese senza donazioni, lo inizializzo a zero
            for(int i = 0; i < 12; i++){
                donazioniDenaroTot[i] = 0;
                donazioniEffettuateTot[i] = 0;
                donatoriTot[i] = 0;

                donazioniDenaroCurrentYear[i] = 0;
                donazioniEffettuateCurrentYear[i] = 0;
                donatoriCurrentYear[i] = 0;
            }

            while (rs.next()){
                donazioniDenaroTot[rs.getInt("Mese")-1] = rs.getInt("SommaDonazioni");
                donazioniEffettuateTot[rs.getInt("Mese")-1] = rs.getInt("NumeroDonazioni");
                donatoriTot[rs.getInt("Mese")-1] = rs.getInt("NumeroDonatori");
            }

            while (rs2.next()){
                donazioniDenaroCurrentYear[rs2.getInt("Mese")-1] = rs2.getInt("SommaDonazioni");
                donazioniEffettuateCurrentYear[rs2.getInt("Mese")-1] = rs2.getInt("NumeroDonazioni");
                donatoriCurrentYear[rs2.getInt("Mese")-1] = rs2.getInt("NumeroDonatori");
            }

            //definisco l'oggetto che contiene gli array
            JSONObject contenuto = new JSONObject();
            contenuto.put("donazioniDenaroTot", donazioniDenaroTot);
            contenuto.put("donazioniEffettuateTot", donazioniEffettuateTot);
            contenuto.put("donatoriTot", donatoriTot);

            contenuto.put("donazioniDenaroCurrentYear", donazioniDenaroCurrentYear);
            contenuto.put("donazioniEffettuateCurrentYear", donazioniEffettuateCurrentYear);
            contenuto.put("donatoriCurrentYear", donatoriCurrentYear);

            //inserisco l'array nella risposta
            out.println(contenuto);
            out.flush();

        } catch (SQLException e) {
            System.out.println("(Grafico donazioni servlet), errore: " + e);
            throw new RuntimeException(e);
        }



    }


}


