<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<%@ include file="../theme/head.jsp" %>
<body>
<%@ include file="../theme/header.jsp" %>
	<section id="page-content" class="container">
	<div class="row">
			<div class="col">
				<p class="h3">Félicitation !</p>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<p>Votre inscription est validée</p>
				<p>Votre identifiant est ${login}</p>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<a class="btn btn-primary" href="/login">Se connecter</a>
			</div>
		</div>
	</section>
</body>
</html>