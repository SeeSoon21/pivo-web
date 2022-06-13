<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Выбор на этой странице должен привести к обновлению комментариев конкретного пива-->
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="css/style.css">
        <script
            src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
            crossorigin="anonymous">
        </script>
        <script type="text/javascript" src="javascript/displayCommentList.js"></script>


        <title>Пиво</title>
    </head>

    <body>
    <!--form action="RegistrationController" method="post"-->

        <!-- установим переменную на req.contextPath(условно домен), чтобы пользоваться ею в ссылках-->
        <c:set value="${pageContext.request.contextPath}" var="contextPath" />


            <div class="siteHead">
                <h2 id="mainQuestion" >
                    А не выпить ли пива...
                </h2>
                <div class="controllersButtons">
                    <a href="registration.jsp">Регистрация</a><br/>
                    <a href="jsp/login.jsp">Войти</a>
                </div>
            </div>

            </script>

            <div id="header">
                <nav id="navigation">
                    <ul id="menu">
                        <li><a href="">Сорта</a></li>
                        <li><a href="">Закуски</a></li>
                        <li><a href="">Поставки</a></li>
                        <li><a href="">История</a></li>
                    </ul>
                </nav>
            </div>

            <input type="hidden" id="commentList" name="commentList" />

            <div class="wrapper">
                <div class="block">
                    <img src="pictures/эль.png" alt="Эль" width="200" height="400" style="padding-top: 4mm">
                    <ul class="block_list">
                        <li><a target="_blank" href="${contextPath}/BeerPageController?beerPage=ale" onclick="displayCommentList()" class="works_links" style="margin-right: 10mm ">Эль</a></li>
                    </ul>
                </div>

                <div class="block">
                    <img src="pictures/light.png" alt="Светлое пиво" width="300" height="400">
                    <ul class="block_list">
                        <li><a target="_blank" href="${contextPath}/BeerPageController?beerPage=light" onclick="displayCommentList()" class="works_links" style="margin-left: 2mm">Светлое пиво</a></li>
                    </ul>
                </div>

                <div class="block">
                    <img src="pictures/bok.png" alt="Бок пиво" width="350" height="400">
                    <ul class="block_list">
                        <li><a target="_blank" href="${contextPath}/BeerPageController?beerPage=bok" onclick="displayCommentList()" class="works_links" style="margin-left: 12mm">Бок пиво</a></li>
                    </ul>
                </div>

                <div class="block">
                    <img src="pictures/rauhbeer.png" alt="Раухбир" width="250" height="400">
                    <ul class="block_list">
                        <li><a target="_blank" href="${contextPath}/BeerPageController?beerPage=rauhbeer" onclick="displayCommentList()" class="works_links">Раухбир</a></li>
                    </ul>
                </div>
            </div>


            <!--script src="trytoinstyle.js"></script-->
    <!--/form-->
    </body>
</html>
