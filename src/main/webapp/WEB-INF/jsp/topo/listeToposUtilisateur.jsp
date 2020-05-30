<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<%@ include file="../theme/head.jsp" %>
<body>
<%@ include file="../theme/header.jsp" %>
<%@ include file="../theme/menu.jsp" %>
	<section class="container">	
		<div class="row">
			<div class="col">
				<p class="h3">Liste de vos topos</p>
			</div>
		</div>
		<table class="table table-striped table-bordered table-hoover">
			<caption>Cliquer sur le nom du topo pour voir les détails</caption>
			<thead>
				<tr>
					<th>Titre</th>
					<th>Region</th>
					<th>Description</th>
					<th>Status des demandes</th>
				</tr>
			</thead>	
			<tbody>
				<c:forEach items="${topos}" var="topo" varStatus="status">
				<tr>
					<td><a href="/inscrit/detailTopo/${topo.id}">${topo.titre}</a></td>
					<td>${topo.region}</td>
					<td>${topo.description}</td>
					<td><c:if test="${!topo.disponible}">
						<c:if test="${topo.demande}">
							<a class="btn btn-primary" href="/inscrit/accepterDemandeTopo/${topo.id}" data-toggle="tooltip"
								title="Demandé par ${topo.emprunteur.email}">Accepter</a>
								<a class="btn btn-primary" href="/inscrit/retourTopo/${topo.id}" data-toggle="tooltip"
								title="Demandé par ${topo.emprunteur.email}">Refuser</a>
						</c:if>
						<c:if test="${!topo.demande}">
							<a class="btn btn-primary" href="/inscrit/retourTopo/${topo.id}">Retour</a>
						</c:if>
					</c:if></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>
<%@ include file="../theme/footer.jsp" %>
</body>
</html>