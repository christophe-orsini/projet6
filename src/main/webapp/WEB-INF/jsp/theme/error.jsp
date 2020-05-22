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
				<p class="h3">Erreur</p>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<p>Une erreur s'est produite</p>
				<p>${exceptionMessage.getMessage()}</p>
			</div>
		</div>
	</section>
</body>
</html>