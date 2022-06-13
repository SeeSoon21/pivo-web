<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head><title>Mail process</title></head>
<body>
<form action="MailController" method="POST">
    <table>
        <tr>
            <td>Send to:</td>
            <td><input type="text" name="to"></td>
        </tr>
        <tr>
            <td>Subject:</td>
            <td><input type="text" name="subject"/></td>
        </tr>
    </table>
    <hr/>
    <textarea type="text" name="mailMessageBody" rows="5" cols="45">Message text</textarea>
    <br/><br/>
    <input type="submit" value="Send message!"/>
</form>
</body>
<html>