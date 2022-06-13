function takeLogin(){
    var Login = $('#Login').val();
    localStorage["Login"] = Login;
    console.log("localStore: ", Login);
}
