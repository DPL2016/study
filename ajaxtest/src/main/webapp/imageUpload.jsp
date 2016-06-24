
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/js/webuploader/webuploader.css">
</head>
<body>
<div class="container">
    <div class="page-header">
        <h3>Ajax图片上传</h3>
    </div>
    <div id="picker">选择文件</div>
    <h3>图片预览</h3>
    <ul id="fileList" class="list-unstyled list-inline">

    </ul>
    <button id="btn" class="btn btn-success">开始上传</button>
</div>
<script src="/static/js/jquery-1.11.3.min.js"></script>
<script src="/static/js/webuploader/webuploader.min.js"></script>
<script type="myTemplate" id="progressTemplate">
    <div class="progress" style="padding: 0;height: 5px" >
        <div class="progress-bar progress-bar-success" role="progressbar" style="width: 0%"></div>
    </div>
</script>
<script>
    $(function(){
        var uploader = WebUploader.create({
            sef:"/static/js/webuploader/Uploader.swf",
            server:"/upload",
            pick:"#picker",
            fileVal:"file",
            accept:{
                title: 'Images',
                extensions: 'gif,jpg,jpeg,bmp,png',
                mimeTypes: 'image/*'
            }
        });
        uploader.on("fileQueued",function(file){
            var html = '<li id="'+file.id+'"><img class="img-thumbnail"></li>';
            $("#fileList").append(html);
            uploader.makeThumb(file,function(error,src){
                if(error){
                    return;
                }
                $("#"+file.id).find("img").attr('src',src);
            },100,100);
        });

        uploader.on("uploadProgress",function(file,percentage){
            percentage = parseInt(percentage*100);
            var $li = $("#"+file.id);
            if ($li.find(".progress").length){
                $li.find(".progress .progress-bar").css("width",percentage+"%");
            }else {
                var template = $("#progressTemplate").html();
                $li.append(template);
            }
        });
        //当文件上传成功
        uploader.on("uploadSuccess",function(file){
            $("#"+file.id).css("color","#ccc");
        });

        //当文件上传失败
        uploader.on("uploadError",function(file){
            $("#"+file.id).css("color","darkred");
        });

        //无论文件上传成功或失败
        uploader.on("uploadComplete",function(file){

        });

        //手动开启上传
        $("#btn").click(function(){
            uploader.upload();
        });

    });
</script>
</body>
</html>
