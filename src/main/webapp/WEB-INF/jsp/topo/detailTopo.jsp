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
				<p class="h3">Détail du topo N° <c:out value="${topo.id}" />
			</div>
		</div>
		<div class="row">
			<div class="col">
				<form>
					<div class="form-inline">
						<label class="mr-3" for="titre">Titre :</label> 
						<input class="form-control form-control-sm mr-3" type="text" id="titre" value="${topo.titre}" readonly />
						<c:if test="${topo.disponible}"> Disponible</c:if>
					</div>
					<div class="form-inline">
						<label class="mr-3" for="datePublication">Date de publication :</label> 
						<input class="form-control form-control-sm" type="text" id="datePublication"
							value="<fmt:formatDate type="BOTH" pattern="dd/MM/yy hh:mm" value="${topo.datePublication}"/>" readonly />						
						<label class="ml-3 mr-3" for="region">Region :</label> 
						<input class="form-control form-control-sm" type="text" id="region"
							value="${topo.region}" readonly />
					</div>
					<div class="form-inline">
						<label class="mr-3" for="description">Description :</label> 
						<textarea class="form-control form-control-sm" id="description" readonly rows="5" cols="60">${topo.description}</textarea>
					</div>
				</form>
			</div>
		</div>
	</section>
<%@ include file="../theme/footer.jsp" %>
</html>