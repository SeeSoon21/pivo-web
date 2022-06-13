function displayCommentList() {
    /*var txt = '{"employees":['+
     '{"firstname":"Anna", "lastname":"sexinwanna"},' +
     '{"firstname":"Boba", "lastname":"sindolboyoba"},' +
     '{"firstname":"Kuka", "lastname":"tvoyamatshluxa"}]}';

     var jsonData = JSON.parse(txt);
     for (var i = 0; i < jsonData.employees.length; i++) {
        console.log("jsondata: ", jsonData.employees[i]);
     }*/

     async function getText() {
         // получаем объект ответа
         const response = await fetch("http://localhost:8080/pivoWeb/BeerPageController");
         // действия с объектом response .......
         console.log("responce: ", response.text());
     }

    getText();

    $.ajax({
        //сразу после нажатия на клавишу совершается переход на сервлет LoadComments(там комментарии и подгружаются)
            //json принимаем с выходного потока(и выгружаем в объект comment)

            url: "BeerPageController",
            type: "POST",
            //dataType: "json",
            dataType: 'text',
            data: $('#commentList').val(),
            contentType: 'text/html',
            mimeType: 'text/html',


            success: function(data) {
                console.log("DATA", data);

                /*$.each(data, function(index, commentClass, comments, date,  username) {
                    var td_username = $("<td/>");
                    var span = $("<span class='label' style='margin:4px;padding:4px' />");
                    var userComments = comments.userName + ": " + comments.text;
                    span.text(userComments);

                    td_username.append(span);


                    $(".usersCommentary").append($('<tr/>')
                            .append(td_username));
                });*/

            },
            error:function(data,status,er) {
                console.log("ошибка какая-то");
                alert("error(data): "+data+"; status: "+status+" er:"+er);
            }
        });

}