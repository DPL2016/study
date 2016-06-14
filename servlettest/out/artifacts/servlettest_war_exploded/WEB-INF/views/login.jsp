<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #eee;
        }

        .form-signin {
            max-width: 330px;
            padding: 15px;
            margin: 0 auto;
        }
        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }
        .form-signin .checkbox {
            font-weight: normal;
        }
        .form-signin .form-control {
            position: relative;
            height: auto;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            padding: 10px;
            font-size: 16px;
        }
        .form-signin .form-control:focus {
            z-index: 2;
        }
        .form-signin input[type="text"] {
            margin-bottom: -1px;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;
        }
        .form-signin input[type="password"] {
            margin-bottom: 10px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }
    </style>
</head>
<body>
<div class="container">

    <c:choose>
        <c:when test="${param.code==1001}">
            <div class="alert alert-danger">
                验证码错误
            </div>
        </c:when>
    </c:choose>

    <form class="form-signin" action="/login" method="post" id="loginform">
        <label for="inputText" class="sr-only">用户名</label>
        <input type="text" id="inputText" name="username" class="form-control" placeholder="用户名" required autofocus>
        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="密码" required>
        <label for="inputText" class="sr-only">验证码</label>
        <a href="javascript:" id="modifycaptcha"><img id="captcha" src="/pic.png"></a>
        <input type="text" id="inputCaptcha" name="captcha" class="form-control" placeholder="验证码" required>
        <button class="btn btn-lg btn-primary btn-block" type="button" id="buttonbtn">登录</button>
    </form>

</div>
<script src="/static/js/jquery-1.11.3.min.js"></script>
<script src="/static/js/cryptojs/core.js"></script>
<script src="/static/js/cryptojs/md5-min.js"></script>

<script>
    $(function(){
        $("#modifycaptcha").click(function(){
            $("#captcha").attr("src","/pic.png?t="+new Date().getTime())
        });
        $("#buttonbtn").click(function(){
            var pwd = $("#inputPassword").val();
            pwd = CryptoJS.MD5(pwd);
            $("#inputPassword").val(pwd);
            console.log(pwd);
            $("#loginform").submit();
        });
    });
</script>
</body>
</html>
