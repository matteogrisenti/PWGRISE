<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false" %>     <!-- impedisce la creazione automatica della sessione -->
<jsp:include page="intestazione.jsp" />

<link rel="stylesheet" type="text/css" href="css/struttura.css">

<style>
  #container{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    height: 50%;
    min-height: 600px;
    width: 100%;
  }
  #container a{
    color: rgb(88, 129, 87);
    text-decoration: none;
    font-weight: 600;
  }
</style>

<main>

  <div id="container">
    <h1>REGISTRAZIONE AVVENUTA CORRETTAMENTE</h1>
    <a href="login.jsp">vai al login</a>
  </div>

</main>


<jsp:include page="footer.jsp"/>
