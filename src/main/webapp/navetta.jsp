<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false" %>     <!-- impedisce la creazione automatica della sessione -->
<jsp:include page="intestazione.jsp" />

<% float percentualeDonazioni = (float)request.getAttribute("percentualeDonazioni"); %>

<main>
    <link rel="stylesheet" type="text/css" href="css/struttura.css">
    <link rel="stylesheet" type="text/css" href="css/navetta.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Smokum&display=swap" rel="stylesheet">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Chokokutai&display=swap" rel="stylesheet">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Rubik:wght@900&display=swap" rel="stylesheet">
</main>

<main>

  <div class="cover" style="background-image: url('Images/Attivita/School-Bus.jpg')">
    <h1> NAVETTA </h1>
    <h3> Istituto Tecnico Tum4World</h3>
  </div>

  <div class="spaziatura"></div>
  <div class="spaziatura"></div>

  <div id="row-bus" setMargin="true">
      <div class="col-50-bus">
          <h1>NAVETTA</h1>
          <p>
              Il servizio di navetta è nato dall'esigenza di permettere a tutti i ragazzi,
              anche colore che vivono nei paesini limitrofi, di frequentare la nostra scuola
          </p>
          <p>
              Quando è nata l' idea del servizio navetta come associazione abbiamo stimato che con tre vetture saremmo
              riusciti a coprire a 360° l' intera area circostante. Fin'ora Tum4World è arrivata a finanziare solo due navette,
              <% if(percentualeDonazioni < 100.0) { %>
              attualmente come associazione stiamo cercando i fondi per completare questo progetto.
              <% } else{ %>
              ma grazie alle vostre donazioni siamo riusciti a raggiungere i soldi necessari per comprare la terza navetta.
              Attualmente il nostro team sta lavorando per effettuare l'acquisto.
              <% } %>
          </p>
          <p>
              Con i ragazzi che usufruiscono di questo servizio abbiamo deciso di dare dei nomi alle due navette: "Thunder" e "McQueen"
          </p>
          <p>
              <% if(percentualeDonazioni < 100.0) { %>
              Se volete contribuire al completamento del parco vetture cliccate sul bottone DONA, Il costo totale della nuova navetta è
              di 100.000$.
              Dalla barra a destra potete vedere la percentuale del fondo raggiunto, rappresentata dalla barra gialla.
              <% } else{ %>
              Anche se l'obbiettivo dei 100.000$ sono stati raggiunti lasciamo attivo il link per la donazione, eventuali fondi
              aggiuntivi saranno usati per la manutenzione dei mezzi.
              <% } %>
          </p>
          <button class="button-standard" type="button" onclick="showFormDona()"> Dona </button>
      </div>
      <div class="col-50-bus">
          <div class="container-bus-rows">
              <div class="bus-row" acquired="true">
                  <div class="elm-scorre">
                      <div class="bus-description">
                          <p><span colore-testo="giallo">Destinazione</span>: Muthara</p>
                          <p><span colore-testo="giallo">Tempo Tragitto</span>: 1h 30m</p>
                          <p><span colore-testo="giallo">Fermate</span>: Scuola - Ruiri Town - Kianjai - Muthara</p>
                      </div>
                      <div class="bus-row-first-el" acquired="true">
                          <h2 class="nomeBusThunder">Thunder</h2>
                          <img src="Images/Attivita/iconaBus.png" class="iconaBus" alt="Icona Bus"/>
                      </div>
                  </div>
              </div>

              <div class="bus-row" acquired="true">
                  <div class="elm-scorre">
                      <div class="bus-description">
                          <p><span colore-testo="giallo">Destinazione</span>: Katheri</p>
                          <p><span colore-testo="giallo">Tempo Tragitto</span>: 1h</p>
                          <p><span colore-testo="giallo">Fermate</span>: Scuola - Kithaku - Katheri</p>
                      </div>
                      <div class="bus-row-first-el" acquired="true">
                          <h2 class="nomeBusMcQueen">McQueen</h2>
                          <img src="Images/Attivita/iconaBus.png" class="iconaBus" alt="Icona Bus"/>
                      </div>
                  </div>
              </div>

              <div class="bus-row-static" acquired="false">
                  <div class="barra-completamento" style="width: <%=percentualeDonazioni%>% "></div>
                  <div class="barra-completamento-info">
                      <img src="Images/Attivita/iconaBus.png" class="iconaBus" alt="Icona Bus"/>
                      <div class="percentuale"><%=percentualeDonazioni%>%</div>
                  </div>
              </div>
          </div>
      </div>
  </div>

  <script type="text/javascript" src="javascript/navetta.js"></script>

  <div class="spaziatura"></div>

  <div id="popUp" pop-up="false" >
      <div id="formDonazione">
          <div id="closer" onclick="closeFormDona()">
              <img src="Images/Attivita/iconaX.png" style="width: 30px" alt="Errore nella visualizzazione dell'immagine">
          </div>
          <h2> DONA </h2>
          <form id="formReale" action="/PW2_war_exploded/GestoreDonazioniNavetta" method="post">
              <p setMargin="true">La tua donazione sarà destinata all'acquisto della terza navetta</p>
              <label for="importo">Importo Donazione</label>
              <input type="number" placeholder="0" name="importo" id="importo" required>
              <button type="submit"> DONA </button>
          </form>
      </div>
  </div>

    <script src="./javascript/paginaVisitata.js" onload="incrementaCounterPagina('navetta.jsp')"></script>

</main>

<jsp:include page="footer.jsp"/>

