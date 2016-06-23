
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <button id="btn">点击查看信息</button>
    <div id="user">

    </div>
    <script>
        (function(){
            function creatXmlHttp(){
                var xmlHttp=null;
                if (window.ActiveXObject){
                    xmlHttp = new ActiveXObject("Mircosoft.XMLHTTP")
                }else {
                    xmlHttp = new XMLHttpRequest();
                }
                return xmlHttp;
            }
            function creatDiv(id,username,address){
                var div = document.createElement("div");
                var h3 = document.createElement("h3");
                var small = document.createElement("small");
                var p = document.createElement("p");
                var idText = document.createTextNode(id);
                var usernameText = document.createTextNode(username);
                var addressText = document.createTextNode(address);
                small.appendChild(idText);
                h3.appendChild(usernameText);
                p.appendChild(addressText);
                h3.appendChild(small);
                div.appendChild(h3);
                div.appendChild(p)
                document.getElementById("user").appendChild(div);
            }

           document.querySelector("#btn").onclick = function(){
               var xmlHttp = creatXmlHttp();
               xmlHttp.open("get","/user.xml",true);
               xmlHttp.onreadystatechange=function(){
                   var readStates = xmlHttp.readyState;
                   if (readStates==4){
                       var status = xmlHttp.status;
                       if (status==200){
                           document.getElementById("user").innerHTML = "";
                           var xmlDoc = xmlHttp.responseXML;
                           var userArray = xmlDoc.getElementsByTagName("user");
                           for (var i= 0;i<userArray.length;i++){
                               var user = userArray[i];
                               var id = user.getAttribute("id");
                               var username = user.getElementsByTagName("username")[0].childNodes[0].nodeValue;
                               var address = user.getElementsByTagName("address")[0].childNodes[0].nodeValue;
                               console.log("ID:"+id+",username:"+username+",address"+address);
                               creatDiv(id,username,address);
                           }
                       }else {
                           alert("服务器请求异常"+status)
                       }
                   }
               }

               xmlHttp.send();
           }
        })();
    </script>
</body>
</html>
