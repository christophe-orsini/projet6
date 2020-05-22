<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<%@ include file="../theme/head.jsp" %>
<body>
<%@ include file="../theme/header.jsp" %>
<%@ include file="../theme/menu.jsp" %>
	<section>
		<div class="row">
			<div class="col">
				<p class="h3">Liste des sites</p>
			</div>
		</div>
		<table class="table table-striped table-bordered table-hoover">
			<caption>Cliquer sur l'utilisateur pour voir les détails</caption>
			<thead>
				<tr>
					<th>email</th>
					<th>Nom</th>
					<th>Prenom</th>
					<th>Role</th>
				</tr>
			</thead>	
			<tbody>
				<c:forEach items="${utilisateurs}" var="utilisateur" varStatus="status">
				<tr>
					<td><a href="detailUtilisateur/${utilisateur.id}">${utilisateur.email}</a></td>
					<td>${utilisateur.nom}</td>
					<td>${utilisateur.prenom}</td>
					<td>${utilisateur.role}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>
</body>
</html>