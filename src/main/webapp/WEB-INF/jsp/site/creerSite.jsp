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
				<p class="h3">Création d'un site</p>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<c:if test="${not empty update}">
					<c:set var="path" value="/inscrit/enregistrerSite" scope="page"/>
				</c:if>
				<c:if test="${empty update}">
					<c:set var="path" value="/inscrit/creerSite" scope="page"/>
				</c:if>
				<form:form action="${path}" method="post" modelAttribute="site">
				<form:hidden path="id" />
					<div class="form-inline">
						<form:label path="nom" class="mr-3">Nom :</form:label> 
						<form:input path="nom" class="form-control form-control-sm mr-3" />					
					</div>
					<div class="form-inline">
						<form:label path="description" class="mr-3">Description :</form:label> 
						<form:input path="description" class="form-control form-control-sm" />
					</div>
					<div class="form-inline">
						<form:label path="commune" class="mr-3">Commune :</form:label> 
						<form:input path="commune" class="form-control form-control-sm" />					
						<form:label path="departement" class="ml-3 mr-3">Departement :</form:label>						
						<form:input path="departement" class="form-control form-control-sm" />
						<form:label path="pays" class="ml-3 mr-3">Pays :</form:label> 
						<form:input path="pays" class="form-control form-control-sm" />
					</div>
					<div class="form-inline">
						<form:label path="latitude" class="mr-3">Latitude :</form:label> 
						<form:input path="latitude" class="form-control form-control-sm" type="number" min="-90" max="90" step="0.0001" style="width:8em" />
						<form:label path="longitude" class="ml-3 mr-3">Longitude :</form:label> 
						<form:input path="longitude" class="form-control form-control-sm" type="number" min="-180" max="180" step="0.0001" style="width:8em" />
					</div>
					<div class="form-inline">
						<form:label path="nbreSecteurs" class="mr-3">Nombre de secteurs :</form:label> 
						<form:input path="nbreSecteurs" class="form-control form-control-sm" type="number" style="width:4em" />
						<form:label path="nbreVoies" class="ml-3 mr-3"> Voies :</form:label> 
						<form:input path="nbreVoies" class="form-control form-control-sm" type="number" style="width:4em" />
						<form:label path="nbreLongueurs" class="ml-3 mr-3"> Longueurs :</form:label> 
						<form:input path="nbreLongueurs" class="form-control form-control-sm" type="number" style="width:4em" />
						<form:label path="nbreRelais" class="ml-3 mr-3"> Relais :</form:label> 
						<form:input path="nbreRelais" class="form-control form-control-sm" type="number" style="width:4em" />
					</div>
					<div class="form-inline">
						<form:label path="cotationMini" class="mr-3">Cotation : mini :</form:label> 
						<form:input path="cotationMini" class="form-control form-control-sm" size="3" />
						<form:label path="cotationMaxi" class="ml-3 mr-3">maxi :</form:label> 
						<form:input path="cotationMaxi" class="form-control form-control-sm" size="3" /><br/>
					</div>
					<div class="row">
						<div class="col">
							<div class="form-group"><ul class="list-unstyled">
								<li><form:errors path="nom" cssClass="error text-danger" /></li>
								<li><form:errors path="commune" cssClass="error text-danger" /></li>
								<li><form:errors path="departement" cssClass="error text-danger" /></li>
								<li><form:errors path="pays" cssClass="error text-danger" /></li>
								<li><form:errors path="latitude" cssClass="error text-danger" /></li>
								<li><form:errors path="longitude" cssClass="error text-danger" /></li>
								<li><form:errors path="nbreSecteurs" cssClass="error text-danger" /></li>
								<li><form:errors path="nbreVoies" cssClass="error text-danger" /></li>
								<li><form:errors path="nbreRelais" cssClass="error text-danger" /></li>
								<li><form:errors path="cotationMini" cssClass="error text-danger" /></li>
								<li><form:errors path="cotationMaxi" cssClass="error text-danger" /></li>
							</ul></div>
						</div>
					</div>
					<c:if test="${not empty update}">
						<input class="btn btn-primary" type="submit" value=Enregistrer />
					</c:if>
					<c:if test="${empty update}">
						<input class="btn btn-primary" type="submit" value="Publier" />
					</c:if>
				</form:form>
			</div>
		</div>
	</section>
<%@ include file="../theme/footer.jsp" %>
</html>