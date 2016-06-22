
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<button id="btn">发送ajaxGet请求</button>
</body>
<script>
    (function(){
        function creatXmlHttp(){
            var xmlHttp = null;
            if (window.ActiveXObject){
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
</html>
