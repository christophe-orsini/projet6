<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <header class="container">
	    <div class="row">
	    	<div class="col-10">
		    	<h1>Les amis de l'escalade</h1>
				<h3>Le site communautaire des grimpeurs</h3>
	    	</div>
	    	<div class="col-2">
		    	<sec:authorize access="isAuthenticated()">
	    			Connecté en tant que <sec:authentication property="name"/>
				</sec:authorize>
	    	</div>
	    </div>
	</header>