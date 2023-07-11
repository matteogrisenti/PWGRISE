<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false" %>     <!-- impedisce la creazione automatica della sessione -->
<jsp:include page="intestazione.jsp" />

<%  HttpSession session = request.getSession(false); %>
<%  int id = 0;
    String username = "notLogged";
    String attivita = "notLogged";
    String role = "notLogged";
    ArrayList<String> arrayAttivita = new ArrayList<>();
    if(session!=null){
        id = Integer.parseInt(session.getAttribute("id").toString());
        username = session.getAttribute("username").toString();
        attivita = session.getAttribute("listaAttivita").toString();
        role = session.getAttribute("role").toString();
        for (String i: attivita.split(" - ")) {
            arrayAttivita.add(i);
        }
    } %>


<link rel="stylesheet" type="text/css" href="css/<%=role%>/iscrizioni.css">

<main>
    <section>
        <jsp:include page="simpOrAd.jsp" />

        <div class="container">
            <div class="box-iscrizione" id="Scuola">
                <h3>Scuola</h3>
                <p>
                    Iscrivendoti come volontario nella scuola di Tum4World, farai parte di una comunità solidale che crede nell'importanza dell'istruzione per tutti. Avrai l'opportunità di promuovere l'uguaglianza e l'accesso all'istruzione, regalando speranza e nuove prospettive ai giovani studenti. La tua partecipazione può fare la differenza nella loro vita e nel loro futuro.
                </p>
                <% if(!arrayAttivita.contains("Scuola")){ %>
                <button onclick="iscriviti('Scuola', <%=id%>, '<%=username%>')">Iscriviti</button>
                <% }else{ %>
                <p>Sei già iscritto a questa attivita</p>
                <% } %>
                <span class="count">1</span>
            </div>

            <div class="box-iscrizione" id="Navetta">
                <h3>Navetta</h3>
                <p>
                    Lavorare come autista volontario per Tum4World ti consentirà di fare la differenza nella vita di coloro che dipendono dal servizio di navetta per accedere a cibo, istruzione o altre risorse importanti. La tua iscrizione ti aprirà le porte a un'esperienza gratificante e significativa, offrendo un supporto fondamentale alle persone in situazioni di vulnerabilità.
                </p>
                <% if(!arrayAttivita.contains("Navetta")){ %>
                <button onclick="iscriviti('Navetta', <%=id%>, '<%=username%>')">Iscriviti</button>
                <% }else{ %>
                <p>Sei già iscritto a questa attivita</p>
                <% } %>
                <span class="count">2</span>
            </div>

            <div class="box-iscrizione" id="Mensa">
                <h3>Mensa</h3>
                <p>
                    L'iscrizione all'associazione di Tum4World è il primo passo per unirti al team di volontari impegnati nella mensa. Che tu sia un cuoco, amante della cucina, o semplicemente vuoi dare una mano nella mensa potrai condividere il tuo tempo, le tue competenze e la tua passione per aiutare gli altri, fornendo pasti e speranza alle persone che ne hanno bisogno.
                </p>
                <% if(!arrayAttivita.contains("Mensa")){ %>
                <button onclick="iscriviti('Mensa', <%=id%>, '<%=username%>')">Iscriviti</button>
                <% }else{ %>
                <p>Sei già iscritto a questa attivita</p>
                <% } %>
                <span class="count">3</span>
            </div>
        </div>
    </section>

    <script src="javascript/simpOrAd.js"></script>
    <script src="./javascript/paginaVisitata.js" onload="incrementaCounterPagina('iscrizioni.jsp')"></script>

</main>

<jsp:include page="footer.jsp"/>