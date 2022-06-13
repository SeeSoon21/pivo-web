<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Регистрация</title>
    <style>
       body {
           background: #ff8a54;
           font-family: "comic sans ms", Courier;
           color: #000000;
           font-size: 14pt;
       }
       h1 {
           text-align: center;
       }
       .container {
           display: flex;
           text-align: center;
       }
       #lightBeer {
           margin-left: 60px;
           padding: 30px;
       }
       .regBtnClass {
           text-align: center;
           padding: 40px;
       }
    </style>
</head>
<body>

    <form name="regForm" action="RegistrationController" method="post" scope="session">
        <input type="hidden" name="registration" value="registration">
        <!--input type="hidden" name="emailConfirm" value="emptyEmail"-->
        <c:set var="emailConfirm" value="emptyEmail" scope="session" />

        <div class="container">
            <div class="registration">
                Name:<br/>
                 <input type="text" name="regLogin" scope="session" required><br/><br/>

                email:<br/>
                 <input type="email" name="regMail" placeholder="email" scope="session" required> <br/><br/>

                Password:<br/>
                <input type="password" name="regPassword" placeholder="password" scope="session" required><br/><br/>

                Age:<br/>
                <input type="number" name="regAge" scope="session" required><br/><br/>

                Country:<br/>
                <input type="text" name="regCountry" scope="session" required><br/><br/>

                    <!-- Если введенный email уже существует в системе-->
                        ${userIsExist} <br/>

                <input type="submit" name="regSubmit" value="Registration"><br/>
            </div>

            <div class="regBtnClass">
                <c:url value="login.jsp" var="loginUrl"/>
                <a href="${loginUrl}">Войти в систему</a>
            </div>
        </div>





    </form>
</body>

</html>