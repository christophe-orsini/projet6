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
				<p class="h3">Votre commentaire pour le site ${commentaire.site.nom}</p>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<c:if test="${not empty update}">
					<c:set var="path" value="/inscrit/enregistrerCommentaire" scope="page"/>
				</c:if>
				<c:if test="${empty update}">
					<c:set var="path" value="/inscrit/creerCommentaire" scope="page"/>
				</c:if>
				<form:form action="${path}" method="post" modelAttribute="commentaire">
					<div class="form-group">
						<form:hidden path="id" />
						<form:hidden path="site" />
						<form:label path="contenu" class="mr-3">Commentaire :</form:label> 
						<form:textarea path="contenu" class="form-control" rows="5" />
						<form:errors path="contenu" cssClass="error text-danger"/>
					</div>
					<c:if test="${not empty update}">
						<input class="btn btn-primary" type="submit" value=Enregistrer />
					</c:if>
					<c:if test="${empty update}">
						<input class="btn btn-primary" type="submit" value="Publier" />
					</c:if>
					<sec:authorize access="hasAnyRole('ROLE_MEMBER', 'ROLE_ADMINISTRATEUR')">
						<a class="btn btn-primary" href="/membre/supprimerCommentaire/${commentaire.id}">Supprimer</a>
					</sec:authorize>
				</form:form>
			</div>
		</div>
	</section>
<%@ include file="../theme/footer.jsp" %>
</html>