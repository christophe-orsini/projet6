<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<form action="/inscription" method="post">
					<div class="form-group">
						<label for="email">Email</label> 
						<input type="text" class="form-control" name="email" id="email" value="${utilisateur.email}" />
						<label for="motpasse">Mot de passe</label>
						<input type="password" class="form-control" name="password" id="password" value="${utilisateur.password}"/>
					</div>
					<div class="form-group">
						<label for="nom">Nom</label>
						<input type="text" class="form-control" name="nom" id="nom" value="${utilisateur.nom}"/>
						<label for="prenom">Prénom</label>
						<input type="text" class="form-control" name="prenom" id="prenom" value="${utilisateur.prenom}"/>
					</div>
					<input class="btn btn-primary" type="submit" name="submit" value="Enregistrer">
				</form>
			</div>
		</div>
	</section>
<%@ include file="../theme/footer.jsp" %>
</html>