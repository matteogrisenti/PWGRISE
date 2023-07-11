<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false" %>     <!-- impedisce la creazione automatica della sessione -->
<jsp:include page="intestazione.jsp" />


<link rel="stylesheet" type="text/css" href="css/attivita.css">
<link rel="stylesheet" type="text/css" href="css/struttura.css">

<main>
    <div class="cover">
        <h1> ATTIVITA' </h1>
        <h3> Istituto Tecnico Tum4World</h3>
    </div>

    <section>
        <div class="row-singola">
            <h1>Attivita'</h1>
            <p>
                Attraverso le nostre tre principali attività, scuola, servizio navette scolastiche e servizio mensa della navetta, ci dedichiamo con determinazione a fornire un aiuto concreto e tangibile.
                Sappiamo che una comunità prospera e inclusiva si basa su un'istruzione di qualità accessibile a tutti. Pertanto, la nostra scuola è un pilastro fondamentale del nostro impegno educativo.
                Crediamo che ogni bambino meriti l'opportunità di sviluppare appieno le proprie capacità e di realizzare i propri sogni, indipendentemente dalla loro situazione economica.
                Nella nostra scuola, creiamo un ambiente accogliente e stimolante, con insegnanti qualificati che si dedicano con passione all'educazione dei nostri studenti.
            </p>
        </div>

        <div id="rigaAttivita">
            <a href="scuola.jsp" class="noSottolineatura">
                <div class="card" style="background-image: url('Images/Attivita/Scuola.jpg')">
                    <div class="cardInfo" attivita="scuola">
                        <h3 class="cardInfoText"> SCUOLA </h3>
                        <p class="cardInfoText">
                            Sappiamo che l'istruzione è fondamentale per il futuro di ogni individuo, ma purtroppo molte
                            famiglie non possono permettersi di garantire ai propri figli un'educazione adeguata.
                            Da qui nasce il nostro programma scolastico gratuito.
                        </p>
                    </div>
                </div>
            </a>

            <a href="${pageContext.request.contextPath}/GestoreDonazioniNavetta" methods="GET" class="noSottolineatura">
                <div class="card" style="background-image: url('Images/Attivita/School-Bus.jpg')">
                    <div class="cardInfo" attivita="navetta">
                        <h3 class="cardInfoText"> BUS </h3>
                        <p class="cardInfoText">
                            Sappiamo che molti ragazzi abitano a lunghe distanze dalla scuola, loro non hanno accesso a
                            mezzi di trasporto affidabili. Per questo motivo, mettiamo a disposizione per i ragazzi un servizio di navette
                        </p>
                    </div>
                </div>
            </a>

            <a href="mensa.jsp" class="noSottolineatura">
                <div class="card" style="background-image: url('Images/Attivita/Mensa.jpg')">
                    <div class="cardInfo" attivita="mensa">
                        <h3 class="cardInfoText"> MENSA </h3>
                        <p class="cardInfoText">
                            Riconosciamo l'importanza di una corretta alimentazione per il benessere e la crescita dei bambini. Pertanto, forniamo
                            pasti equilibrati e nutrienti ai bambini che frequentano la nostra scuola.
                        </p>
                    </div>
                </div>
            </a>


            <script type="text/javascript" src="javascript/attivita.js"></script>
        </div>
    </section>

    <script src="./javascript/paginaVisitata.js" onload="incrementaCounterPagina('attivita.jsp')"></script>

</main>

<jsp:include page="footer.jsp"/>