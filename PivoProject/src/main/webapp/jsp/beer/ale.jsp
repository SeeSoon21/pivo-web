<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
            <meta charset="utf-8">
            <link rel="stylesheet" href="css/beer_page.css">
            <script
                src="https://code.jquery.com/jquery-3.6.0.min.js"
                integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
                crossorigin="anonymous">
            </script>
            <script type="text/javascript" src="javascript/displayCommentList.js"></script>
            <script type="text/javascript" src="javascript/sendComment.js"></script>
            <script type="text/javascript" src="javascript/takeLogin.js"></script>

            <title>Эль</title>
        </head>

    <body>
    <!--form action="CommentController" method="post"-->
        <h1>Его величество, эль!</h1>
        <a href="/pivoWeb/jsp/login.jsp"> Войти в систему</a>
        <a href="/pivoWeb/jsp/registration.jsp"> Регистрация</a>

        <!-- Так будем определять с какой пивной страницы будет поступать запрос-->
        <input type="hidden" name="beerPage" value="ale">

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
                <img id="justAle" src="pictures/эль.png" alt="эль" width="280" height="550">
            </div>

            <div class="mainText">
                <h2 id="introduction">
                    История
                </h2>

                <p id="history">
                    Эль известен с XV века, именно элем в Средневековье
                    нельзя было отравиться (обычной водой — легко!).
                    Эль считался очень ценным. Предположительно, слово
                    "эль" переводится как "опьянение" — оно сохранилось в
                    нескольких скандинавских языках. Верховое брожение при
                    высоких температурах удешевляет производство элей,
                    в отличие от лагеров — здесь необходимо понижать
                    температуру, да еще и хранить потом где-то
                    получившийся напиток. С элем все просто: сварил — выпил.
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