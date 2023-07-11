<jsp:include page="intestazione.jsp" />
<%@ page session="false" %>     <!-- impedisce la creazione automatica della sessione -->

<%  HttpSession session = request.getSession(false); %>
<%  String username = "notLogged", name = "notLogged", surname = "notLogged", mail = "notLogged", birth = "notLogged", phone_number = "notLogged", role = "notLogged", listaAttivita = "notLogged";
    if(session!=null){
        username = session.getAttribute("username").toString();
        name = session.getAttribute("name").toString();
        surname = session.getAttribute("surname").toString();
        mail = session.getAttribute("mail").toString();
        birth = session.getAttribute("date_of_birth").toString();
        phone_number = session.getAttribute("phone_number").toString();
        role = session.getAttribute("role").toString();
        listaAttivita = session.getAttribute("listaAttivita").toString();
    } %>


<link rel="stylesheet" type="text/css" href="css/struttura.css">
<link rel="stylesheet" type="text/css" href="css/<%=role%>/profilo.css">

<main>
    <section>
      <jsp:include page="simpOrAd.jsp" />
      <div class="box">
          <div class="user">
              <span class="attributo">Username:</span>
              <span class="valore"><%=username%></span>
          </div>
          <div class="user">
              <span class="attributo">Nome:</span>
              <span class="valore"><%=name%></span>
          </div>
          <div class="user">
              <span class="attributo">Cognome:</span>
              <span class="valore"><%=surname%></span>
          </div>
          <div class="user">
              <span class="attributo">Email:</span>
              <span class="valore"><%=mail%></span>
          </div>
          <div class="user">
              <span class="attributo">Telefono:</span>
              <span class="valore"><%=phone_number%></span>
          </div>
          <div class="user">
              <span class="attributo">Data di nascita:</span>
              <span class="valore"><%=birth%></span>
          </div>
          <div class="user">
              <span class="attributo">Ruolo:</span>
              <span class="valore"><%=role%></span>
          </div>
          <div class="user">
              <span class="attributo">Attivit&agrave; alla quale sei iscritto:</span>
              <span class="valore"><%=listaAttivita%></span>
          </div>
      </div>
  </section>

    <script src="./javascript/paginaVisitata.js" onload="incrementaCounterPagina('profilo.jsp')"></script>

</main>

<jsp:include page="footer.jsp"/>

