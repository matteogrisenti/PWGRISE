<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false" %>     <!-- impedisce la creazione automatica della sessione -->
<jsp:include page="intestazione.jsp" />


<link rel="stylesheet" type="text/css" href="css/cardScrollUp.css">
<link rel="stylesheet" type="text/css" href="css/struttura.css">
<link rel="stylesheet" type="text/css" href="css/scuola.css">

<main>
    <div class="cover">
        <h1> SCUOLA </h1>
        <h3> Istituto Tecnico Tum4World</h3>
    </div>

    <section>
        <div class="row">
            <div class="col">
                <h1>Struttura</h1>
                <p>L'istituto Tum4World è il cuore e punto nevralgico della nostra associazione. La scuola ha subito molti ampliamenti per soddisfare la necessità sempre maggiore di aule
                    per accogliere il numero crescente di studenti. Inoltre questi aggiornamenti hanno permesso l'attivazione delle altre attivit&agrave; di tum4World: una cucina e sala pranzo per il servizio di mensa, e uno spiazzale per il servizio navetta.
                    Attualmente l'associazione sta recuperando i fondi necessari per finanziare un nuovo ampliamento che prevede la creazione di una aula computer necessaria per avviare il nuovo corso di studi d'informatica.
                </p>
            </div>
            <div class="col">
                <div class="cover" style="background-image: url('Images/Attivita/Scuola1.jpg')"></div>
            </div>
        </div>

        <div class="row-singola">
                <h1>Corsi</h1>
                <p>
                    Il nostro istituto storicamente mette a disposizione due corsi di studio: meccanico e alberghiero, da quest'anno, grazie a voi, abbiamo una novità al riguardo. Infatti grazie alle vostre cospicue donazioni
                    da quest'anno partirà il nuovo corso di chimica. Ma non è tutto, infatti sono gia iniziati i lavori per la costruzione di una nuova aula computer che permetterà l'avvio di un quarto corso aggiuntivo quello informatico.
                </p>
        </div>

        <div id="rigaCards" style="padding-bottom: 100px">
            <div class="cardSU">
                <p class="new-tag"> NEW </p>
                <div class="imgCard" new="true" style="background-image: url('Images/Attivita/Chimica.jpg')">
                    <div class="covering sfondoGiallo"> <h2> CHIMICA </h2> </div>
                </div>
                <div class="tendinaCard" >
                    <h3>Corso Chimica</h3>
                    <button class="button-standard" value="chimica">READ</button>
                </div>
            </div>

            <div class="cardSU">
                <div class="imgCard" style="background-image: url('Images/Attivita/Meccanica.jpg')">
                    <div class="covering sfondoRed"> <h2> MECCANICA </h2></div>
                </div>
                <div class="tendinaCard" >
                    <h3>Corso Meccanica</h3>
                    <button class="button-standard" value="meccanica">READ</button>
                </div>
            </div>

            <div class="cardSU">
                <div class="imgCard" style="background-image: url('Images/Attivita/Alberghiero.jpg')">
                    <div class="covering sfondoVerde"> <h2> ALBERGHIERO </h2> </div>
                </div>
                <div class="tendinaCard" >
                    <h3>Corso Alberghiero</h3>
                    <button class="button-standard" value="alberghiero">READ</button>
                </div>
            </div>


            <div class="cardSU">
                <p class="next-tag">NEXT</p>
                <div class="imgCard" next="true" style="background-image: url('Images/Attivita/Informatica.jpg')">
                    <div class="covering sfondoBlu"> <h2> INFORMATICA </h2> </div>
                </div>
                <div class="tendinaCard" >
                    <h3>Corso Informatica</h3>
                    <button class="button-standard" value="informatica">READ</button>
                </div>
            </div>
        </div>

        <script type="text/javascript" src="javascript/scuola.js"></script>

    </section>

    <script src="./javascript/paginaVisitata.js" onload="incrementaCounterPagina('scuola.jsp')"></script>

</main>

<jsp:include page="footer.jsp"/>