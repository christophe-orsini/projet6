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
			<p class="h3">Publication d'un topo</p>
		</div>
		<div class="col-12">
			<c:if test="${not empty update}">
				<c:set var="path" value="/admin/enregistrerTopo" scope="page"/>
			</c:if>
			<c:if test="${empty update}">
				<c:set var="path" value="/inscrit/creerTopo" scope="page"/>
			</c:if>
			<form:form action="${path}" method="post" class="for-row form-inline" modelAttribute="topo">
				<form:hidden path="id" />			
				<form:label path="titre" class="col-12 col-sm-3">Titre :</form:label> 
				<form:input path="titre" class="form-control form-control-sm col-12 col-md-9" />						
				<form:label path="region" class="col-12 col-sm-3">Region :</form:label> 
				<form:input path="region" class="form-control form-control-sm col-12 col-md-9" />				
				<form:label path="description" class="col-12 col-sm-3">Description :</form:label> 
				<form:textarea path="description" class="form-control form-control-sm col-12 col-md-9" rows="5" />
				<div class="col-12">
					<div class="form-group"><ul class="list-unstyled">				
						<li><form:errors path="titre" cssClass="error text-danger" /></li>
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
</html>