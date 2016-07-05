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
        <h3>编辑图书</h3>
    </div>
    <div class="row">
        <div class="col-lg-4">
            <form action="" method="post">
                <input type="hidden" name="id" value="${book.id}">
                <div class="form-group">
                    <label>名称</label>
                    <input type="text" name="bookname" class="form-control" value="${book.bookname}">
                </div>
                <div class="form-group">
                    <label>作者</label>
                    <input type="text" name="bookauthor" class="form-control" value="${book.bookauthor}">
                </div>
                <div class="form-group">
                    <label>价格</label>
                    <input type="text" name="bookprice" class="form-control" value="${book.bookprice}">
                </div>
                <div class="form-group">
                    <label>数量</label>
                    <input type="text" name="booknum" class="form-control" value="${book.booknum}">
                </div>
                <div class="form-group">
                    <label>出版社</label>
                    <select name="pubid" class="form-control">
                        <c:forEach items="${pubs}" var="pub">
                            <option value="${pub.id}" ${book.pubid==pub.id ? 'selected' :''}>${pub.pubname}</option>
                        </c:forEach>
                    </select>

                </div>
                <div class="form-group">
                    <label>分类</label>
                    <select name="typeid" class="form-control">
                        <c:forEach items="${types}" var="type">
                            <option value="${type.id}" ${book.typeid==type.id ? 'selected' :''}>${type.booktype}</option>
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
