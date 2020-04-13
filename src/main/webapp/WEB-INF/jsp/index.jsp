<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Les amis de l'escalade)</title>
</head>
<header>
	<H1>Les Amis de l'Escalade</H1>
</header>
<nav>
	<button>Connexion</button>
	<button>S'inscrire</button>
</nav>
<body>
	<table border="1">
	<caption>Cliquer sur le nom du site pour voir les détails</caption>
	<thead>
		<tr>
			<th>Publier le</th>
			<th>Nom</th>
			<th colspan="2">Lieu</th>
			<th>Pays</th>
			<th>Description</th>
			<th>Officiel</th>
		</tr>
	</thead>	
	<tbody>
		<c:forEach items="${ sites }" var="site" varStatus="status">
		<tr>
			<td><fmt:formatDate value="${ site.datePublication }" type="date" /></td>
			<td><a href="#"><c:out value="${ site.nom }" /></a></td>
			<td colspan="2"><c:out value="${ site.commune }" /> <c:out value="${ site.departement }" /></td>
			<td><c:out value="${ site.pays }" /></td>
			<td><c:out value="${ site.description }" /></td>
			<td><input type="checkbox" checked="<c:out value="${ site.tag }" />" readonly /></td>
		</tr>
		</c:forEach>
	</tbody>
	</table>
</body>
<footer>

</footer>
</html>