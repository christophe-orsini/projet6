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
			<p class="h3">${commentaire.site.nom}</p>	
		</div>	
		<div class="col-12">		
			<c:if test="${not empty update}">
				<c:set var="path" value="/inscrit/enregistrerCommentaire" scope="page"/>
			</c:if>
			<c:if test="${empty update}">
				<c:set var="path" value="/inscrit/creerCommentaire" scope="page"/>
			</c:if>
			<form:form action="${path}" method="post" modelAttribute="commentaire" class="form-row">
				<div class="form-group col-12">
					<form:hidden path="id" />
					<form:hidden path="site" />
					<form:label path="contenu">Commentaire :</form:label> 
					<form:textarea path="contenu" class="form-control" rows="4" />
					<form:errors path="contenu" cssClass="error text-danger"/>
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