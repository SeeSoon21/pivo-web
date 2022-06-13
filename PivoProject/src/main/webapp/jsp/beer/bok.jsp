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

        <title>Бок</title>
    </head>

    <body>
    <!--form action="CommentController" method="post"-->
        <h1>Не в бровь, а в...</h1>
        <a href="/pivoWeb/jsp/login.jsp"> Войти в систему</a>
        <a href="/pivoWeb/jsp/registration.jsp"> Регистрация</a>

        <!-- Так будем определять с какой пивной страницы будет поступать запрос-->
        <input type="hidden" name="beerPage" id="beerPage" value="bok">

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
                <img src="pictures/bok.png" alt="бок-пиво" width="470" height="560">
            </div>

            <div class="mainText">
                <h2 id="introduction">
                    История
                </h2>

                <p id="history">
                    Всё началось в ганзейском городе Айнбек, который много
                    торговал, в том числе и пивом. Было оно плотное и крепкое,
                    чтобы лучше сохранялось при перевозках. Возили это пиво и в Мюнхен. До тех пор, пока в 1614-м году на мюнхенскую пивоварню Траусниц не пригласили из Айнбека пивовара Элиаса Пихлера. Он сварил местную версию айнбекского пива. Со временем этот сорт стали сбраживать как лагер, а название баварском диалекте сократилось с «айнбек» до «бок». Слово это означает также «козел», поэтому на этикетках бока часто присутствует изображение этого животного.
                    В айнбекском пиве использовали до трети пшеницы,
                    в мюнхенскую версию пшеницу не добавляли, а более тёмные
                    версии мюнхенского солода придали напитку более тёмный
                    цвет. Доппельбок — ещё более плотную версию бока — сварили
                    впервые в мюнхенском монастыре святого Франциска. В
                    отличие от современных версий, доппельбок сбраживался
                    тогда не так сильно, был очень сладким и потому считался
                    у монахов «жидким хлебом» и назывался — «сальватор»
                    («спаситель»). Самую крепкую версию бока получали
                    вымораживанием части воды, такой стиль носит название айсбок.
                    Позже появились и версии бока с пшеничным солодом — вайценбок
                    (и вайцендоппельбок).
                </p>

            </div>
        </div>



        <div class="commentContainer">
            <div class="usersCommentary">
                <table id="commentary-table" class="table">

                <c:forEach var="comment" items="${commentList}">
                    <li>${comment.date}<br/>
                    login: ${comment.userName}, commentary: ${comment.text}</li><br/>
                    <br/>
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