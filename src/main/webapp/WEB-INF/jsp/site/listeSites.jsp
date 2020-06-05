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
	<section class="row justify-content-center">	
		<div class="col-12 border">
			<form:form action="/public/rechercheSite" method="post" class="form-row form-inline"
				modelAttribute="siteCherche">				
				<form:input path="nom" class="form-control form-control-sm col-12" placeholder="Nom" />						
				<form:input path="commune" class="form-control form-control-sm col-12 col-md-4" placeholder="Commune" />
				<form:input path="departement" class="form-control form-control-sm col-12 col-sm-6 col-md-4" placeholder="Departement" />
				<form:input path="pays" class="form-control form-control-sm col-12 col-sm-6 col-md-4" placeholder="Pays" />		
				<label class="col-12 col-sm-3 col-md-2">Nombre de :</label>
				<div class="input-group input-group-sm col-5 col-sm-3 col-md-2">
					<div class="input-group-prepend">
						<span class="input-group-text">Secteurs</span>
					</div>
					<form:input path="nbreSecteurs" class="form-control" type="number" />
				</div>
				<div class="input-group input-group-sm col-4 col-sm-3 col-md-2">
					<div class="input-group-prepend">
						<span class="input-group-text">Voies</span>
					</div>
					<form:input path="nbreVoies" class="form-control" type="number" />
				</div>											
				<input class="form-control form-control-sm col-3 col-sm-2 col-md-1" 
					type="text" name="cotation" placeholder="Cotation" value="${cotation}" />
				<div class="form-check form-check-inline col-4 col-md-2 ml-1">
					<form:checkbox path="tag" class="form-check-input" />
					<form:label path="tag" class="form-check-label">Officiel ?</form:label>						
				</div>
				<input class="btn btn-primary btn-sm ml-auto" type="submit" name="submit" value="Rechercher" />																		
			</form:form>	
		</div>
		<div class="col-12">
			<p class="h3">Liste des sites</p>
		</div>
		<div class="col-12 table-responsive">
			<table class="table table-sm table-striped table-bordered">
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
							<td><a class="btn btn-primary" href="/inscrit/modifierSite/${site.id}">Modifier</a></td>
						</c:if>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</section>
<%@ include file="../theme/footer.jsp" %>
</body>
</html>