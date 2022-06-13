function sendComment() {
    var comment = new Object();
    comment.login = localStorage["Login"];
    comment.field = $('#commentaryField').val();
    console.log("comment.login = ", comment.login);
    console.log("comment.field = ", comment.field);

    function isEmpty(data) {
        console.log('мы в isEmpty');
        if (typeof data === 'object' || Array.isArray(data)) {
            if ((Object.keys(data).length === 0) || (data.length === 0)) {
                console.log('возврат true(ошибка)');
                return true;
            }
        } else {
            switch(data) {
                case typeof(data) === "undefined":
                case "":
                case null:
                console.log('возврат true(ошибка)');
                return true;
            }
        }
            console.log('ноль ошибок');
        return false;
    }

    function checkIsEmpty(data){
        var bool_value = true;
        for (var value in data) {
            if (data[value]==="undefined" || data[value] === null || data[value] === "") {
                console.log("ошибка! key = ", data[value]);
                console.log("bool_value = ", bool_value);
               bool_value = true;
            } else {
                console.log("ноль ошибок! key = ", data[value]);
                bool_value = false;
            }
        }
        console.log("bool_value = ", bool_value);
        return bool_value;
    }


    $.ajax({
            url: "CommentController",
            type: "POST",
            dataType: 'json',
            //data – данные, которые отправляем на серверную часть
            data: JSON.stringify(comment),
            contentType: 'application/json',
            mimeType: 'application/json',

            success:function(data) {
                //console.log("commentBody: ", data.myComm);
                //console.log("commentLoginAfter", data.myLog);
                console.log("data: ", data);
                if (checkIsEmpty(data)) {
                    alert("Комментарий пуст!");
                }
                else {
                    var td_username = $("<td/>");
                    var span = $("<span class='label' style='margin:4px;padding:4px' />");
                    var userComment;

                    userComment = comment.login + ": " + comment.field;
                    span.text(userComment);
                    td_username.append(span);
                    $('.usersCommentary').append($('<tr/>')
                                         .append(td_username));
                }
            },
            error:function(data,status,er) {
                alert("error: "+data+" status: "+status+" er:"+er);
            }
        });

        $('#commentaryField').val('');
}