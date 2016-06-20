
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button id="btn">发送get请求</button>
<button id="postbtn">发送post请求</button>
<script src="/static/js/ajax.js"></script>
<script>
    document.querySelector("#btn").onclick = function(){
        Ajax.getText("/ajax",function(result){
            alert("hi,"+result);
        });
    };
    document.querySelector("#postbtn").onclick=function(){
        Ajax.postText("/ajax",{name:"tom",address:"china"},function(result){
            alert("post:"+result);
        });
    };
</script>
</body>
</html>
