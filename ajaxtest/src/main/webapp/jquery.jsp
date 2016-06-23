
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/js/bootstrap.min.js">
</head>
<body>
<div class="container">
    <button id="btn1">get json</button>
    <button id="btn2">ajax method</button>
    <img src="/static/img/loading.gif" id="loadimg" style="display: none" >
</div>
<script src="/static/js/jquery-1.11.3.min.js"></script>
<script>
    $(function(){
        $("#btn1").click(function(){
            $.getJSON("/user.json").done(function(data){
                console.log(data);
            }).fail(function(){
                alert("请求服务器异常");
            }).always(function(){
                console.log("always...")
            });
        });
        $("#btn2").click(function(){
            var $this = $(this);
            $.ajax({
                url:"/user.json",
                type:"get",
                //data:{"name":"tom"},
                timeout:10000,
                beforeSend:function(){
                    console.log("before");
                    $this.text("sending...").attr("disabled","disabled");
                    $("#loadimg").show();
                },
                success:function(data){
                    console.log("success");
                },
                error:function(){
                    alert("请求服务器异常");
                },
                complete:function(){
                    console.log("complete");
                    $this.text("ajax method").removeAttr("disabled");
                    $("#loadimg").hide();
                }
            });
        });
    });
</script>
</body>
</html>
