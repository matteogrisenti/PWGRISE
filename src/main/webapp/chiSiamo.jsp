<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false" %>     <!-- impedisce la creazione automatica della sessione -->
<jsp:include page="intestazione.jsp" />

<link rel="stylesheet" type="text/css" href="css/chiSiamo.css">
<link rel="stylesheet" type="text/css" href="css/struttura.css">

<main>
    <div class="cover">
        <h1> CHI SIAMO? </h1>
        <h3> Istituto Tecnico Tum4World</h3>
    </div>

    <section>
        <div class="row">
            <div class="col">
                <h1>Storia</h1>
                <p> L'Associazione Tum4World è stata fondata nel 2005 da un gruppo di volontari con una grande passione per il miglioramento delle condizioni di vita delle persone meno fortunate. La fondazione dell'associazione è stata ispirata dalla volontà di creare un impatto positivo nel mondo, in particolare per coloro che vivono in situazioni di povertà, malattia o svantaggio socio-economico.
                    La storia di Tum4World è intrisa di un impegno costante nel fornire aiuto e supporto alle comunità locali e internazionali. Grazie alla dedizione e all'impegno dei suoi membri, l'associazione ha realizzato numerosi progetti in diverse aree d'intervento, come l'istruzione, la salute, l'accesso all'acqua potabile, la sicurezza alimentare e lo sviluppo sostenibile.
                    Tum4World organizza regolarmente raccolte fondi e campagne di sensibilizzazione per finanziare i suoi progetti e garantire che i fondi raccolti siano utilizzati in modo trasparente ed efficiente. Inoltre, collabora attivamente con altre organizzazioni non governative, agenzie internazionali e istituzioni locali per massimizzare l'impatto delle sue iniziative e promuovere la solidarietà a livello globale.
                </p>
            </div>
            <div class="col">
                <div class="cover" style="background-image: url('Images/bambini.jpg')"></div>
            </div>
        </div>

        <div class="row">
            <div class="col">
                <h1>Tum4World</h1>
                <p>L'associazione ha sede principale nella città di Milano, ma opera su scala nazionale e internazionale, cercando di estendere la sua portata e coinvolgere comunità in tutto il mondo. Dispone di una rete di volontari dedicati, esperti nel loro campo e pronti a offrire il proprio contributo nelle diverse iniziative dell'associazione.
                </p>
            </div>
            <div class="col">
                <div class="cover" style="background-image: url('Images/scuola.jpg')"></div>
            </div>
        </div>

        <div class="row">
            <div class="col">
                <h1>Riconoscimenti</h1>
                <p>Grazie all'eccellenza del suo lavoro nel campo dell'assistenza umanitaria, Tum4World ha ricevuto numerosi riconoscimenti e premi sia a livello nazionale che internazionale. Queste onorificenze testimoniano il valore del suo impegno nel migliorare la vita delle persone e l'impatto positivo che ha avuto sulle comunità che ha servito. Tum4World è un faro di speranza per coloro che si trovano in condizioni di bisogno. Attraverso i suoi sforzi continui e la dedizione nel fornire assistenza e supporto, si impegna a costruire un mondo migliore per tutti, diffondendo un messaggio di solidarietà e compassione.
                </p>
            </div>
            <div class="col">
                <div class="cover" style="background-image: url('Images/volontario.jpg')"></div>
            </div>
        </div>
    </section>

    <script src="./javascript/paginaVisitata.js" onload="incrementaCounterPagina('chiSiamo.jsp')"></script>

</main>


<jsp:include page="footer.jsp"/>