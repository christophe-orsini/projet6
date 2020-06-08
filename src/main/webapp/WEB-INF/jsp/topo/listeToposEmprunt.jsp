<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<%@ include file="../theme/head.jsp" %>
<body class="container">
<%@ include file="../theme/header.jsp" %>
<%@ include file="../theme/menu.jsp" %>
	<section class="row">
		<div class="col-12">
			<p class="h3">Liste des topos</p>
		</div>
		<div class="col-12 table-responsive">
			<table class="table table-sm table-striped table-bordered">
				<caption>Cliquer sur le nom du topo pour voir les détails</caption>
				<thead>
					<tr>
						<th>Titre</th>
						<th>Region</th>
						<th>Description</th>
						<th>Contact</th>
						<th>Statut</th>
					</tr>
				</thead>	
				<tbody>
					<c:forEach items="${topos}" var="topo" varStatus="status">
					<tr>
						<td><a href="/inscrit/detailTopo/${topo.id}">${topo.titre}</a></td>
						<td>${topo.region}</td>
						<td>${topo.description}</td>
						<c:if test="${!topo.disponible}">
							<c:if test="${topo.demande}"><td></td></c:if>
							<c:if test="${!topo.demande}"><td>${topo.proprietaire.email}</td></c:if>							
						</c:if>
						<td>
							<c:if test="${topo.disponible}">
								<a class="btn btn-primary btn-sm" href="/inscrit/reserverTopo/${topo.id}">Réserver</a>
							</c:if>
							<c:if test="${!topo.disponible}">
								<c:if test="${topo.demande}">En attente</c:if>
								<c:if test="${!topo.demande}">En prêt</c:if>							
							</c:if>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>	
	</section>
<%@ include file="../theme/footer.jsp" %>
</body>
</html>