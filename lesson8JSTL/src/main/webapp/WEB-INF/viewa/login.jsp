<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
    function validationLogin() {
        var flag = true;
        var linkLogin = $('#login1');
        var linkPas = $('#password1');
        if (linkLogin.val() == '' && linkPas.val() == ''){
            flag = false;
            alert("not correct entered data of login and password");
        }
        if (linkLogin.val() == '' && linkPas.val() != '' ){
            flag = false;
            alert("not correct entered data of login");
        }
        if (linkLogin.val() != '' && linkPas.val() == '' ){
            flag = false;
            alert("not correct entered data of password");
        }
        console.log(flag.valueOf());
        return flag;
    }
</script>
<form  method="POST" action="/login">
        <div class="col-xs-4">
                <span class="help-block"></span>
                <label for="login1">Login:</label>
                <input type="text" class="form-control" name="login1" id="login1">
                <label for="password1">Password:</label>
                <input type="password" class="form-control" name="password1" id="password1">
                <span class="help-block"></span>
                <button type="submit" name = "submitLogin" value="LOG" class="btn btn-default" onclick="return validationLogin();">Login</button>
        </div>
</form>
</body>
</html>
