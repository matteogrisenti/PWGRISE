package com.example.pw2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DonazioniNavettaModel {

    static int donazioni;

    public DonazioniNavettaModel() {}

    // Metodo per scaricare il dato delle donazioni per la navetta dal database
    private void takeDonazioniNavettaFromDB(Connection conn){
        // prendo dal DataBase le donazioni navette

        try{
            Statement st = conn.createStatement();                  // creo lo statement
            String sql ="SELECT * FROM DONAZIONINAVETTATABLE";         // definisco la query
            ResultSet resultSet = st.executeQuery(sql);             // eseguo la query e salvo la risposta

            while(resultSet.next()){
                donazioni = resultSet.getInt(1);      //Leggo e salvo le donazioni presenti
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void setDonazioniNavetta(Connection conn, int improve){

        try{
            takeDonazioniNavettaFromDB(conn);            // riscarico il valore delle donazioni nella servlet per evitare errori
            donazioni = donazioni + improve;             // aggiorno il valore

            //System.out.println(donazioni);

            Statement st = conn.createStatement();                                        // creo lo statement
            String sql ="UPDATE DONAZIONINAVETTATABLE SET DONAZIONI = " + donazioni + " WHERE DONAZIONI >= 0";         // definisco la query
            st.executeUpdate(sql);                                                        // eseguo la query

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    // metodo da chiamare per ritornare le donazioni per la navetta
    public int getDonazioniNavetta(Connection conn){
        takeDonazioniNavettaFromDB(conn);
        return donazioni;
    }

}
