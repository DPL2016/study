var Ajax =(function(){
    function creatXmlHttp(){
        var xmlHttp = null;
        if(window.ActiveXObject){
            xmlHttp = new ActiveXObject(Microsoft.XMLHTTP);
        }else {
            xmlHttp = new XMLHttpRequest();
        }
        return xmlHttp;
    }

    function bilderQueryParam(ispost,objectParam){
        var queryParam = "";
        if (!ispost){
            queryParam = "?";
        }
        for (var index in objectParam){
            var key = index;
            var value = objectParam[index];
            queryParam +=(key+"="+value+"&");
        }
        if (!ispost){
            queryParam += "_="+new Date().getTime();
        }else {
            if (queryParam.lastIndexOf("&")==queryParam.length-1){
                queryParam = queryParam.substring(0,queryParam.length-1);
            }
        }
        return queryParam;
    }

    /**
     * 发送一个get ajax请求
     */
    function sendGetRequest(url,queryParam,callback){
        var args = arguments;
        var xmlHttp = creatXmlHttp();
        xmlHttp.open("get",url+bilderQueryParam(false,queryParam),true);
        xmlHttp.onreadystatechange = function(){
            var readState = xmlHttp.readyState;
            if (readState==4){
                var status = xmlHttp.status;
                if(status==200){
                    var result = xmlHttp.responseText;
                    if (args.length==2){
                        args[1](result);
                    }else {
                        args[2](result);
                    }
                }else {
                    alert("连接服务器异常")
                }
            }
        };
        xmlHttp.send();
    }

    function sendPostRequest(url,queryParam,callback){
        var args = arguments;
        var xmlHttp = creatXmlHttp();
        xmlHttp.open("post",url,true);
        xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
        xmlHttp.onreadystatechange = function(){
            var readyState = xmlHttp.readyState;
            if (readyState==4){
                var status = xmlHttp.status;
                if (status==200){
                    var result = xmlHttp.responseText;
                    if (args.length==2){
                        args[1](result);
                    }else {
                        args[2](result);
                    }
                }else {
                    alert("服务器请求异常:" + status)
                }
            }
        };
        xmlHttp.send(bilderQueryParam(true,queryParam));
    }

    return{
        getText:sendGetRequest,
        postText:sendPostRequest
    }
})();