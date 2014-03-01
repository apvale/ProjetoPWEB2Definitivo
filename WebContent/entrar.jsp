<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="h" tagdir="/WEB-INF/tags" %>

        <%-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="<c:url value="/design/js/kickstart.js"/>"></script> <!-- KICKSTART -->
         --%>
        <h:header titulo="Fazer Login" tituloPage="Realizar Login"/>
	   
	   
	    <div class="login">	     
	           <form id="form" action="<c:url value="/entrar"/>" method="post" class="vertical">
		             <label for="login"></label>
		                <input id="login" type="text" placeholder="Login" name="login" />
		                
		                <label for="senha"></label>
		                <input id="senha" type="password" placeholder="Senha"  name="senha" />
		                
		                <button type="submit">Entrar</button>
		                <a class="button" href="<c:url value="/inicio.jsp"/>">Voltar</a>
                        <a class="button" href="<c:url value="/recuperar-senha.jsp"/>">Recuperar Senha</a>
		       </form>
	       </div>
	    <h:footer/>
	</body>
</html>