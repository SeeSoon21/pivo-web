<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head><title>Index</title></head>

<body>
    <c:out value="сессия в index.jsp ${pageContext.request.session}" />
    <jsp:forward page="login.jsp" />
</body>

</html>