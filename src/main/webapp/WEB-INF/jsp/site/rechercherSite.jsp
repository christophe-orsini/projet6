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
				<p class="h3">Recherche de sites</p>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<form action="/public/rechercheSite" method="post">
					<div class="form-inline">
						<label class="mr-3" for="nom">Nom :</label> 
						<input class="form-control form-control-sm mr-3" type="text" name="nom" id="nom" value="${site.nom}" />
						<input type="checkbox" class="form-check-input" name="tag" id="tag" />
						<label class="form-check-label" for="tag">Seulement les sites 'Officiel' ?</label>
					</div>
					<div class="form-inline">
						<label class="mr-3" for="commune">Commune :</label> 
						<input class="form-control form-control-sm" type="text" name="commune" id="commune" 
							value="${site.commune}" />
						<label class="ml-3 mr-3" for="departement">Departement :</label> 
						<input class="form-control form-control-sm" type="text" name="departement" id="departement" 
							value="${site.departement}" />
						<label class="ml-3 mr-3" for="pays">Pays :</label> 
						<input class="form-control form-control-sm" type="text" name="pays" id="pays" 
							value="${site.pays}" />
					</div>
					<div class="form-inline">
						<label class="mr-3" for="nbreSecteurs">Nombre de secteurs :</label> 
						<input class="form-control form-control-sm" type="number" name="nbreSecteurs" id="nbreSecteurs" 
						 	value="${site.nbreSecteurs}" style="width:4em" />
						<label class="ml-3 mr-3" for="nbreVoies"> Voies :</label> 
						<input class="form-control form-control-sm" type="number" name="nbreVoies" id="nbreVoies" 
							value="${site.nbreVoies}" style="width:4em" />
						<label class="mr-3" for="cotation">Cotation : </label> 
						<input class="form-control form-control-sm" type="text" name="cotation" id="cotation" 
							value="${cotation}" size="3" />
					</div>
					<input class="btn btn-primary" type="submit" name="submit" value="Rechercher" />
				</form>
			</div>
		</div>
	</section>
<%@ include file="../theme/footer.jsp" %>
</html>