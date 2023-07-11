<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="intestazione.jsp" />
<%@ page session="false" %>

<link rel="stylesheet" type="text/css" href="css/home.css">
<link rel="stylesheet" type="text/css" href="css/struttura.css">

<main>
    <div class="cover">
        <h1>Tum4World</h1>
    </div>

    <section>
        <div class="row">
            <div class="col">
                <h1>Scuola</h1>
                <p>
                    Tum4world è un'associazione di beneficenza che ha reso l'educazione un obiettivo prioritario nella sua missione di diffondere il benessere e l'uguaglianza nel mondo. Attraverso una vasta gamma di attività scolastiche, Tum4world lavora instancabilmente per offrire opportunità educative a coloro che altrimenti avrebbero difficoltà ad accedervi.
                    Una delle principali attività svolte da Tum4world è la creazione e il sostegno di scuole in comunità svantaggiate. In queste scuole, i bambini ricevono un'istruzione di qualità e gli insegnanti vengono selezionati e formati per garantire un ambiente di apprendimento stimolante e inclusivo. L'associazione si impegna anche a fornire le risorse necessarie, come libri di testo, materiale didattico e attrezzature scolastiche, per garantire che gli studenti abbiano tutto ciò di cui hanno bisogno per progredire nel loro percorso educativo.
                </p>
            </div>
            <div class="col">
                <div class="cover" style="background-image: url('Images/scuolaHome.jpg')"></div>
                <!-- <img src="Images/scuolaHome.jpg"> -->
            </div>
        </div>

        <div class="row">
            <div class="col">
                <h1>Servizi</h1>
                <p>
                    Non solo, ogni edificio scolastico vanta una mensa. Qui, cuochi appassionati preparano pasti deliziosi e nutrienti per coloro che si trovano in situazioni di difficoltà. Che tu sia senza fissa dimora, in cerca di lavoro o semplicemente in una situazione di temporanea difficoltà economica, la nostra mensa è aperta a tutti. Ogni pasto è realizzato con cura, utilizzando ingredienti freschi e salutari, per garantire che ogni boccone sia un momento di conforto e nutrimento per il corpo e lo spirito.
                    Ma non ci fermiamo alla sola mensa. Per facilitare l'accesso ai nostri servizi, offriamo anche un servizio di navetta gratuito per coloro che non possono raggiungerci facilmente. Sappiamo quanto sia importante garantire che tutti abbiano la possibilità di accedere ai servizi che offriamo, indipendentemente dalla loro ubicazione geografica. La nostra navetta, guidata da autisti volontari premurosi, fornisce un mezzo sicuro e affidabile per raggiungere le nostre strutture e partecipare alle attività comunitarie che offriamo.
                </p>
            </div>
            <div class="col">
                <div class="cover" style="background-image: url('Images/busHome.jpg')"></div>
                <!--    <img src="Images/busHome.jpg">  -->
            </div>
        </div>

        <div class="row">
            <div class="col">
                <h1>Tum4World</h1>
                <p>
                    Tum4world è molto di più di una semplice mensa e un servizio di navetta. Ci preoccupiamo del benessere globale delle persone che assistiamo. Pertanto, offriamo programmi di formazione professionale per aiutare le persone a ricostruire le proprie vite e ottenere una stabilità a lungo termine.
                    Siamo un'associazione di beneficenza dedicata a fornire non solo assistenza materiale, ma anche un sostegno emotivo e un senso di comunità a coloro che si rivolgono a noi. Lavoriamo instancabilmente per diffondere un messaggio di speranza e riscatto per tutti coloro che attraversano momenti difficili.
                    Sia che tu abbia bisogno di un pasto caldo, di un passaggio sicuro o di un sostegno completo per ricostruire la tua vita, l'associazione di beneficenza Tum4world è qui per te. Insieme, possiamo creare un futuro migliore per tutti, affrontando le sfide che il mondo ci presenta e costruendo una società più inclusiva e solidale.
                </p>
            </div>
            <div class="col">
                <div class="cover" style="background-image: url('Images/mensaHome.jpg')"></div>
                <!-- <img src="Images/mensaHome.jpg"> -->
            </div>
        </div>

        <div class="row">
            <form action="#" method="get">
                <label id="labelVolantino">Scarica qui il nostro volantino</label>
                <button class="button-standard" type="submit" onclick="download()">Download</button>
            </form>
        </div>
    </section>

    <script>
        function download(){
            const a = document.createElement("a");

            a.href = "Images/Volantino.pdf";
            a.download = "";
            a.style.display = "none";

            document.body.appendChild(a);
            a.click();
            document.body.removeChild(a);
        }
    </script>
    <script src="./javascript/paginaVisitata.js" onload="incrementaCounterPagina('home.jsp')"></script>

</main>


<jsp:include page="footer.jsp"/>

