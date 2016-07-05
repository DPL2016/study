<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="page-header">
        <h3>添加新图书</h3>
    </div>
    <div class="row">
        <div class="col-lg-4">
            <form action="" method="post">
                <div class="form-group">
                    <label>名称</label>
                    <input type="text" name="bookname" class="form-control">
                </div>
                <div class="form-group">
                    <label>作者</label>
                    <input type="text" name="bookauthor" class="form-control">
                </div>
                <div class="form-group">
                    <label>价格</label>
                    <input type="text" name="bookprice" class="form-control">
                </div>
                <div class="form-group">
                    <label>数量</label>
                    <input type="text" name="booknum" class="form-control">
                </div>
                <div class="form-group">
                    <label>出版社</label>
                    <select name="pubid" class="form-control">
                        <c:forEach items="${pubs}" var="pub">
                            <option value="${pub.id}">${pub.pubname}</option>
                        </c:forEach>
                    </select>

                </div>
                <div class="form-group">
                    <label>分类</label>
                    <select name="typeid" class="form-control">
                        <c:forEach items="${types}" var="type">
                            <option value="${type.id}">${type.booktype}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <button class="btn bg-primary">保存</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
