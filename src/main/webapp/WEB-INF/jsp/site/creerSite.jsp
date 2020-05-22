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
				<p class="h3">Création d'un site</p>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<form action="/inscrit/creerSite" method="post">
					<div class="form-inline">
						<label class="mr-3" for="nom">Nom :</label> 
						<input class="form-control form-control-sm mr-3" type="text" name="nom" id="nom" value="${site.nom}" />
					</div>
					<div class="form-inline">
						<label class="mr-3" for="description">Description :</label> 
						<input class="form-control form-control-sm" type="text" name="description" id="description" 
							value="${site.description}" />
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
						<label class="mr-3" for="latitude">Latitude :</label> 
						<input class="form-control form-control-sm" type="text" name="latitude" id="latitude" 
							value="${site.latitude}" size="8"/>
						<label class="ml-3 mr-3" for="longitude">Longitude :</label> 
						<input class="form-control form-control-sm" type="text" name="longitude" id="longitude" 
							value="${site.longitude}" size="8" />
					</div>
					<div class="form-inline">
						<label class="mr-3" for="nbreSecteurs">Nombre de secteurs :</label> 
						<input class="form-control form-control-sm" type="number" name="nbreSecteurs" id="nbreSecteurs" 
						 	value="${site.nbreSecteurs}" style="width:4em" />
						<label class="ml-3 mr-3" for="nbreVoies"> Voies :</label> 
						<input class="form-control form-control-sm" type="number" name="nbreVoies" id="nbreVoies" 
							value="${site.nbreVoies}" style="width:4em" />
						<label class="ml-3 mr-3" for="nbreLongueurs"> Longueurs :</label> 
						<input class="form-control form-control-sm" type="number" name="nbreLongueurs" id="nbreLongueurs" 
							value="${site.nbreLongueurs}" style="width:4em" />
						<label class="ml-3 mr-3" for="nbreRelais"> Relais :</label> 
						<input class="form-control form-control-sm" type="number" name="nbreRelais" id="nbreRelais" 
							value="${site.nbreRelais}" style="width:4em" />
					</div>
					<div class="form-inline">
						<label class="mr-3" for="cotationMini">Cotation : mini :</label> 
						<input class="form-control form-control-sm" type="text" name="cotationMini" id="cotationMini" 
							value="${site.cotationMini}" size="3" />
						<label class="ml-3 mr-3" for="cotationMaxi">maxi :</label> 
						<input class="form-control form-control-sm" type="text" name="cotationMaxi" id="cotationMaxi" 
							value="${site.cotationMaxi}" size="3" /><br/>
					</div>
					<input class="btn btn-primary" type="submit" value="Publier" />
				</form>
			</div>
		</div>
	</section>
<%@ include file="../theme/footer.jsp" %>
</html>