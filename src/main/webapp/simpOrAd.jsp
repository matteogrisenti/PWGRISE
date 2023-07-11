
<%@ page session="false" %>     <!-- impedisce la creazione automatica della sessione -->



<%-- Controllo se è loggato --%>
<%  HttpSession session = request.getSession(false); %>
<%  String role = "notLogged", username = "notLogged";
    if(session!=null){
        role = session.getAttribute("role").toString();
        username = session.getAttribute("username").toString();
    } %>

<main>

    <link rel="stylesheet" type="text/css" href="css/<%=role%>/menuAreaPersonale.css">

    <h2>Utente: <span><%=username%></span></h2>
    <h2>Area: <span><%=role%></span></h2>


    <div class="barra">
        <ul class="lista">
            <li class="elemento">
                <a href="profilo.jsp">
                    <div class="icon">
                        <ion-icon name="accessibility-outline" ></ion-icon>
                        <ion-icon name="accessibility-outline" ></ion-icon>
                    </div>
                    <div class="testo"><span data-text="Profilo">Profilo</span></div>
                </a>
            </li>
            <li class="elemento">
                <a href="iscrizioni.jsp">
                    <div class="icon">
                        <ion-icon name="bus-outline"></ion-icon>
                        <ion-icon name="bus-outline"></ion-icon>
                    </div>
                    <div class="testo"><span data-text="Iscriviti">Iscriviti</span></div>
                </a>
            </li>
            <%if(role.equals("aderente")){ %>
            <li class="elemento" id="idLiDonazioni">
                <a href="donazioni.jsp">
                    <div class="icon" id="idDivDonazioni">
                        <ion-icon name="gift-outline"></ion-icon>
                        <ion-icon name="gift-outline"></ion-icon>
                    </div>
                    <div class="testo"><span data-text="Dona">Dona</span></div>
                </a>
            </li>
            <%}%>
            <li class="elemento">
                <a href="eliminaAccount.jsp">
                    <div class="icon">
                        <ion-icon name="trash-outline"></ion-icon>
                        <ion-icon name="trash-outline"></ion-icon>
                    </div>
                    <div class="testo"><span data-text="Elimina">Elimina</span></div>
                </a>
            </li>
        </ul>
    </div>

    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>

</main>




