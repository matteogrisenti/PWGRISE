package com.example.pw2;

import java.sql.*;

public class connect {

    static boolean init = false;            //variabile per vedere se il database è gia stato inizializzato

    public static Connection connectDb() {
        Connection conn;
        try {
            System.out.println("Tentativo di connessione");
            Class.forName("org.apache.derby.jdbc.ClientDriver");                                    // definisco il Driver
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/DataBasePW;create=true");    // creo la connessione
            System.out.println("Connesso");

            if(!init) {                     // inizializzo il database
                initDataBase(conn);
                init = true;
            }else{
                System.out.println("DATABASE GIA ESISTENTE");
            }

            return conn;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Connessione fallita");
            ex.printStackTrace();
            return null;
        }
    }

    public static void closeConnection(Connection conn){
        try{
            conn.close();
            System.out.println("Connessione chiusa correttamente");
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Va invocata passando il parametro conn, non si può rendere quello sopra globale poiché è statico all'interno del costruttore
    //L'ho inserito in questa classe in quanto metodo generico utilizzato da più servlet
    //(Dambro) l'ho invertita per evitare un warning
    public static boolean needToCreate(Connection connection, String tableName) throws SQLException {
        ResultSet resultSet = connection.getMetaData().getTables(null, null, tableName, null);
        return !resultSet.next();
    }

    private static void initDataBase(Connection connection) throws SQLException {

        Statement ps;

        //TABELLA FRASI
        if (needToCreate(connection, "FRASITABLE")) {     // controllo che non sia gia stata creata la tabella
            String queryCreazione = "CREATE TABLE FRASITABLE (ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), frase VARCHAR(100), cit VARCHAR(50))"; //query per creare la tabella
            ps = connection.createStatement();              // creo la query
            ps.executeUpdate(queryCreazione);               // eseguo la query
            System.out.println("Table 'FRASITABLE' creata");

            try {                                           // Inizializzo la tabella
                ps.executeUpdate("INSERT INTO FRASITABLE VALUES (DEFAULT,'Fare volontariato fa bene all’anima e al cuore', '(Roy Disney)')");
                ps.executeUpdate("INSERT INTO FRASITABLE VALUES (DEFAULT,'Là dove c’è un volontario, c’è umanità e speranza', '(Rinaldo Sidoli)')");
                ps.executeUpdate("INSERT INTO FRASITABLE VALUES (DEFAULT,'Quello che per altri è perdita di tempo per me è vita', '(Rinaldo Sidoli)')");
                ps.executeUpdate("INSERT INTO FRASITABLE VALUES (DEFAULT,'Tutti hanno la responsabilità di essere volontari da qualche parte', '(Jennifer Garner)')");

            } catch (SQLException e) {
                System.out.println("Errore inizializzazione FRASITABLE" + e);
                throw new RuntimeException(e);
            }
            System.out.println("Table 'FRASITABLE' inizializzata");


        } else {
            System.out.println("Tabella 'FRASITABLE' già esistente");
        }

        //TABELLA DONAZIONI NAVETTA

        if (needToCreate(connection, "DONAZIONINAVETTATABLE")){
            String queryCreazione = "CREATE TABLE DONAZIONINAVETTATABLE ( donazioni int)"; //query per creare la tabella
            ps = connection.createStatement();              // creo la query
            ps.executeUpdate(queryCreazione);               // eseguo la query
            System.out.println("Table 'FRASITABLE' creata");

            try {                                           // Inizializzo la tabella
                ps.executeUpdate("INSERT INTO DONAZIONINAVETTATABLE VALUES (0)");
            } catch (SQLException e) {
                System.out.println("Errore inizializzazione DONAZIONINAVETTATABLE" + e);
                throw new RuntimeException(e);
            }
            System.out.println("Table 'DONAZIONINAVETTATABLE' inizializzata");
        }else {
            System.out.println("Tabella 'DONAZIONINAVETTATABLE' già esistente");
        }

        //TABELLA LOGIN

        if(needToCreate(connection, "LOGINTABLE")){     // controllo che non sia gia stata creata la tabella
            String queryCreazione = "CREATE TABLE LOGINTABLE (ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), USERNAME VARCHAR(30), PASSWORD VARCHAR(30), ROLE VARCHAR(30), NAME VARCHAR(30), SURNAME VARCHAR(30), BIRTH DATE, MAIL VARCHAR(50), PHONE_NUMBER VARCHAR(20), PRIMARY KEY (ID), UNIQUE (ID, USERNAME))"; //query per creare la tabella
            ps = connection.createStatement();              // creo la query
            ps.executeUpdate(queryCreazione);               // eseguo la query
            System.out.println("Table 'LoginTable' creata");

            try {                                           // Inizializzo la tabella
                ps.executeUpdate("INSERT INTO LOGINTABLE VALUES (DEFAULT, 'admin', '21Adm1n!', 'amministratore', 'Lorenzo', 'D_Ambrosio', '2002-09-23', 'tum4world@nessunonoluogonoesiste.com', '+39 338 855 5812')");
                ps.executeUpdate("INSERT INTO LOGINTABLE VALUES (DEFAULT, 'barbo02', 'rinoGattuso', 'aderente', 'Mattia', 'Barborini', '2002-02-08', 'mattia@barborini.it', '+39 331 136 7911')");
                ps.executeUpdate("INSERT INTO LOGINTABLE VALUES (DEFAULT, 'griso02', 'bruttoGesto', 'aderente', 'Matteo', 'Grisenti', '2002-07-04', 'matteo@grisenti.com', '+39 347 797 5317')");
                ps.executeUpdate("INSERT INTO LOGINTABLE VALUES (DEFAULT, 'murru02', 'ilSardo', 'simpatizzante', 'Marco', 'Murru', '2002-09-24', 'marco@murru.eja', '+39 346 573 5655')");
                ps.executeUpdate("INSERT INTO LOGINTABLE VALUES (DEFAULT, 'ema', 'ema02', 'simpatizzante', 'Emanuele', 'Munzone', '2002-04-25', 'ema@munzone.mc', '+39 317 980 2121')");
                ps.executeUpdate("INSERT INTO LOGINTABLE VALUES (DEFAULT, 'jade', 'laSarda', 'aderente', 'Giada', 'Marongiu', '2002-04-01', 'giada@marongiu.mc', '+39 316 971 2069')");
                ps.executeUpdate("INSERT INTO LOGINTABLE VALUES (DEFAULT, 'saraLeo', 'sat', 'simpatizzante', 'Sara', 'Leonardelli', '2003-11-27', 'sara@leonardelli.mc', '+39 329 496 1990')");
                ps.executeUpdate("INSERT INTO LOGINTABLE VALUES (DEFAULT, 'tipoTimido1', 'tt1', 'simpatizzante', 'Tipo', 'Timido', '2000-01-01', 'tipo@timido.com', '+39 333 333 3333')");
                ps.executeUpdate("INSERT INTO LOGINTABLE VALUES (DEFAULT, 'tipoTimido2', 'tt2', 'simpatizzante', 'Tipo', 'Timido', '2000-01-01', 'tipo@timido.com', '+39 333 333 3333')");
                ps.executeUpdate("INSERT INTO LOGINTABLE VALUES (DEFAULT, 'tipoTimido3', 'tt3', 'simpatizzante', 'Tipo', 'Timido', '2000-01-01', 'tipo@timido.com', '+39 333 333 3333')");
                ps.executeUpdate("INSERT INTO LOGINTABLE VALUES (DEFAULT, 'tipoTimido4', 'tt4', 'simpatizzante', 'Tipo', 'Timido', '2000-01-01', 'tipo@timido.com', '+39 333 333 3333')");
                ps.executeUpdate("INSERT INTO LOGINTABLE VALUES (DEFAULT, 'tipoTimido5', 'tt5', 'simpatizzante', 'Tipo', 'Timido', '2000-01-01', 'tipo@timido.com', '+39 333 333 3333')");
                ps.executeUpdate("INSERT INTO LOGINTABLE VALUES (DEFAULT, 'tipoTimido6', 'tt6', 'simpatizzante', 'Tipo', 'Timido', '2000-01-01', 'tipo@timido.com', '+39 333 333 3333')");
                ps.executeUpdate("INSERT INTO LOGINTABLE VALUES (DEFAULT, 'tipoTimido7', 'tt7', 'simpatizzante', 'Tipo', 'Timido', '2000-01-01', 'tipo@timido.com', '+39 333 333 3333')");
                ps.executeUpdate("INSERT INTO LOGINTABLE VALUES (DEFAULT, 'tipoTimido8', 'tt8', 'simpatizzante', 'Tipo', 'Timido', '2000-01-01', 'tipo@timido.com', '+39 333 333 3333')");
                ps.executeUpdate("INSERT INTO LOGINTABLE VALUES (DEFAULT, 'tipoTimido9', 'tt9', 'simpatizzante', 'Tipo', 'Timido', '2000-01-01', 'tipo@timido.com', '+39 333 333 3333')");
                ps.executeUpdate("INSERT INTO LOGINTABLE VALUES (DEFAULT, 'tipoTimido10', 'tt10', 'simpatizzante', 'Tipo', 'Timido', '2000-01-01', 'tipo@timido.com', '+39 333 333 3333')");
                ps.executeUpdate("INSERT INTO LOGINTABLE VALUES (DEFAULT, 'tipoTimido11', 'tt11', 'simpatizzante', 'Tipo', 'Timido', '2000-01-01', 'tipo@timido.com', '+39 333 333 3333')");
                ps.executeUpdate("INSERT INTO LOGINTABLE VALUES (DEFAULT, 'tipoTimido12', 'tt12', 'simpatizzante', 'Tipo', 'Timido', '2000-01-01', 'tipo@timido.com', '+39 333 333 3333')");
                ps.executeUpdate("INSERT INTO LOGINTABLE VALUES (DEFAULT, 'tipoTimido13', 'tt13', 'simpatizzante', 'Tipo', 'Timido', '2000-01-01', 'tipo@timido.com', '+39 333 333 3333')");
                ps.executeUpdate("INSERT INTO LOGINTABLE VALUES (DEFAULT, 'tipoTimido14', 'tt14', 'simpatizzante', 'Tipo', 'Timido', '2000-01-01', 'tipo@timido.com', '+39 333 333 3333')");
                ps.executeUpdate("INSERT INTO LOGINTABLE VALUES (DEFAULT, 'tipoTimido15', 'tt15', 'simpatizzante', 'Tipo', 'Timido', '2000-01-01', 'tipo@timido.com', '+39 333 333 3333')");


            } catch (SQLException e) {
                System.out.println("Errore inizializzazione loginTable" + e);
                throw new RuntimeException(e);
            }
            System.out.println("Table 'loginTable' inizializzata");


        } else {
            System.out.println("Tabella 'loginTable' già esistente");
        }

        if(needToCreate(connection, "DONATIONTABLE")){     // controllo che non sia gia stata creata la tabella
            String queryCreazione = "CREATE TABLE DONATIONTABLE (ID_DONAZIONE INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), USERNAME_DONATORE VARCHAR(30), DONATION_DATE DATE, IMPORTO INTEGER, MESSAGE VARCHAR(100), PRIMARY KEY (ID_DONAZIONE))"; //query per creare la tabella
            ps = connection.createStatement();              // creo la query
            ps.executeUpdate(queryCreazione);               // eseguo la query
            System.out.println("Table 'donationTable' creata");

            try {                                           // Inizializzo la tabella
                ps.executeUpdate("INSERT INTO DONATIONTABLE VALUES (DEFAULT, 'admin', '2023-07-04', 10000, 'Fondo base')");
                ps.executeUpdate("INSERT INTO DONATIONTABLE VALUES (DEFAULT, 'barbo02', '2023-02-20', 350, 'Quota per iscriversi')");
                ps.executeUpdate("INSERT INTO DONATIONTABLE VALUES (DEFAULT, 'barbo02', '2023-03-20', 500, 'Donazione 1')");
                ps.executeUpdate("INSERT INTO DONATIONTABLE VALUES (DEFAULT, 'barbo02', '2023-03-21', 500, 'Donazione 2')");
                ps.executeUpdate("INSERT INTO DONATIONTABLE VALUES (DEFAULT, 'griso02', '2003-02-22', 350, 'Quota per iscriversi')");
                ps.executeUpdate("INSERT INTO DONATIONTABLE VALUES (DEFAULT, 'jade', '2002-04-01', 4869, 'Iscrizione')");
                ps.executeUpdate("INSERT INTO DONATIONTABLE VALUES (DEFAULT, 'griso02', '2012-11-01', 350, 'Rinnovo')");
                ps.executeUpdate("INSERT INTO DONATIONTABLE VALUES (DEFAULT, 'griso02', '2022-11-01', 350, 'Rinnovo')");


            } catch (SQLException e) {
                System.out.println("Errore inizializzazione donationTable" + e);
                throw new RuntimeException(e);
            }
            System.out.println("Table 'donationTable' inizializzata");
        } else {
            System.out.println("Tabella 'donationTable' già esistente");
        }

        if(needToCreate(connection, "COUNTERPAGETABLE")){
            String queryCreazione = "CREATE TABLE COUNTERPAGETABLE (NOME_PAGINA VARCHAR(100), COUNTER INTEGER)"; //query per creare la tabella
            ps = connection.createStatement();              // creo la query
            ps.executeUpdate(queryCreazione);               // eseguo la query
        }

        if (needToCreate(connection, "ISCRIZIONIATTIVITATABLE")){
            String queryCreazione = "CREATE TABLE ISCRIZIONIATTIVITATABLE (ID_ISCRIZIONE INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), ID_UTENTE INTEGER, USERNAME_UTENTE VARCHAR(30), ATTIVITA VARCHAR(100), FOREIGN KEY (ID_UTENTE, USERNAME_UTENTE) REFERENCES LOGINTABLE(ID, USERNAME) ON DELETE CASCADE )"; //query per creare la tabella
            ps = connection.createStatement();              // creo la query
            ps.executeUpdate(queryCreazione);               // eseguo la query
        }
    }

}
