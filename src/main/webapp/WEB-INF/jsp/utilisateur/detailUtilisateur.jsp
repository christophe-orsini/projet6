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
				<p class="h3">Détail d'un utilisateur</p>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-5 col">
				<form>
					<div class="form-group">
						<label for="email">Email</label> 
						<input type="text" class="form-control form-control-sm" name="email" id="email" value="${utilisateur.email}" readonly/>
					</div>
					<div class="form-group">
						<label for="nom">Nom</label>
						<input type="text" class="form-control form-control-sm" name="nom" id="nom" value="${utilisateur.nom}" readonly/>
						<label for="prenom">Prénom</label>
						<input type="text" class="form-control form-control-sm" name="prenom" id="prenom" value="${utilisateur.prenom}" readonly/>
					</div>
				</form>
			</div>
		</div>
	</section>
<%@ include file="../theme/footer.jsp" %>
</html>