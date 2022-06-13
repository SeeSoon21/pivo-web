<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<hmtl>
<head>
    <title>Main</title>
    <style>
            body {
            	 background:#f8b627da url("beer/css/pic/mirror_beer2.jpg");
            	 background-attachment: fixed;
            	/* Фон страницы фиксируется */
            	 background-size: 90%;
            	 background-repeat: repeat-x;
            	/* Изображение повторяется по горизонтали */
            	 font-family: "comic sans ms", Courier;
            	 color: #EF7D55;
            	 font-size: 14pt;
            }
             h1 {
            	 text-align: center;
            	 font-size: 22pt;
            }
             .container {
            	 display: block;
            	 text-align: center;
            	 width: 50%;
            }
             #lightBeer {
            	 margin-left: 60px;
            	 padding: 30px;
            }
            /*Группа элементов log in*/
             .loginBtn {
            	 padding: 40px;
            	 font-size: 22pt;
            	 padding-top: 80px;
            }
            a {
            	 text-decoration: none;
            	 color: #ccc;
            }


             .top-panel {
            	 display: inline-flex;
            	 padding: 20px;
            }
             .mylinks {
                 display: block;
                 //padding-left: 200px;
                 text-align: center;

             }

             .mylogout {
             padding: 200px;
                 text-align: top;
                 font-size: 14px;
             }
        </style>
</head>

<body>
<!-- в книжке написано, что этот параметр нужно передавать в скрытом полю и только по метод POST-->
    <div class="container">
        <div class="loginBtn">
            Welcome!<br/>
            ${user}, whats up!
        </div>

        <div class="mylinks">
            <a href="beer/greeting_page.jsp">Перейти на главную страницу</a><br/>
            <div class="mylogout">
                <a href="Controller?command=Logout">Logout</a> <br/> <br/>
            </div>
        </div>
    </div>


</body>

</html>