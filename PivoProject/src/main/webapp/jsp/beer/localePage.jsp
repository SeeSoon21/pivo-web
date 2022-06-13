<%@ page pageEncoding="UTF-8" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <!-- сначала язык выбирается пользователем, а затем уже устанавливается как параметр и идёт в переменную language-->
 <!--если язык был выбран в раскрывающемся списке(параметр запроса)-->
 <!--если язык был установлен в сеансе ранее, придерживаться его-->
 <!--иначе использовать языковой стандарт, указанный пользователем в заголовке запроса -->
 <c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
 <fmt:setLocale value="${language}" />
 <fmt:setBundle basename="text" />
 <!DOCTYPE html>
 <!-- изменяемым параметром задается и сама страница html-->
 <html lang="${language}">
     <head>
         <title>JSP/JSTL i18n demo</title>
     </head>
     <body>
         <form>
             <select id="language" name="language" onchange="submit()">
                 <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                 <option value="nl" ${language == 'nl' ? 'selected' : ''}>Nederlands</option>
                 <option value="es" ${language == 'es' ? 'selected' : ''}>Español</option>
             </select>
         </form>
         <form method="post">
             <label for="username"><fmt:message key="login.label.username" />:</label>
             <input type="text" id="username" name="username">
             <br>
             <label for="password"><fmt:message key="login.label.password" />:</label>
             <input type="password" id="password" name="password">
             <br/>
             <fmt:message key="login.button.submit" var="buttonValue" />
             <input type="submit" name="submit" value="${buttonValue}">
         </form>
     </body>
 </html>