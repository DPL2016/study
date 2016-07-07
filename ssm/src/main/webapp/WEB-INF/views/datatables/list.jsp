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

    <a href="javascript:;" id="newBookBtn" class="btn btn-primary"  style="margin-bottom:20px;">添加新书籍</a>

    <!-- Modal -->
    <div class="modal fade" id="newBookModal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">添加图书</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-9" style="padding-left: 150px">
                            <form id="saveForm">
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
                            </form>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary" id="saveBtn">保存</button>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="editBookModal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">修改图书</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-9" style="padding-left: 150px">
                            <form id="editForm">
                                <input type="hidden" name="id" id="edit_bookid">
                                <div class="form-group">
                                    <label>名称</label>
                                    <input type="text" name="bookname" class="form-control" id="edit_bookname">
                                </div>
                                <div class="form-group">
                                    <label>作者</label>
                                    <input type="text" name="bookauthor" class="form-control" id="edit_bookauthor">
                                </div>
                                <div class="form-group">
                                    <label>价格</label>
                                    <input type="text" name="bookprice" class="form-control" id="edit_bookprice">
                                </div>
                                <div class="form-group">
                                    <label>数量</label>
                                    <input type="text" name="booknum" class="form-control" id="edit_booknum">
                                </div>
                                <div class="form-group">
                                    <label>出版社</label>
                                    <select name="pubid" class="form-control" id="edit_pubid">
                                        <c:forEach items="${pubs}" var="pub">
                                            <option value="${pub.id}">${pub.pubname}</option>
                                        </c:forEach>
                                    </select>

                                </div>
                                <div class="form-group">
                                    <label>分类</label>
                                    <select name="typeid" class="form-control" id="edit_typeid">
                                        <c:forEach items="${types}" var="type">
                                            <option value="${type.id}">${type.booktype}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary" id="editBtn">保存</button>
                </div>
            </div>
        </div>
    </div>

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
<script src="/static/js/bootstrap.js"></script>
<script src="/static/js/jquery.validate.min.js"></script>
<script src="/static/js/datatables/js/jquery.dataTables.min.js"></script>
<script src="/static/js/datatables/js/dataTables.bootstrap.min.js"></script>
<script>
    $(function(){
        var dataTable = $('#dataTable').DataTable({

            "lengthMenu": [ 5,10, 25, 50, 75, 100 ],
            "serverSide":true,
            "ajax":{
                url:"/datatables/data.json",

            },
            "order":[0,'desc'],
            "searching": false,
            "columns":[
                {"data":"id","name":"id"},
                {"data":"bookname","name":"bookname"},
                {"data":"bookauthor","name":"bookauthor"},
                {"data":"bookprice","name":"bookprice"},
                {"data":"booknum","name":"booknum"},
                {"data":"publisher.pubname",name:"pubid"},
                {"data":"bookType.booktype",name:"typeid"},
                {"data":function(row){
                    return "<a href='javascript:;' class='editLink' rel='"+row.id+"'>编辑</a> <a href='javascript:;' class='delLink' rel='"+row.id+"'>删除</a>";
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

        //新增
        $('#saveForm').validate({
            errorElement:"span",
            errorClass:"text-danger",
            rules:{
                bookname:{
                    required:true
                },
                bookauthor:{
                    required:true
                },
                bookprice:{
                    required:true,
                    number:true
                },
                booknum:{
                    required:true,
                    digits:true
                }
            },
            messages:{
                bookname:{
                    required:"请输入书名"
                },
                bookauthor:{
                    required:"请输入作者"
                },
                bookprice:{
                    required:"请输入价格",
                    number:"请输入正确的价格"
                },
                booknum:{
                    required:"请输入数量",
                    digits:"请输入正确的数量"
                }
            },
            submitHandler:function(form){
                $.post("/datatables/new",$(form).serialize()).done(function(data){
                    if (data =="success"){
                        $('#newBookModal').modal('hide');
                        dataTable.ajax.reload();
                    }
                }).fail(function(){
                    alert("请求服务器异常");
                });
            }
        });

        $('#newBookBtn').click(function(){
            $("#saveForm")[0].reset();
            $('#newBookModal').modal({
                show:true,
                backdrop:'static',
                keyboard:false
            });
        });
        $('#saveBtn').click(function(){
            $('#saveForm').submit();
        });

        //删除
        $(document).delegate(".delLink","click",function(){
            var id = $(this).attr("rel");

            if (confirm("确定要删除吗？")){
                $.get("/datatables/"+id+"/del").done(function(data){
                    if (data=="success"){
                        dataTable.ajax.reload();
                    }
                }).fail(function(){
                    alert("请求服务器异常")
                });
            }
        });

        //编辑图书
        $(document).delegate(".editLink","click",function(){
            var id = $(this).attr("rel");
            $.get("/datatables/"+id+".json").done(function(data){
                $("#edit_bookid").val(data.id);
                $("#edit_bookname").val(data.bookname);
                $("#edit_bookauthor").val(data.bookauthor);
                $("#edit_bookprice").val(data.bookprice);
                $("#edit_booknum").val(data.booknum);
                $("#edit_pubid").val(data.pubid);
                $("#edit_typeid").val(data.typeid);
                $("#editBookModal").modal({
                    show:true,
                    drapback:'static',
                    keyboard:false
                });
            }).fail(function(){
                alert("服务器请求异常")
            });
        });
        $("#editBtn").click(function(){
            $("#editForm").submit();
        });
        $("#editForm").validate({
            errorElement:"span",
            errorClass:"text-danger",
            rules:{
                bookname:{
                    required:true
                },
                bookauthor:{
                    required:true
                },
                bookprice:{
                    required:true,
                    number:true
                },
                booknum:{
                    required:true,
                    digits:true
                }
            },
            messages:{
                bookname:{
                    required:"请输入书籍名称"
                },
                bookauthor:{
                    required:"请输入作者"
                },
                bookprice:{
                    required:"请输入价格",
                    number:"请输入正确的价格"
                },
                booknum:{
                    required:"请输入数量",
                    digits:"请输入正确的数量"
                }
            },
            submitHandler:function(form){
                $.post("/datatables/edit",$(form).serialize())
                        .done(function(data){
                            if(data == "success") {
                                $("#editBookModal").modal('hide');
                                dataTable.ajax.reload();
                            }
                        })
                        .fail(function(){
                            alert("请求服务器错误");
                        });
            }
        });

    });
</script>

</body>
</html>
