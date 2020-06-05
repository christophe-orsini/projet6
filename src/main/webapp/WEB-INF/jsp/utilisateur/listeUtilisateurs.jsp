<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<%@ include file="../theme/head.jsp" %>
<body class="container">
<%@ include file="../theme/header.jsp" %>
<%@ include file="../theme/menu.jsp" %>
	<section class="row">
		<div class="col-12">
			<p class="h3">Liste des utilisateurs</p>
		</div>
		<div class="col-12 table-responsive">
			<table class="table table-sm table-striped table-bordered">
				<thead>
					<tr>
						<th>email</th>
						<th>Nom</th>
						<th>Prenom</th>
						<th>Role</th>
						<th>Topos</th>
					</tr>
				</thead>	
				<tbody>
					<c:forEach items="${utilisateurs}" var="utilisateur" varStatus="status">
					<tr>
						<td>${utilisateur.email}</td>
						<td>${utilisateur.nom}</td>
						<td>${utilisateur.prenom}</td>
						<td>${utilisateur.role.getName()}</td>					
						<td><a class="btn btn-primary btn-sm" href="/inscrit/listeTopos/${utilisateur.id}">Liste</a></td>					
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</section>
</body>
</html>