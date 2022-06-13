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
        <title>Раухбир</title>
    </head>

    <body>
    <!--form action="CommentController" method="post"-->
        <h1>Чёрное золото</h1>
        <a href="/pivoWeb/jsp/login.jsp"> Войти в систему</a>
        <a href="/pivoWeb/jsp/registration.jsp"> Регистрация</a>

        <!-- Так будем определять с какой пивной страницы будет поступать запрос-->
        <input type="hidden" name="beerPage" value="rauhbeer">

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
                <img src="pictures/rauhbeer.png" alt="бок-пиво" width="340" height="550">
            </div>

            <div class="mainText">
                <h2 id="introduction">
                    История
                </h2>

                <p id="history">
                Первое упоминание о копчёном пиве относится к 1516 году
                и связано оно именно к бамбергским раухбиром, прототипом
                всех ныне известных сортов этого напитка. Его связывают
                непосредственно с пивоварней «Шленкерла», которая в
                Средние века носила имя «Синий лев». Город Бамберг по праву
                может считаться колыбелью раухбира, а «Эхт Шленкерла» —
                главной достопримечательностью города после кафедрального
                собора Святого Петра и Святого Георгия. Первые письменные
                свидетельства существования пивоварни относятся к 1405 году.
                Слово «aecht» в названии — франкский вариант немецкого «echt»
                («истинный» или «настоящий»).Легенда о появлении копчёного
                пива гласит, что однажды в пивоварне произошёл пожар, и
                пивовар, будучи бедным, был вынужден сварить пиво из испорченного
                солода. Новый вкус неожиданно получил одобрение посетителей,
                так появился новый сорт. Некоторые пивоваренные заводы производят
                свой собственный копчёный солод, например «Вайерманн Мальтинг»
                из Бамберга. «Шленкерла», как истинный хранитель традиций, —
                одна из тех пивоварен, которая испокон веков солодит зерно самостоятельно.
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