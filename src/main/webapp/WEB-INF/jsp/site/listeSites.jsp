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
			<div class="col border">
				<form:form action="/public/rechercheSite" method="post" modelAttribute="siteCherche">	
					<div class="form-inline">
						<form:label path="nom" class="mr-3">Nom :</form:label> 
						<form:input path="nom" class="form-control form-control-sm mr-3" />						
						<form:label path="commune" class="mr-3">Commune :</form:label> 
						<form:input path="commune" class="form-control form-control-sm" />
						<form:label path="departement" class="ml-3 mr-3">Departement :</form:label> 
						<form:input path="departement" class="form-control form-control-sm" style="width:6em" />
						<form:label path="pays" class="ml-3 mr-3">Pays :</form:label> 
						<form:input path="pays" class="form-control form-control-sm" style="width:6em" />						
					</div>
					<div class="form-inline">
						<form:label path="nbreSecteurs" class="mr-3">Nombre de Secteurs :</form:label> 
						<form:input path="nbreSecteurs" class="form-control form-control-sm" type="number" style="width:4em" />
						<form:label path="nbreVoies" class="ml-3 mr-3"> Voies :</form:label> 
						<form:input path="nbreVoies" class="form-control form-control-sm" type="number" style="width:4em" />						
						<label class="ml-3 mr-3" for="cotation">Cotation : </label> 					
						<input class="form-control form-control-sm" type="text" name="cotation" id="cotation" 
							value="${cotation}" size="3" />
						<form:checkbox path="tag" class="form-check-input ml-3" />
						<form:label path="tag" class="form-check--label ml-2">Officiel ?</form:label>						
					</div>						
					<input class="btn btn-primary ml-auto mr-auto" type="submit" name="submit" value="Rechercher" />										
				</form:form>
			</div>		
		</div>
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
						<td><a class="btn btn-primary" href="/inscrit/modifierSite/${site.id}">Modifier</a></td>
					</c:if>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>
<%@ include file="../theme/footer.jsp" %>
</body>
</html>