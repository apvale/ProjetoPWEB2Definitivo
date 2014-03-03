<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="titulo" required="true" rtexprvalue="true" %>
<%@ attribute name="tituloPage" required="true" rtexprvalue="true" %>
<%@ tag body-content="scriptless" %>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>${titulo}</title>
        <link rel="stylesheet" href="<c:url value="/design/css/kickstart.css"/>" media="all" />
        <link type="text/css" rel="stylesheet" href="<c:url value="/design/css/projeto.css"/>" />
        <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
        <script src="<c:url value="/design/js/jquery.min.js"/>"></script>
        <script src="<c:url value="/design/js/kickstart.js"/>"></script>
	</head>
	<body>
		<h1><a style="text-decoration: none;" href="<c:url value="/inicio.jsp"/>">${tituloPage}</a></h1>
		<hr class="alt2" />
        <jsp:doBody/>
		<div class="footer">
			<i id="iconecafe" class="icon-coffee"></i>
			<p id="direitos">Projeto PWEB II - Amanda, Ana Paula e Erycsson</p>
		</div>
	</body>
</html>
