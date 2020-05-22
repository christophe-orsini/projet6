<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<%@ include file="../theme/head.jsp" %>
<body>
<%@ include file="../theme/header.jsp" %>
<%@ include file="../theme/menu.jsp" %>
	<section class="container">
		<div class="row">
			<div class="col">
				<p class="h3">Liste des sites</p>
			</div>
		</div>
		<table class="table table-striped table-bordered table-hoover">
			<caption>Cliquer sur le nom du site pour voir les détails</caption>
			<thead>
				<tr>
					<th>Publier le</th>
					<th>Nom</th>
					<th colspan="2">Lieu</th>
					<th>Pays</th>
					<th>Description</th>
					<th>Site officiel</th>
				</tr>
			</thead>	
			<tbody>
				<c:forEach items="${sites}" var="site" varStatus="status">
				<tr>
					<td><fmt:formatDate value="${ site.datePublication }" type="date" /></td>
					<td><a href="/public/detailSite/${site.id}">${site.nom}</a></td>
					<td colspan="2">${site.commune} ${site.departement}</td>
					<td>${site.pays}</td>
					<td>${site.description}</td>
					<td><c:if test="${site.tag}">Oui</c:if></td>
					<c:if test="${not empty utilisateur}">
						<td><a class="btn btn-primary" href="/inscrit/modifiersite/${site.id}">Modifier</a></td>
					</c:if>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>
<%@ include file="../theme/footer.jsp" %>
</body>
</html>