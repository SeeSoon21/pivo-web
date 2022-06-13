<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="text" />
<html lang="${language}">
<head>
    <meta charset="UTF-8">
    <title>Вход в систему</title>
    <link rel="stylesheet" href="beer/css/login.css">
    <script
        src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
        crossorigin="anonymous">
    </script>
    <script type="text/javascript" src="beer/javascript/takeLogin.js"></script>
</head>

<body>
    <form>
        <div class="top-panel">
            <select id="language" name="language" onchange="submit()">
                <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                <option value="nl" ${language == 'nl' ? 'selected' : ''}>Nederlands</option>
                <option value="es" ${language == 'es' ? 'selected' : ''}>Español</option>
            </select>

            <div class="registrationBtn">
                <c:url value="/jsp/registration.jsp" var="regUrl"/>
                <a href="${regUrl}">Registration</a>
            </div>
        </div>
    </form>

    <form name="nameForm" action="Controller" method="post">
        <input type="hidden" name="command" value="Login">

        <div class="container">


            <div class="loginBtn">
                <h1>Log in</h1>
                <br/>
                <div class="login-fields">
                    <label for="Login"><fmt:message key="login.label.username" />:</label>
                    <input type="text" name="Login" id="Login" value="" data-value="@Request.RequestContext.HttpContext.Session['LoginKey']"> <br/>

                    <script type="text/javascript">
                            var userLogin;
                            $(
                                function()
                                {
                                    userLogin = "someText";
                                }
                            );
                        </script>

                    <br/>
                    <label for="Password"><fmt:message key="login.label.password" /></label>
                    <input type="password" name="Password" id="Password" value=""> <br/>
                </div>

                    <!-- Когда введен неправильно логин или пароль -->
                    ${errorPassLoginMessage} <br/>
                    <!-- Когда отправлена неправильная команда -->
                    ${wrongAction} <br/>
                    <!-- несуществующая страница -->
                    ${nullpage} <br/>

                <br/>
                <fmt:message key="login.button.submit" var="buttonValue" />
                <!-- Вывод логина на уровень сессии для получения значения в sendComments-->
                <input type="submit" name="submit" value="${buttonValue}" onclick="takeLogin()">
            </div>


        </div>
    </form>




</body>
</html>