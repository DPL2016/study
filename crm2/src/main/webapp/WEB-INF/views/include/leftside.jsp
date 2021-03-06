<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

        <!-- Sidebar Menu -->
        <ul class="sidebar-menu">
            <!-- Optionally, you can add icons to the links -->
            <shiro:hasAnyRoles name="经理,员工">
            <li class="active"><a href="#"><i class="fa fa-home"></i> <span>首页</span></a></li>
            <li><a href="#"><i class="fa fa-bullhorn"></i> <span>公告</span></a></li>
            <li><a href="#"><i class="fa fa-building-o"></i> <span>项目管理</span></a></li>
            <li><a href="#"><i class="fa fa-users"></i> <span>客户管理</span></a></li>
            <li><a href="#"><i class="fa fa-bar-chart"></i> <span>统计</span></a></li>
            <li><a href="#"><i class="fa fa-calendar-check-o"></i> <span>待办事项</span></a></li>
            <li><a href="#"><i class="fa fa-file-text"></i> <span>文档管理</span></a></li>
            </shiro:hasAnyRoles>
            <shiro:hasRole name="管理员">
            <li class="treeview">
                <a href="#"><i class="fa fa-cog"></i> <span>系统管理</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/user/userlist">员工管理</a></li>
                    <li><a href="#">系统设置</a></li>
                </ul>
            </li>
            </shiro:hasRole>
        </ul>
        <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
</aside>


