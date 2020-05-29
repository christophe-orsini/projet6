<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<p class="h3">Création d'un utilisateur</p>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-5 col">
				<form:form action="/public/enregistrerUtilisateur" method="post" modelAttribute="utilisateur">
					<div class="form-group">
						<form:label path="email">Email</form:label> 
						<form:input  path="email" class="form-control" />
						<form:errors path="email" cssClass="error text-danger"/>
					</div>
					<div class="form-group">
						<form:label path="password">Mot de passe</form:label>
						<form:input path="password" class="form-control" />
						<form:errors path="password" cssClass="error text-danger"/>
					</div>
					<div class="form-group">
						<form:label path="nom">Nom</form:label>
						<form:input path="nom" class="form-control" />
						<form:label path="prenom">Prénom</form:label>
						<form:input path="prenom" class="form-control" />
					</div>
					<input class="btn btn-primary" type="submit" value="Enregistrer">
				</form:form>
			</div>
		</div>
	</section>
<%@ include file="../theme/footer.jsp" %>
</html>