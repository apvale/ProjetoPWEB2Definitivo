<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="titulo" required="true" rtexprvalue="true" %>
<%@ attribute name="tituloPage" required="true" rtexprvalue="true" %>

<html>
<head>
	<script src="<c:url value="/design/js/jquery.min.js"/>"></script>
	<script src="<c:url value="/design/js/kickstart.js"/>"></script>
	<!-- KICKSTART -->
 	<link rel="stylesheet" href="<c:url value="/design/css/kickstart.css"/>" media="all" />
    <link type="text/css" rel="stylesheet" href="<c:url value="/design/css/projeto.css"/>"/>
    <meta charset="UTF-8" />
    <title>${titulo}</title>
</head>

<body>

	<a style="text-decoration: none;" href="<c:url value="/inicio.jsp"/>"><h1>${tituloPage}</h1></a>
	<hr class="alt2" />
