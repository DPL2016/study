<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Hello Ajax!</h2>
<button id="btn">发送get请求</button>
<h3>你好</h3>
<script>
    (function(){
        encodeURIComponent("UTF-8");
        function creatXmlHttp(){
            var xmlHttp = null;

            if(window.ActiveXObject){
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            }else {
                xmlHttp = new XMLHttpRequest();
            }
            return xmlHttp;
        }
        document.querySelector("#btn").onclick = function(){
            var xmlHttp = creatXmlHttp();

            xmlHttp.open("get","/ajax",true);
            xmlHttp.send();
        }
    })();
</script>
</body>
</html>