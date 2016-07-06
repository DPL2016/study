<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/js/datatables/css/dataTables.bootstrap.min.css">
</head>
<body>
<div class="container">
    <table id="dataTable" class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>名称</th>
            <th>作者</th>
            <th>价格</th>
            <th>数量</th>
            <th>出版社</th>
            <th>分类</th>
            <th>#</th>
        </tr>
        </thead>
        <tbody>

        </tbody>
    </table>
</div>
<script src="/static/js/jquery-2.2.3.min.js"></script>
<script src="/static/js/datatables/js/jquery.dataTables.min.js"></script>
<script src="/static/js/datatables/js/dataTables.bootstrap.min.js"></script>
<script>
    $(function(){
        $('#dataTable').DataTable({
            "lengthMenu": [ 5,10, 25, 50, 75, 100 ],
            "serverSide":true,
            "ajax":"/datatables/data.json",
            "columns":[
                {"data":"id","name":"id"},
                {"data":"bookname","name":"bookname"},
                {"data":"bookauthor","name":"bookauthor"},
                {"data":"bookprice","name":"bookprice"},
                {"data":"booknum","name":"booknum"},
                {"data":"publisher.pubname",name:"pubid"},
                {"data":"bookType.booktype",name:"typeid"},
                {"data":function(row){
                    return "#"
                }}
            ],
            "columnDefs":[ //定义列的特征
                {targets: [0], visible: false},
                {targets:[1,2,5,7],orderable:false}
            ],
            "language": { //定义中文
                "search": "请输入书籍名称:",
                "zeroRecords": "没有匹配的数据",
                "lengthMenu": "显示 _MENU_ 条数据",
                "info": "显示从 _START_ 到 _END_ 条数据 共 _TOTAL_ 条数据",
                "infoFiltered": "(从 _MAX_ 条数据中过滤得来)",
                "loadingRecords": "加载中...",
                "processing": "处理中...",
                "paginate": {
                    "first": "首页",
                    "last": "末页",
                    "next": "下一页",
                    "previous": "上一页"
                }
            }
        });
    });
</script>

</body>
</html>
