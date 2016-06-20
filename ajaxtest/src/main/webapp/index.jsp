<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
<h2>Hello Ajax!</h2>
<button id="btn">hello</button>
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
        document.querySelector("#btn").onclick = function(){
            var xmlHttp = creatXmlHttp();
            xmlHttp.open("get","/ajax",true);
            xmlHttp.send();
        }
    })();
</script>
</body>
</html>