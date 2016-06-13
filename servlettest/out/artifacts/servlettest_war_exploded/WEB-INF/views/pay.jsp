
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <form class="form-signin" action="/pay" method="post">
        <label for="inputText" class="sr-only" >支付金额</label>
        <input type="hidden" name="token" value="${requestScope.token}">
        <input type="text" id="inputText" name="money" placeholder="请输入金额" >
        <button type="submit">提交</button>
    </form>

</div>
</body>
</html>
