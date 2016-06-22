
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/js/bootstrap.min.js">
</head>
<body>
    <div class="container">
        <div class="page-header">
            <h3>Ajax读取XMl</h3>
        </div>
        <button id="readBtn">Read</button>
        <div id="userBox">

        </div>
    </div>
    <script>
        (function(){
            function createXmlHttp(){
                var xmlHttp = null;
                if (window.ActiveXObject){
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                }else {
                    xmlHttp = new XMLHttpRequest();
                }
                return xmlHttp;
            }
            function creatUserDiv(id,username,address){
                var div = document.createElement("div");
                var h4 = document.createElement("h4");
                var small = document.createElement("small");
                var p = document.createElement("p");
                var idText = document.createTextNode(id);
                var addressText = document.createTextNode(address);
                var nameText = document.createTextNode(username);
                p.appendChild(addressText);
                small.appendChild(idText);
                h4.appendChild(nameText);
                h4.appendChild(small);
                div.appendChild(h4);
                div.appendChild(p);
                document.getElementById("userBox").appendChild(div);
            }
            document.querySelector("#readBtn").onclick=function(){
                var xmlHttp = createXmlHttp();
                xmlHttp.open("get","/user.xml",true);
                xmlHttp.onreadystatechange = function(){
                    if (xmlHttp.readyState==4){
                        if (xmlHttp.status==200){
                            document.querySelector("#userBox").innerText="";
                            var xmlDoc = xmlHttp.responseXML;
                            var userArry = xmlDoc.getElementsByTagName("user");
                            for (var i=0;i<userArry.length;i++){
                                var user = userArry[i];
                                var id = user.getAttribute("id");
                                var username = user.getElementsByTagName("username")[0].childNodes[0].nodeValue;
                                var address = user.getElementsByTagName("address")[0].childNodes[0].nodeValue;
                                creatUserDiv(id,username,address);
                            }
                        }else {
                            alert("请求服务器异常:" + status);
                        }
                    }
                }
                xmlHttp.send();
            };
        })();
    </script>
</body>
</html>
