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
	<section class="row">	
		<div class="col-12">
			<p class="h3">Détail du topo N° <c:out value="${topo.id}" /></p>
			<c:if test="${topo.disponible}">
				<span class="badge badge-secondary">Disponible</span>
			</c:if>	
			<p>Titre : ${topo.titre}</p>
			<p>Date publication : <fmt:formatDate type="DATE" pattern="dd/MM/yy" value="${topo.datePublication}"/></p>
			<p>Region : ${topo.region}</p>
			<p>Description :</p>
			<p>${topo.description}</p>
		</div>
	</section>
<%@ include file="../theme/footer.jsp" %>
</body>
</html>