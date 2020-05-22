<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<%@ include file="head.jsp" %>
<body>
<%@ include file="header.jsp" %>
	<section id="page-content" class="container">
	<div class="row">
			<div class="col">
				<p class="h3">Erreur fatale</p>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<p>Une erreur fayale s'est produite<br />
				L'application ne peut plus fonctionner<br />
				Veuillez contacter l'administrateur du site et lui communiquer les éléments :</p>
				<p>${exceptionMessage.getMessage()}</p>
				<div class="border">
					<p>Fichier : ${exceptionMessage.getStackTrace()[0].getFileName()}</p>
					<p>Classe : ${exceptionMessage.getStackTrace()[0].getClassName()}</p>
					<p>Methode : ${exceptionMessage.getStackTrace()[0].getMethodName()}</p>
					<p>Ligne : ${exceptionMessage.getStackTrace()[0].getLineNumber()}</p>
				</div>
			</div>
		</div>
	</section>
</body>
</html>