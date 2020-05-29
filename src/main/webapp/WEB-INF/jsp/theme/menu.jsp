<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  	<a class="navbar-brand" href="/">Les amis de l'escalade</a>
  	<sec:authorize access="!isAuthenticated()">
		<a class="nav-link" href="/public/listeSites">Liste des sites</a>	    
		<a class="nav-link" href="/inscription">S'inscrire</a>
		<a class="nav-link ml-auto" href="/login">Se connecter</a>
  	</sec:authorize>
  	<sec:authorize access="isAuthenticated()">
	<div class="dropdown">
	    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button"
	    aria-haspopup="true" aria-expanded="false">Sites</a>
	   	<div class="dropdown-menu">
	  			<a class="nav-link" href="/public/listeSites">Liste des sites</a>
	  			<a class="nav-link" href="/inscrit/listeSitesUtilisateur">Liste de vos sites</a>
	  			<a class="nav-link" href="/inscrit/publierSite">Publier un site</a>
	  		</div>
		</div>
		<div class="dropdown">
		    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button"
		    aria-haspopup="true" aria-expanded="false">Topos</a>
		   	<div class="dropdown-menu">
		  			<a class="nav-link" href="/inscrit/listeTopos">Liste des Topos</a>
		  			<a class="nav-link" href="/inscrit/listeToposUtilisateur">Liste de vos Topos</a>
		  			<a class="nav-link" href="/inscrit/listeToposEmprunt">Liste des Topos empruntés</a>
		  			<a class="nav-link" href="/inscrit/publierTopo">Nouveau Topo</a>
		  		</div>
		</div> 
		<a class="nav-link" href="/inscrit/listeUtilisateurs">Utilisateurs</a>
		<a class="nav-link ml-auto" href="/logout">Se déconnecter</a>
	</sec:authorize>
</nav>