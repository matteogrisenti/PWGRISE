<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false" %>     <!-- impedisce la creazione automatica della sessione -->
<jsp:include page="intestazione.jsp" />

<%  HttpSession session = request.getSession(false); %>
<%  int id = 0;
    String username = "notLogged";
    if(session!=null){
        id = Integer.parseInt(session.getAttribute("id").toString());
        username = session.getAttribute("username").toString();
    } %>

<link rel="stylesheet" type="text/css" href="css/struttura.css">
<link rel="stylesheet" type="text/css" href="css/aderente/donazioni.css">
<script src="javascript/simpOrAd.js"></script>

<main>

    <section>
        <jsp:include page="simpOrAd.jsp" />
        <br>
        <br>
        <div class="pagina">
            <div class="box">
                <div class="titolo">
                    <header>Donazioni</header>
                    <p>
                        Donare all'associazione di beneficenza Tum4world è un modo significativo per sostenere l'istruzione e il potenziamento di persone di tutte le età. Attraverso i vostri contributi, Tum4world può offrire opportunità educative a coloro che ne hanno bisogno, aprendo le porte a un futuro migliore. I fondi donati aiutano a finanziare programmi educativi, borse di studio e risorse didattiche, consentendo a individui svantaggiati di accedere a una formazione di qualità. Donare a Tum4world significa investire nell'istruzione come strumento di cambiamento e progresso per le comunità, offrendo speranza e opportunità a chiunque desideri apprendere e crescere.
                    </p>
                </div>
                <div class="input-donazioni">
                    <label>
                        <input type="text" class="input-testo" placeholder="Inserisci l'importo" id="idImportoDonazione" autocomplete="off" required>
                    </label>
                </div>
                <div class="input-donazioni">
                    <label>
                        <input type="text" class="input-testo" placeholder="Messaggio donazione" id="idMessaggioDonazione" autocomplete="off">
                    </label>
                </div>
                <div class="bottone">
                    <button class="button-standard" id="bottone" onclick="effettuaDonazione(<%=id%>, '<%=username%>')">Dona</button>
                </div>
            </div>
        </div>


    </section>

    <script src="./javascript/paginaVisitata.js" onload="incrementaCounterPagina('donazioni.jsp')"></script>

</main>

<jsp:include page="footer.jsp"/>