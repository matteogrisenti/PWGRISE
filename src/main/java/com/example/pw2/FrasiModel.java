package com.example.pw2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FrasiModel {

    String[] frasi;   // array delle frasi
    String[] cit;     // array delle citazioni delle frasi

    public FrasiModel(Connection conn) {
        try {
            Statement st = conn.createStatement();       // creo lo statement
            String sql ="SELECT * FROM FRASITABLE";         // definisco la query
            ResultSet resultSet = st.executeQuery(sql);  // eseguo la query e salvo la risposta

            ArrayList<String> listFrasi = new ArrayList<>();        // uso degli ArrayList per facilitare la lettura della risposta
            ArrayList<String> listCit = new ArrayList<>();

            while(resultSet.next()){
                listFrasi.add(resultSet.getString(2));      //Leggo e salvo le frasi
                listCit.add(resultSet.getString(3));        //Leggo e salvo le citazioni
            }

            frasi = listFrasi.toArray(new String[listFrasi.size()]);    //ripongo i contenuti degli ArrayList negli array
            cit = listCit.toArray(new String[listCit.size()]);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String[] getCit() {
        return cit;
    }

    public String[] getFrasi() {
        return frasi;
    }
}