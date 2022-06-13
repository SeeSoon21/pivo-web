<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Thanks for your registration!</title>
 <script type="text/javascript" src="beer/javascript/takeLogin.js"></script>
<head>


<body>
    ПРИЫЕТ, ${regLogin}!
    <br/>

    <div class="comeToMainPage">
        <c:url var="greetingPage" value="beer/greeting_page.jsp" />
        <a href="${greetingPage}">Перейти на главную страницу</a>
    </div>
</body>
</html>