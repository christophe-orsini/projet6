<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<%@ include file="../theme/head.jsp" %>
<body class="container">
<%@ include file="../theme/header.jsp" %>
<%@ include file="../theme/menu.jsp" %>
	<section class="row justify-content-center">
		<div class="col-12">
			<p class="h3">Détail du site N° <c:out value="${site.id}" />
			<sec:authorize access="hasAnyRole('ROLE_ADMINISTRATEUR')">
				<a class="btn btn-primary btn-sm ml-3" href="/inscrit/modifierSite/${site.id}">Modifier</a>
			</sec:authorize></p>
		</div>
		<div class="col-12">
			<div class="row col-12">
				<p>Nom : ${site.nom} <c:if test="${site.tag}"><span class="badge badge-secondary">Officiel</span></c:if>
				<sec:authorize access="hasAnyRole('ROLE_MEMBRE', 'ROLE_ADMINISTRATEUR')">
					<c:set var="buttonContent" value="Taguer" scope="page" />
					<c:if test="${site.tag == true}">
						<c:set var="buttonContent" value="Retirer le tag" scope="page" />
					</c:if>
					<a class="btn btn-primary btn-sm ml-3" href="/membre/taguerSite/${site.id}"><c:out value="${buttonContent}" /></a>
				</sec:authorize></p>
			</div>
			<div class="row col-12">
				<p>Description : ${site.description}</p> 
			</div>
			<div class="row col-12">
				<p class="col-md-4 p-0">Commune : ${site.commune}<p>
				<p class="col-7 col-md-4 p-0">Departement : ${site.departement}<p>
				<p class="col-5 col-md-4 p-0">Pays : ${site.pays}<p>
			</div>
			<div class="row col-12">
				<p class="col-6 p-0">Latitude : ${site.latitude}</p>
				<p class="col-6 p-0">Longitude : ${site.longitude}</p>
			</div>
			<div class="row col-12">
				<p class="col-6 col-md-3 p-0">Secteurs : ${site.nbreSecteurs}</p>
				<p class="col-6 col-md-3 p-0">Voies : ${site.nbreVoies}</p>
				<p class="col-6 col-md-3 p-0">Longueurs : ${site.nbreLongueurs}</p>
				<p class="col-6 col-md-3 p-0">Relais : ${site.nbreRelais}</p>
			</div>
			<div class="row col-12">
				<p class="col-6 p-0">Cotation mini : ${site.cotationMini}</p>
				<p class="col-6 p-0">Cotation maxi : ${site.cotationMaxi}</p>
			</div>	
			<div class="row col-12">
				<sec:authorize access="isAuthenticated()">
					<div class="col-12">
						<a class="btn btn-primary btn-sm" href="/inscrit/commenter/${site.id}">Commenter</a>
					</div>
				</sec:authorize>
				<c:forEach items="${site.commentaires}" var="commentaire" varStatus="status">
					<div class="col-12 row">
						<p class="col-12 col-md-4 mb-0 bg-light">Le <fmt:formatDate type="BOTH" pattern="dd/MM/yy HH:mm" value="${commentaire.dateModification}"/> 									
						${commentaire.auteur.nom}</p>
						<p class="col-12 col-md-6 mb-0">${commentaire.contenu}</p>
						<sec:authorize access="hasAnyRole('ROLE_MEMBRE', 'ROLE_ADMINISTRATEUR')">
							<div class="col-12 col-md-2 mb-1 p-0">					
								<a class="btn btn-primary btn-sm p-1" href="/membre/modifierCommentaire/${commentaire.id}">Modifier</a>
								<a class="btn btn-warning btn-sm p-1" href="/membre/supprimerCommentaire/${commentaire.id}">Supprimer</a>						
							</div>
						</sec:authorize>
					</div>
				</c:forEach>									
			</div>			
		</div>
	</section>
<%@ include file="../theme/footer.jsp" %>
</body>
</html>