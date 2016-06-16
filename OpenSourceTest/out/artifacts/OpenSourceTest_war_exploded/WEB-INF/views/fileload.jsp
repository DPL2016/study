
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form action="/load" method="post" enctype="multipart/form-data">
    <lable>描述</lable>
    <input type="text" name="describe"><br><br>
    <lable>选择文件</lable>
    <input type="file" name="doc" id="doc"><br><br>
    <button>上传</button>
    </form>
</div>
</body>
</html>
