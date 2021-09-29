<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Verify Page</title>
    </head>
    <link href="css/verify.css" rel="stylesheet" type="text/css"/>
    <body>
        <div class="container">
            <h3>We already send a verification  code to your email.</h3>
            <form action="UserController?service=checkCode" method="post">
                <input class="iput" type="text" name="authcode" >
                <input type="submit" value="verify">
            </form>
        </div>

    </body>
</html>

