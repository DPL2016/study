
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button id="getBtn">发出GET请求</button>
<button id="btn">发出post请求</button>
<script src="/static/js/ajax.js"></script>
<script>
    (function(){
        document.querySelector("#getBtn").onclick=function(){
            Ajax.getText("/ajax",function(result){
               alert("hi,"+result);
            });
        };
        document.querySelector("#btn").onclick = function(){
            Ajax.postText("/ajax",{name:"java",address:"USA"},function(result){
                alert("post:"+result);
            })
        }
    })();
</script>
</body>
</html>
