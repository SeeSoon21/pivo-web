<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head><head>

<!-- Вспомогательная страница для изменения скрытого поля emailConfirm после того, как email был подтвержден-->
<body>
<form action="RegistrationController" method="post">
    <input type="hidden" name="emailConfirm" value="successEmail">

    <c:out value="${pageContext.request.requestURI}"/>
    <c:set var="currentUrl" value="${pageContext.request.requestURI}"/>
    <br/><c:out value="${currentUrl}"/>
    <c:redirect url="/jsp/RegistrationController"/>



</form>
</body>
</html>