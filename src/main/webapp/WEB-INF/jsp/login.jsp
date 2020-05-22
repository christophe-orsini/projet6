<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<%@ include file="theme/head.jsp" %>
<body>
<%@ include file="theme/header.jsp" %>
<%@ include file="theme/menu.jsp" %>
	<section class="container">
		<div class="row">
			<div class="col">
				<c:url value="/login" var="loginProcessingUrl"/>
				<form action="${loginProcessingUrl}" method="post">
					<fieldset><legend>Formulaire de connexion</legend>
						<!-- use param.error assuming FormLoginConfigurer#failureUrl contains the query parameter error -->
				        <c:if test="${param.error != null}">
				            <div>
				                Erreur de connexion.
				                <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
				                  Motif : <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
				                </c:if>
				            </div>
				        </c:if>
				        <!-- the configured LogoutConfigurer#logoutSuccessUrl is /login?logout and contains the query param logout -->
				        <c:if test="${param.logout != null}">
				            <div>
				                Vous êtes déconnecté.
				            </div>
				        </c:if>
						<div class="form-group">
							<label for="email">Email</label> 
							<input type="text" class="form-control form-control-sm w-50" name=username id="email" required="required" 
								autofocus="autofocus" />
							<label for="motpasse">Mot de passe</label>
							<input type="password" class="form-control form-control-sm w-50" name="password" id="password" required="required" />
						</div>
					<input class="btn btn-primary" type="submit" value="Se connecter">
					</fieldset>
					
				</form>
			</div>
		</div>
	</section>
<%@ include file="theme/footer.jsp" %>
</body>
</html>