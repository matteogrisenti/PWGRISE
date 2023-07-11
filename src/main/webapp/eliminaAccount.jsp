<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false" %>     <!-- impedisce la creazione automatica della sessione -->
<jsp:include page="intestazione.jsp" />

<%  HttpSession session = request.getSession(false); %>
<%  int id = 0; String role ="notLogged";
  if(session!=null){
    id = Integer.parseInt(session.getAttribute("id").toString());
    role = session.getAttribute("role").toString();
  } %>

<link rel="stylesheet" type="text/css" href="css/struttura.css">
<link rel="stylesheet" type="text/css" href="css/<%=role%>/donazioni.css">
<script src="javascript/simpOrAd.js"></script>

<main>

  <section>
    <jsp:include page="simpOrAd.jsp" />
    <div class="pagina">
      <div class="box">
        <div class="titolo">
          <header>Sei sicuro di voler eliminare l'account?</header>
        </div>
        <div class="bottone">
          <button class="button-standard" id="bottone" onclick="eliminaAccount(<%=id%>)">Conferma</button>
        </div>
      </div>
    </div>


  </section>

  <script src="./javascript/paginaVisitata.js" onload="incrementaCounterPagina('eliminaAccount.jsp')"></script>

</main>

<jsp:include page="footer.jsp"/>