<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false" %>     <!-- impedisce la creazione automatica della sessione -->
<jsp:include page="intestazione.jsp" />

<link rel="stylesheet" type="text/css" href="css/struttura.css">
<link rel="stylesheet" type="text/css" href="css/invioConfermato.css">

<main>

  <div id="container">
    <h1>MAIL INVIATA</h1>
    <button class="button-standard" onclick="esciDaConfermaInvio()">Torna Indietro</button>
  </div>

  <script>
    function esciDaConfermaInvio(){
      window.history.back();
    }
  </script>

</main>

<jsp:include page="footer.jsp"/>
