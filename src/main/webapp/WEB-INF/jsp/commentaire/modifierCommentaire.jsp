<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<%@ include file="../theme/head.jsp" %>
<body>
<%@ include file="../theme/header.jsp" %>
<%@ include file="../theme/menu.jsp" %>
	<section class="container">
		<div class="row">
			<div class="col">
				<p class="h3">Détail du commentaire N° <c:out value="${commentaire.id}" />
				<sec:authorize access="hasAnyRole('ROLE_MEMBRE', 'ROLE_ADMINISTRATEUR')">
					<a class="btn btn-primary" href="/membre/modifierCommentaire/${commentaire.id}">Modifier</a>
				</sec:authorize></p>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<form>
					<div class="form-inline">
						<label class="mr-3" for="datePub">Date de publication :</label> 
						<input class="form-control form-control-sm mr-3" type="text" name="datePub" id="datePub" value="${commentaire.datePublication}" readonly />
						<label class="mr-3" for="nom">dernière modification le :</label> 
						<input class="form-control form-control-sm mr-3" type="text" name="dateModif" id="nom" value="${commentaire.dateModification}" readonly />
					</div>
					<div class="form-inline">
						<label class="mr-3" for="description">Par :</label> 
						<input class="form-control form-control-sm" type="text" name="description" id="description"	
							value="${commentaire.auteur.nom}" readonly />
					</div>
					<div class="form-inline">
						<label class="mr-3" for="description">Commentaire :</label> 
						<input class="form-control form-control-sm" type="text" name="description" id="description"	
							value="${commentaire.contenu}" readonly />
					</div>
				</form>
			</div>
		</div>
	</section>
<%@ include file="../theme/footer.jsp" %>
</html>