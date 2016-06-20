var Ajax = (function(){
    function creatXmlHttp(){
        var xmlHttp = null;
        if (window.ActiveXObject){
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        }else {
            xmlHttp = new XMLHttpRequest();
        }
        return xmlHttp;
    }

    /**
     * 拼接字符串
     */
    function bilderQueryParam(isPost,objectParam){
        var queryParam = "";
        if (!isPost){
            queryParam = "?";
        }
        for(var index in objectParam){
            var key = index;
            var value = objectParam[index];
            queryParam += key+"="+value+"&";
        }
        if (!isPost){
            queryParam += "_"+new Date().getTime();
        }else if (queryParam.lastIndexOf("&")==queryParam.length-1){
            queryParam = queryParam.substring(0,queryParam.length-1);
        }
        return queryParam;
    }

    /**
     * 发出一个get请求
     */
    function sendGetRequest(url,queryParam,callback){
        var args = arguments;
        var xmlHttp = creatXmlHttp();
        xmlHttp.open("get",url+bilderQueryParam(false,queryParam),true);
        xmlHttp.onreadystatechange = function(){
            var readyState = xmlHttp.readyState;
            if (readyState == 4){
                var status = xmlHttp.status;
                if (status==200){
                    var result = xmlHttp.responseText;
                    if (args.length==2){
                        args[1](result);
                    }else if(args.length==3){
                        args[2](result);
                    }
                }else {
                    alert("服务器请求失败"+status);
                }
            }
        };
        xmlHttp.send();
    }
    return{
        getText:sendGetRequest,
    }
})();