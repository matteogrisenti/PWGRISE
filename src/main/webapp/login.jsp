<jsp:include page="intestazione.jsp" />
<%@ page session="false" %>     <!-- impedisce la creazione automatica della sessione -->

<main>
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <link rel="stylesheet" type="text/css" href="css/struttura.css">

    <sectionLogin>
        <div class="riquadro">
            <form action="${pageContext.request.contextPath}/login" method="POST" id="formLogin">
                <h2>Login</h2>
                <div class="inputLogin">
                    <ion-icon name="mail-outline"></ion-icon>
                    <label for="loginUsername"></label><input type="text" required value="admin" name="username" id="loginUsername">
                    <label>Username</label>
                </div>
                <div class="inputLogin">
                    <ion-icon name="lock-closed-outline"></ion-icon>
                    <label for="loginPassword"></label><input type="password" required value="21Adm1n!" name="password" id="loginPassword">
                    <label>Password</label>
                </div>
                <button type="button" class="mostra-password" onclick="mostraOrNascondiPassword('loginPassword')">Mostra/Nascondi password</button>
                <button class="button-standard" type="submit">Login</button>
                <div class="registrazione">
                    <p>Non hai un account? <a href="signUp.jsp">Registrati</a></p>
                </div>
            </form>
        </div>
    </sectionLogin>
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
    <script src="./javascript/signUp.js"></script>

    <script src="./javascript/paginaVisitata.js" onload="incrementaCounterPagina('login.jsp')"></script>

</main>

<jsp:include page="footer.jsp"/>

