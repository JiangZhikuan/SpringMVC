<%--
  Created by IntelliJ IDEA.
  User: JiangZhikuan
  Date: 2020/4/24
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>菜单管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${ctx }/resources/lib/layui-v2.5.5/css/layui.css" media="all" />
    <link rel="stylesheet" href="${ctx }/resources/css/public.css" media="all" />
</head>
<body>

<div class="layuimini-container">
    <div class="layuimini-main">
        <%--搜索条件--%>
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: ;: 20px">
            <legend>查询条件</legend>
        </fieldset>
        <form class="layui-form" method="post" id="searchForm">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">菜单名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="title" autocapitalize="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <button type="button" class="layui-btn layui-btn-normal layui-icon layui-icon-search"
                            id="doSearch">查询</button>
                    <button type="button" class="layui-btn layui-btn-warm layui-icon layui-icon-refresh">
                        重置</button>
                </div>
            </div>
        </form>

        <%--数据表格--%>
        <table class="layui-hide" id="menuTab" lay-filter="menuTable"></table>
        <div style="display: none" id="menuToolBar">
            <button type="button" class="layui-btn layui-btn-sm" lay-event="add">增加</button>
            <button type="button" class="layui-btn layui-btn-sm" lay-event="batchDelete">批量删除</button>
        </div>
        <div style="display: none" id="menuBar">
            <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
        </div>
    </div>
</div>


    <script src="${ctx}/resources/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
    <script src="${ctx}/resources/js/lay-config.js?v=2.0.0" charset="utf-8"></script>
    <script type="text/javascript">
        var tableIns;
        layui.use(['jquery', 'layer', 'form', 'table' ],function () {
            let  $=layui.jquery,
                layer=layui.layer,
                form=layui.form,
                table=layui.table;
            //初始化表格
            tableIns=table.render({
               elem:'#menuTab',
                url:'${ctx}/menu/loadAllMenu.action',
                title:'用户数据表',
                toolbar:'#menuToolBar',
                height:'full-150',
                cellMinWidth:100,
                page:true,
                cols:[[
                    {type: 'checkbox', fixed: 'left'},
                    {field:'id', title:'ID',align:'center',width:'10%'},
                    {field:'pid', title:'父节点ID',align:'center',width:'10%'},
                    {field:'title', title:'菜单名称',align:'center',width:'15%'},
                    {field:'href', title:'菜单地址',align:'center',width:'20%'},
                    {field:'target', title:'TARGET',align:'center',width:'8%'},
                    {field:'icon', title:'菜单图标',align:'center',width:'8%',templet:function(d){
                            return "<div class='"+d.icon+"'></div>";
                        }}
                    ,{field:'status', title:'是否可用',align:'center',width:'10%',templet:function(d){
                            return d.status=='1'?'<font color=blue>可用</font>':'<font color=red>不可用</font>';
                        }}
                    ,{fixed: 'right', title:'操作', toolbar: '#menuBar', width:'15%',align:'center'}
                ]]
            });

            //模糊查询
            $('#doSearch').click(function () {
                var params=$('#searchForm').serialize();
                tableIns.reload({
                    url:"${ctx}/menu/loadAllMenu.action?"+params
                })
            });

        });
        function reloadTable(id) {
            tableIns.reload({
                url:"${ctx}/menu/loadAllMenu.action?id="+id
            })
        }
    </script>
</body>
</html>
