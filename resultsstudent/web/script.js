/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

onload = function(){
    updateList();
    $("#submit").click(submitUser);
}

function updateList(){
    
    var request = new XMLHttpRequest();
    request.open("GET", "http://localhost:8080/resultsstudent/api/users");
    request.onload = function(){
        if (request.status == 200){
            $("#users").empty();
            var users = JSON.parse(request.responseText);
            for (var i = 0; i<users.length; i++){
                var item = $("<li>");
                if (users[i].fullName){
                    item.text(users[i].fullname + " (" + users[i].username + ") <br> " + users[i].fotoURL);
                }
                else
                {
                    item.text(users[i].username +  "<br> " + users[i].fotoURL);
                }
                $("#users").append(item);
            }
            $("#error").empty();
        }
        else
        {
            $("#error").text("Unable to load user list");
        }
    }
    
    request.send(null);
    
    
}

function submitUser()
{
    var user = {};
    user.username = $("#username").val();
    user.fullName = $("#fullName").val();
    user.fotoURL = $("#fotoURL").val();
    user.password = $("#password").val();
    
    var request = new XMLHttpRequest()
    request.open("POST", "http://localhost:8080/resultsstudent/api/users");
    request.onload =  function()
    {
        if (request.status === 201)
        {
            $("#error").empty();
            updateList();
        }
        else
        {
            $("#error").text("Unable to add user");
        }
    };
    request.setRequestHeader("Content-Type", "application/json");
    request.send(JSON.stringify(user));
}


