<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
    <title>内容列表页面</title>
    <link href="/static/css/all.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body style="background: #e1e9eb;">
<form action="" id="mainForm" method="post">
    <div class="right">
        <div class="current">当前位置：<a href="javascript:void(0)" style="color:#6E6E6E;">内容管理</a> &gt; 内容列表</div>
        <div class="rightCont">
            <p class="g_title fix">新增列表
            <div class="panel-body col-xs-6">
                <form id="signupForm" method="post" class="form-horizontal"
                      action="/add" novalidate="novalidate">
                    <div class="form-group">
                        <label class="col-sm-4 control-label" for="command">指令</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="command" name="command"
                                   placeholder="请输入指令">
                        </div>
                    </div>
                    <br>

                    <div class="form-group">
                        <label class="col-sm-4 control-label" for="description">描述</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="description" name="description"
                                   placeholder="请输入描述">
                        </div>
                    </div>
                    <br>
                    <div class="form-group">
                        <label class="col-sm-4 control-label" for="content">简介</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="content" name="content"
                                   placeholder="请输入简介">
                        </div>
                    </div>
                    <br>
                    <div class="form-group">
                        <div class="col-sm-9 col-sm-offset-4">
                            <button type="submit" class="btn btn-primary " style="background-color: #70c9c9 " name="signup"
                                    value="新增">新增</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</form>
</body>
</html>

