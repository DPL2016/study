
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="text" id="username"> <span id="msg"></span>
<script>
        function creatXmlHttp(){
            var xmlHttp = null;
            if (window.ActiveXObject){
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            }else {
                xmlHttp = new XMLHttpRequest();
            }
            return xmlHttp;
        }
        document.querySelector("#username").onchange = function(){
            var username = this.value;
            var xmlHttp = creatXmlHttp();
            xmlHttp.open("get","/username?username="+username);
            xmlHttp.onreadystatechange=function() {
                var readyState = xmlHttp.readyState;
                alert(readyState);
                if (readyState == 4) {
                    var httpState = xmlHttp.status;
                    if (httpState == 200) {
                        var result = xmlHttp.responseText;
                        if (result == "yes") {
                            document.querySelector("#msg").innerText = "可以注册"
                        } else {
                            document.querySelector("#msg").innerText = "账号已经注册"
                        }
                    } else {
                        alert("服务器请求异常！")
                    }
                }
            }
            xmlHttp.send();
        }
</script>
</body>
</html>
