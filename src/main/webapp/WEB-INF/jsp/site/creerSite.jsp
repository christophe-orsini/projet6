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
		<div class="col-12">
			<c:if test="${not empty update}">
				<p class="h3">Modification du site N° ${site.id}</p>
			</c:if>
			<c:if test="${empty update}">
				<p class="h3">Publication d'un site</p>
			</c:if>				
		</div>
		<c:if test="${not empty update}">
			<c:set var="path" value="/inscrit/enregistrerSite" scope="page"/>
		</c:if>
		<c:if test="${empty update}">
			<c:set var="path" value="/inscrit/creerSite" scope="page"/>
		</c:if>
		<div class="col-12">
			<form:form action="${path}" method="post" class="form-row form-inline"
				modelAttribute="site">
				<form:hidden path="id" />		
				<form:label path="nom" class="col-12 col-sm-3">Nom :</form:label> 
				<form:input path="nom" class="form-control form-control-sm col-12 col-sm-9" />					
				<form:label path="description" class="col-12 col-sm-3">Description :</form:label> 
				<form:input path="description" class="form-control form-control-sm col-12 col-sm-9" />		
				<form:label path="commune" class="col-4 col-sm-3">Commune :</form:label> 
				<form:input path="commune" class="form-control form-control-sm col-8 col-sm-9" />					
				<form:label path="departement" class="col-4 col-sm-3">Departement :</form:label>						
				<form:input path="departement" class="form-control form-control-sm col-8 col-sm-4" />
				<form:label path="pays" class="col-4 col-sm-2">Pays :</form:label> 
				<form:input path="pays" class="form-control form-control-sm col-8 col-sm-3" />
				<div class="col-12 col-md-6 offset-md-3 row">
					<div class="input-group input-group-sm col-6">
						<div class="input-group-prepend">
							<span class="input-group-text">Latitude</span>
						</div>
						<form:input path="latitude" class="form-control" type="number" 
						min="-90" max="90" step="0.0001" lang="en-US" />
					</div>
					<div class="input-group input-group-sm col-6">
						<div class="input-group-prepend">
							<span class="input-group-text">Longitude</span>
						</div>
						<form:input path="longitude" class="form-control" type="number" 
						min="-180" max="180" step="0.0001" lang="en-US" />
					</div>
				</div>
				<div class="col-12 col-md-8 offset-md-2 row">
					<div class="input-group input-group-sm col-6 col-md-3">
						<div class="input-group-prepend">
							<span class="input-group-text">Secteurs</span>
						</div>
						<form:input path="nbreSecteurs" class="form-control" type="number" />
					</div>
					<div class="input-group input-group-sm col-6 col-md-3">
						<div class="input-group-prepend">
							<span class="input-group-text">Voies</span>
						</div>
						<form:input path="nbreVoies" class="form-control" type="number" />
					</div>
					<div class="input-group input-group-sm col-6 col-md-3">
						<div class="input-group-prepend">
							<span class="input-group-text">Longueurs</span>
						</div>
						<form:input path="nbreLongueurs" class="form-control" type="number" />
					</div>
					<div class="input-group input-group-sm col-6 col-md-3">
						<div class="input-group-prepend">
							<span class="input-group-text">Relais</span>
						</div>
						<form:input path="nbreRelais" class="form-control" type="number" />
					</div>
				</div>
				<div class="col-12 col-md-6 offset-md-3 row">
					<label class="col-4">Cotation : </label> 
					<div class="input-group input-group-sm col-4">
						<div class="input-group-prepend">
							<span class="input-group-text">Mini</span>
						</div>
						<form:input path="cotationMini" class="form-control" />
					</div>
					<div class="input-group input-group-sm col-4">
						<div class="input-group-prepend">
							<span class="input-group-text">Maxi</span>
						</div>
						<form:input path="cotationMaxi" class="form-control" />
					</div>
				</div>		
				<div class="col-12">
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
							
				<c:if test="${not empty update}">
					<input class="btn btn-primary btn-sm" type="submit" value=Enregistrer />
				</c:if>
				<c:if test="${empty update}">
					<input class="btn btn-primary btn-sm" type="submit" value="Publier" />
				</c:if>				
			</form:form>
		</div>
	</section>
<%@ include file="../theme/footer.jsp" %>
</body>
</html>