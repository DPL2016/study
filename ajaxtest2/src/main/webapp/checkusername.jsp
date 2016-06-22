
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="text" id="username"><span id="check"></span>
</body>
<script>
    (function(){
        function creatXmlHttp(){
            var xmlHttp = null;
            if(window.ActiveXObject){
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            }else {
                xmlHttp = new XMLHttpRequest();
            }
            return xmlHttp;
        }
        document.querySelector("#username").onchange = function(){
            var username = this.value;
            var xmlHttp = creatXmlHttp();
            xmlHttp.open("get","/username?username="+encodeURIComponent(username),true);
            xmlHttp.onreadystatechange = function(){
                var readyState = xmlHttp.readyState;
                if (readyState==4){
                    var status = xmlHttp.status;
                    if (status==200){
                        var result = xmlHttp.responseText;
                        if (result=="yes"){
                            document.querySelector("#check").innerText = "可以注册";
                        }else {
                            document.querySelector("#check").innerText = "该用户名已存在";
                        }
                    }else {
                        alert("请求服务器失败")
                    }
                }
            }
            xmlHttp.send();
        }
    })();
</script>
</html>
