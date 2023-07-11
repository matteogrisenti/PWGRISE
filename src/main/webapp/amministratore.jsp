<jsp:include page="intestazione.jsp" />
<%@ page session="false" %>     <!-- impedisce la creazione automatica della sessione -->

<%  HttpSession session = request.getSession(false); %>
<%  String role="", username=""; if(session!=null){ role=session.getAttribute("role").toString(); username=session.getAttribute("username").toString(); } %>

<main>

  <link rel="stylesheet" type="text/css" href="css/amministratore.css">
  <link rel="stylesheet" type="text/css" href="css/struttura.css">

  <section>
    <h1 class="classAmministratore">Area <%=role%> utente &nbsp <span> <%=username%></span> </h1>

    <div class="classAmministratore">
      <button type="submit" class="button-standard" onclick="elencaUtenti('registrati')">Elenca tutti gli utenti registrati</button>
      <div class="popup" id="idPopup_registrati">
        <h2>Elenco utenti registrati: </h2>
        <table>
          <thead>
          <tr>
            <th>ID</th><th>USERNAME</th><th>TIPOLOGIA USER</th><th>NAME</th><th>SURNAME</th><th>BIRTH</th><th>MAIL</th><th>PHONE_NUMBER</th><th>SUM DONATION</th><th>ISCRIZIONI</th>
          </tr>
          </thead>
          <tbody id="idElenco_registrati">
          </tbody>
        </table>
        <button class="chiudi" onclick="chiudiElencaUtenti('registrati')">Chiudi</button>
      </div>
    </div>

    <br>

    <div class="classAmministratore">
      <button type="submit" class="button-standard" onclick="elencaUtenti('simpatizzante')">Elenca tutti gli utenti simpatizzanti</button>
      <div class="popup" id="idPopup_simpatizzante">
        <h2>Elenco utenti simpatizzanti: </h2>
        <table>
          <thead>
          <tr>
            <th>ID</th><th>USERNAME</th><th>NAME</th><th>SURNAME</th><th>BIRTH</th><th>MAIL</th><th>PHONE_NUMBER</th><th>SUM DONATION</th><th>ISCRIZIONI</th>
          </tr>
          </thead>
          <tbody id="idElenco_simpatizzante">
          </tbody>
        </table>
        <button class="chiudi" onclick="chiudiElencaUtenti('simpatizzante')">Chiudi</button>
      </div>
    </div>

    <br>

    <div class="classAmministratore">
      <button type="submit" class="button-standard" onclick="elencaUtenti('aderente')">Elenca tutti gli utenti aderenti</button>
      <div class="popup" id="idPopup_aderente">
        <h2>Elenco utenti aderenti: </h2>
        <table>
          <thead>
          <tr>
            <th>ID</th><th>USERNAME</th><th>NAME</th><th>SURNAME</th><th>BIRTH</th><th>MAIL</th><th>PHONE_NUMBER</th><th>SUM DONATION</th><th>ISCRIZIONI</th>
          </tr>
          </thead>
          <tbody id="idElenco_aderente">
          </tbody>
        </table>
        <button class="chiudi" onclick="chiudiElencaUtenti('aderente')">Chiudi</button>
      </div>
    </div>

    <br>
    <br>

    <h2>Istogramma visite</h2>
    <div id="idIstogrammaVisite"></div>
    <br>
    <div class="classAmministratore">
      <button type="button" class="button-standard" onclick="resetVisite()">Reset dati</button>
    </div>
    <br>
    <h2>Grafico denaro donato</h2>
    <div id="idGraficoDonazioniDenaro"></div>

    <h2>Grafico numero donazioni effettuate</h2>
    <div id="idGraficoDonazioniEffettuate"></div>
    <br>
    <br>
  </section>

  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://code.highcharts.com/highcharts.js"></script>
  <script src="./javascript/amministratore.js" onload="caricaGrafi()"></script>

  <script src="./javascript/paginaVisitata.js" onload="incrementaCounterPagina('amministratore.jsp')"></script>
</main>


<jsp:include page="footer.jsp" />

