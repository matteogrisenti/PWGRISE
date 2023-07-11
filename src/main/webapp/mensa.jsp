<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false" %>     <!-- impedisce la creazione automatica della sessione -->
<jsp:include page="intestazione.jsp" />

<link rel="stylesheet" type="text/css" href="css/struttura.css">
<link rel="stylesheet" type="text/css" href="css/mensa.css">

<main>
    <div class="cover">
        <h1> MENSA </h1>
        <h3> Istituto Tecnico Tum4World</h3>
    </div>

    <section>
        <div class="row">
            <div class="col">
                <h1>Mensa</h1>
                <p>
                    Riconosciamo che una corretta alimentazione svolge un ruolo cruciale nel benessere e nella crescita dei ragazzi.
                    Pertanto, collaboriamo strettamente con fornitori locali per garantire l'approvvigionamento d'ingredienti freschi come pane e verdure.
                    Ci sforziamo di garantire un pasto sicuro per ogni ragazzo, di qualità ed equilibrato che non sempre le famiglie riescono a fornirgli.
                    Il nostro obiettivo è quello di assicurare che ogni bambino riceva una nutrizione adeguata durante il loro tempo a scuola,
                    contribuendo così al loro benessere complessivo e al loro successo accademico.
                </p>
            </div>
            <div class="col">
                <div class="cover" style="background-image: url('Images/Attivita/pane.jpg')"></div>
                <!-- <img src="Images/Attivita/pane.jpg"> -->
            </div>
        </div>

    </section>

    <script src="./javascript/paginaVisitata.js" onload="incrementaCounterPagina('mensa.jsp')"></script>

</main>

<jsp:include page="footer.jsp"/>
