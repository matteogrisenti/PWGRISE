<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false" %>     <!-- impedisce la creazione automatica della sessione -->
<jsp:include page="intestazione.jsp"/>
<html>
<head>
    <title>Conferma Registrazione</title>
</head>
<body>
  <h1>La registrazione è avvenuta correttamente</h1>
  <script src="./javascript/paginaVisitata.js" onload="incrementaCounterPagina('signConfirmation.jsp')"></script>

</body>
</html>

<jsp:include page="footer.jsp" />
