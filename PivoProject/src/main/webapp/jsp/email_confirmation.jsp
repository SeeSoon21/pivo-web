<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head><title>код из письма впиши по-братски</title><head>

<!-- JSP страница, на которую переходим, чтобы ввести код, высланный на email-->
<body>
<form action="EMailCodeController" method="post">
    <input type="hidden" name="emailConfirm" value="emptyEmail">

    <div class="confirmation">
        Введите код подтверждения из письма, высланного на ваш email:<br/>
        <input type="text" name="inputCode">
        <input type="submit" name="sendCode" value="Подтвердить">
    </div>

    <h2>${errorConfirmCode}</h2>

</form>
</body>
</html>