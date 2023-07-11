<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false" %>     <!-- impedisce la creazione automatica della sessione -->
<jsp:include page="intestazione.jsp" />

<link rel="stylesheet" type="text/css" href="css/contatti.css">
<link rel="stylesheet" type="text/css" href="css/struttura.css">

<main id="mainContatti">

    <div class="cover">
        <h1> CONTATTI </h1>
        <h3 class="h3"> Istituto Tecnico Tum4World</h3>
    </div>

    <section id="sectionContatti">
        <h1 class="titolo">Contatti</h1>
        <p>Contattaci come preferisci</p>

        <div class="rowContatti">
            <div class="colContatti">
                <h3>Email</h3>
                <p>email: tum4world@nessunonoluogonoesiste.com </p>
            </div>
            <div class="colContatti">
                <h3>Telefono</h3>
                <p>contatto telefonico: +39 366 294 8933</p>
            </div>
            <div id="colContForm" class="colContatti">
                <h3>Tum4world</h3>
                <p>Clicca qui per compilare un piccolo modulo e verrai ricontattato dallo staff di Tum4World</p>
            </div>
        </div>

    </section>

    <script src="https://smtpjs.com/v3/smtp.js"></script>   <!-- libreria per inviare mail -->

    <div id="finestra-Ricontattami">
        <div id="Pop-Up-Ricontattami">

            <div class="closer" onclick="closeFormRicontattami()">
                <img src="Images/Attivita/iconaX.png" style="width: 30px" alt="Errore di visualizzazione del form">
            </div>
            <h2> RICONTATTAMI </h2>

            <div id="centra-form">
                <div class="spazio"></div>

                <form id="formRicontattami"  onreset="over_reset()">
                    <div class="inputRicontattami">
                        <label id="label_nome_cognome" for="nome_cognome" class="label">Nome e cognome</label>
                        <input type="text" name="nome_cognome" id="nome_cognome" placeholder="nome cognome" class="input">
                    </div>

                    <div class="inputRicontattami">
                        <label id="label_contatti-mail" for="contatti-mail" class="label">Email</label>
                        <input type="text" name="mail" id="contatti-mail" placeholder="email" required class="input">
                    </div>

                    <div class="inputRicontattami">
                        <label for="motivo" >Motivo</label>
                        <select name="motivo" id="motivo">
                            <option>collaborazione</option>
                            <option>grande donazione</option>
                            <option>altro</option>
                        </select>
                    </div>

                    <div class="inputRicontattami">
                        <label for="argomentazione">Argomentazione</label>
                        <textarea name="argomentazione" id="argomentazione" placeholder="argomentazione"></textarea>
                    </div>

                    <div class="inputRicontattami bottoniForm">
                        <button type="button" onclick="inviaMail()"> INVIA </button>
                        <button type="reset"> RESET </button>
                    </div>
                </form>

                <div class="spazio"></div>
            </div>

        </div>
    </div>

    <script type="text/javascript" src="javascript/contatti.js"></script>
    <script src="./javascript/paginaVisitata.js" onload="incrementaCounterPagina('contatti.jsp')"></script>

</main>

<jsp:include page="footer.jsp"/>