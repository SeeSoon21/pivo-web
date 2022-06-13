<%@page isErrorPage="true" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
    <head><title>Error page</title></head>
    <body>
        problems with request ${pageContext.errorData.requestURI}
        Servlet name: ${pageContext.errorData.servletName}
        Status code: ${pageContext.errorData.statusCode}
        Exception: ${pageContext.errorData.throwable}
    </body>
</html>