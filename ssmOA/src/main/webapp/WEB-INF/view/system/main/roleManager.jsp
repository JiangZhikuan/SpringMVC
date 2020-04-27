<%--
  Created by IntelliJ IDEA.
  User: JiangZhikuan
  Date: 2020/4/27
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>角色管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${ctx }/resources/lib/layui-v2.5.5/css/layui.css" media="all" />
    <link rel="stylesheet" href="${ctx }/resources/css/public.css" media="all" />
    <link rel="stylesheet" href="${ctx }/resources/lib/layui_ext/dtree/dtree.css">
    <link rel="stylesheet" href="${ctx }/resources/lib/layui_ext/dtree/font/dtreefont.css">
    <link rel="stylesheet" href="${ctx }/resources/lib/font-awesome-4.7.0/css/font-awesome.min.css" media="all">
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>查询条件</legend>
</fieldset>
<form class="layui-form" method="post" id="searchFrm">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">角色名称:</label>
            <div class="layui-input-inline">
                <input type="text" name="rolename"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">角色备注:</label>
            <div class="layui-input-inline">
                <input type="text" name="roledesc"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">是否可用:</label>
            <div class="layui-input-inline">
                <input type="radio" name="available" value="1" title="可用">
                <input type="radio" name="available" value="0" title="不可">
            </div>
        </div>
        <div class="layui-inline">
            <button type="button" class="layui-btn layui-btn-normal  layui-icon layui-icon-search" id="doSearch">查询</button>
            <button type="reset" class="layui-btn layui-btn-warm  layui-icon layui-icon-refresh">重置</button>
        </div>
    </div>
</form>

<table class="layui-hide" id="roleTable" lay-filter="roleTable"></table>
<div style="display: none;" id="roleToolBar">
    <button type="button" class="layui-btn layui-btn-sm" lay-event="add">增加</button>
    <button type="button" class="layui-btn layui-btn-danger layui-btn-sm" lay-event="deleteBatch">批量删除</button>
</div>
<div  id="roleBar" style="display: none;">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="selectRoleMenu">分配菜单</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</div>

<div style="display: none;padding: 20px" id="saveOrUpdateDiv" >
    <form class="layui-form"  lay-filter="dataFrm" id="dataFrm">
        <div class="layui-form-item">
            <label class="layui-form-label">角色名称:</label>
            <div class="layui-input-block">
                <input type="hidden" name="roleid">
                <input type="text" name="rolename"  placeholder="请输入角色名称" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">角色备注:</label>
            <div class="layui-input-block">
                <input type="text" name="roledesc" placeholder="请输入角色备注" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">是否可用:</label>
                <div class="layui-input-inline">
                    <input type="radio" name="available" value="1" checked="checked" title="可用">
                    <input type="radio" name="available" value="0" title="不可用">
                </div>
            </div>
        </div>
        <div class="layui-form-item" style="text-align: center;">
            <div class="layui-input-block">
                <button type="button" class="layui-btn layui-btn-normal layui-btn-sm layui-icon layui-icon-release" lay-filter="doSubmit" lay-submit="">提交</button>
                <button type="reset" class="layui-btn layui-btn-warm layui-btn-sm layui-icon layui-icon-refresh" >重置</button>
            </div>
        </div>
    </form>

</div>
<script src="${ctx}/resources/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script src="${ctx}/resources/js/lay-config.js?v=2.0.0" charset="utf-8"></script>
<script type="text/javascript">
    layui.extend({
        dtree:'layui_ext/dist/dtree'
    }).use([ 'jquery', 'layer', 'form', 'table','dtree' ],function () {
        var $ = layui.jquery,
            layer = layui.layer,
            form = layui.form,
            table = layui.table,
            dtree=layui.dtree;

        //渲染数据表格
        let tableIns=table.render({
            elem: '#roleTable'   //渲染的目标对象
            ,url:'${ctx}/role/loadAllRole.action' //数据接口
            ,title: '用户数据表'//数据导出来的标题
            ,toolbar:"#roleToolBar"   //表格的工具条
            ,height:'full-150'
            ,cellMinWidth:100 //设置列的最小默认宽度
            ,page: true  //是否启用分页
            ,cols: [[   //列表数据
                {type: 'checkbox', fixed: 'left'}
                ,{field:'roleid', title:'ID',align:'center'}
                ,{field:'rolename', title:'角色名称',align:'center'}
                ,{field:'roledesc', title:'角色备注',align:'center'}
                ,{field:'available', title:'是否可用',align:'center',templet:function(d){
                        return d.available=='1'?'<font color=blue>可用</font>':'<font color=red>不可用</font>';
                    }}
                ,{fixed: 'right', title:'操作', toolbar: '#roleBar', width:220,align:'center'}
            ]]
        })
        //模糊查询
        $("#doSearch").click(function(){
            var params=$("#searchFrm").serialize();
            tableIns.reload({
                url:"${ctx}/role/loadAllRole.action?"+params
            })
        });

        //监听头部工具栏事件
        table.on("toolbar(roleTable)",function(obj){
            switch(obj.event){
                case 'add':
                    openAddRole();
                    break;
                case 'deleteBatch':
                    deleteBatch();
                    break;
            };
        })
        //监听行工具事件
        table.on('tool(roleTable)', function(obj){
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            if(layEvent === 'del'){ //删除
                layer.confirm('真的删除【'+data.rolename+'】这个角色吗', function(index){
                    //向服务端发送删除指令
                    $.post("${ctx}/role/deleteRole.action",{roleid:data.roleid},function(res){
                        layer.msg(res.msg);
                        //刷新数据 表格
                        tableIns.reload();
                    })
                });
            } else if(layEvent === 'edit'){ //编辑
                openUpdateRole(data);
            }
        });

        var url;
        var mainIndex;
        //打开添加页面
        function openAddRole(){
            mainIndex=layer.open({
                type:1,
                title:'添加角色',
                content:$("#saveOrUpdateDiv"),
                area:['800px','300px'],
                success:function(index){
                    //清空表单数据
                    $("#dataFrm")[0].reset();
                    url="${ctx}/role/addRole.action";
                }
            });
        }
        //打开修改页面
        function openUpdateRole(data){
            mainIndex=layer.open({
                type:1,
                title:'修改用户',
                content:$("#saveOrUpdateDiv"),
                area:['800px','300px'],
                success:function(index){
                    form.val("dataFrm",data);
                    url="${ctx}/role/updateRole.action";
                }
            });
        }
        //保存
        form.on("submit(doSubmit)",function(obj){
            //序列化表单数据
            var params=$("#dataFrm").serialize();
            $.post(url,params,function(obj){
                layer.msg(obj.msg);
                //关闭弹出层
                layer.close(mainIndex)
                //刷新数据 表格
                tableIns.reload();
            })
        });

        //批量删除
        function deleteBatch(){
            //得到选中的数据行
            var checkStatus = table.checkStatus('roleTable');
            var data = checkStatus.data;
            var params="";
            $.each(data,function(i,item){
                if(i==0){
                    params+="ids="+item.roleid;
                }else{
                    params+="&ids="+item.roleid;
                }
            });
            layer.confirm('真的删除选中的这些角色吗', function(index){
                //向服务端发送删除指令
                $.post("${ctx}/role/deleteBatchRole.action",params,function(res){
                    layer.msg(res.msg);
                    //刷新数据 表格
                    tableIns.reload();
                })
            });
        }

    })

</script>
</body>
</html>
