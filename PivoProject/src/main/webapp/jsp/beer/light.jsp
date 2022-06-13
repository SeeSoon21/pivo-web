<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="css/beer_page.css">
        <script
            src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
            crossorigin="anonymous"></script>
        <script type="text/javascript" src="javascript/displayCommentList.js"></script>
        <script type="text/javascript" src="javascript/sendComment.js"></script>
        <script type="text/javascript" src="javascript/takeLogin.js"></script>
        <title>Светлое</title>
    </head>

    <body>
    <!--form action="CommentController" method="post"-->
        <!--Устанавливаем параметр перехода на страницу со светлым пивом(чтобы комменты из бд сразу подгружались)-->
        <c:set var="beerPage" value="${light.jsp}" scope="session"/>

        <h1>Силы света со стороны пива</h1>
        <a href="/pivoWeb/jsp/login.jsp"> Войти в систему</a>
        <a href="/pivoWeb/jsp/registration.jsp"> Регистрация</a>

        <!-- Так будем определять с какой пивной страницы будет поступать запрос-->
        <input type="hidden" name="beerPage" value="light">

        <div id="header">
            <div id="navigation">
                <ul id="menu">
                    <li><a href="">Сорта</a></li>
                    <li><a href="">Закуски</a></li>
                    <li><a href="">Поставки</a></li>
                    <li><a href="">История</a></li>
                </ul>
            </div>
        </div>

        <div class="wrapper">
            <div id="pictureAle">
                <img src="pictures/light.png" alt="эль" width="480" height="550">
            </div>

            <div class="mainText">
                <h2 id="introduction">
                    История
                </h2>

                <p id="history">
                    На самом деле пиво изначально знало разделение на темные и
                    светлые сорта, то есть на сорта, сваренные из светлого
                    солода, и сваренные из темного солода, да еще и особенно
                    тщательно обжаренного. И начало пивоварения уходит,
                    как принято выражаться, вглубь веков, причем в такую
                    глубь, что сложно рассмотреть что-то конкретное.
                    Доподлинно известно лишь одно – пивоварение известно
                    людям ничуть не менее долго, нежели виноделие,
                    то есть как минимум на протяжении нескольких
                    тысячелетий. Об этом свидетельствуют как
                    материальные, так и письменные исторические источники,
                    сообщающие о том, что пивоварение было важной сферой
                    жизнедеятельности в Междуречье и Древнем Египте, не говоря
                    уже о более поздних цивилизациях. И уже тогда
                    существовали темные и светлые сорта пива. При этом
                    различия в конечном продукте обуславливались исключительно сырьем,
                    тогда как сам процесс производства пива был абсолютно идентичным.

                    Выращенный солод дробили, смешивали с теплой водой, затем
                    полученный раствор смешивали с хмелем и варили определенное
                    время. Затем фильтровали, чтобы отделить по возможности
                    крупные ростки хмеля, и оставляли пивное сусло бродить.
                </p>

            </div>
        </div>


        <div class="commentContainer">
            <div class="usersCommentary">
                <table id="commentary-table" class="table">

                    <c:forEach var="comment" items="${commentList}">
                        ${comment.userName}: ${comment.text}</li>
                    </c:forEach>

                    <!-- Получаем json конвертированный в String-->
                    <input type="hidden" name="commentList" id="commentList">
                    <input type="hidden" name="newComment" id="newComment">
                </table>
            </div>
            <div class="commentary">
                <div class="commentaryBlock">
                    <p id="commentaryHeader">Комментарий: </p>
                    <textarea name="commentaryField" id="commentaryField"></textarea>
                </div>
                <div class="sendBtnClass">
                    <input type="button" id="commentBtn" class="commentBtn" onclick="sendComment()" value="Отправить">
                </div>
            </div>
        </div>

    <!--/form-->


    </body>
</html>