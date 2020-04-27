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
    <link rel="stylesheet" href="${ctx }/resources/lib/layui_ext/dtree/dtree.css">
    <link rel="stylesheet" href="${ctx }/resources/lib/layui_ext/dtree/font/dtreefont.css">
    <link rel="stylesheet" href="${ctx }/resources/lib/font-awesome-4.7.0/css/font-awesome.min.css" media="all">
    <style type="text/css">
        .select-test{position: absolute;max-height: 500px;height: 350px;overflow: auto;width: 100%;z-index: 123;display: none;border:1px solid silver;top: 42px;}
        .layui-show{display: block!important;}
    </style>
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
    <%--添加和修改的弹出层--%>
    <div style="display: none;padding: 20px" id="saveOrUpdateDiv">
        <form class="layui-form" lay-filter="dataFrm" id="dataFrm">
            <div class="layui-form-item">
                <label class="layui-form-label">父级菜单：</label>
                <div class="layui-input-block">
                    <div class="layui-unselect layui-form-select" id="pid_div">
                        <div class="layui-select-title">
                            <input type="hidden" name="pid" id="pid">
                            <input type="text" name="pid_str" id="pid_str" placeholder="请选择" readonly="" class="layui-input layui-unselect">
                            <i class="layui-edge"></i>
                        </div>
                    </div>
                    <div class="layui-card select-test" id="menuSelectDiv">
                        <div class="layui-card-body">
                            <div id="toolbarDiv"><ul id="menuTree" class="dtree" data-id="0" style="width: 100%;"></ul></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">菜单名称:</label>
                <div class="layui-input-block">
                    <input type="hidden" name="id">
                    <input type="text" name="title" placeholder="请输入菜单名称" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
               <div class="layui-inline">
                   <label class="layui-form-label">菜单图标:</label>
                   <div class="layui-input-inline"  style="width: 230px">
                       <input type="text" id="icon" name="icon" value="fa-arrows" lay-filter="iconPicker" class="hide">
                   </div>
               </div>
                <div class="layui-inline">
                    <label class="layui-form-label">TARGET:</label>
                    <div class="layui-input-inline">
                        <input type="text" name="target"  placeholder="请输入TRAGET"  autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">菜单地址:</label>
                <div class="layui-input-block">
                    <input type="text" name="href" placeholder="请输入菜单地址" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">是否可用:</label>
                <div class="layui-input-block">
                    <input type="radio" name="available" value="1" checked="checked" title="可用">
                    <input type="radio" name="available" value="0" title="不可">
                </div>
            </div>
            <div class="layui-form-item" style="text-align: center">
                <div class="layui-input-block">
                    <button type="button" class="layui-btn layui-btn-normal layui-btn-sm layui-icon layui-icon-release"
                            lay-filter="doSubmit" lay-submit="">提交</button>
                    <button type="reset"
                            class="layui-btn layui-btn-warm layui-btn-sm layui-icon dtree-icon-refresh">重置</button>
                </div>
            </div>
        </form>
    </div>


    <script src="${ctx}/resources/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
    <script src="${ctx}/resources/js/lay-config.js?v=2.0.0" charset="utf-8"></script>
    <script type="text/javascript">
        let tableIns;
        layui.extend({
            dtree:'layui_ext/dist/dtree'
        }).use(['jquery', 'layer', 'form', 'table' ,'iconPickerFa','dtree'],
            function () {
            let  $=layui.jquery,
                layer=layui.layer,
                form=layui.form,
                iconPickerFa = layui.iconPickerFa,
                dtree=layui.dtree,
                table=layui.table;

            iconPickerFa.render({
                // 选择器，推荐使用input
                elem: '#icon',
                // fa 图标接口
                url: "${ctx}/resources/lib/font-awesome-4.7.0/less/variables.less",
                // 数据类型：fontClass/unicode，推荐使用fontClass
                type: 'fontClass',
                // 是否开启搜索：true/false
                search: true,
                // 是否开启分页
                page: true,
                // 每页显示数量，默认12
                limit: 12,
                //单元格宽度
                cellWidth:'43px',
                // 点击回调
                click: function (data) {

                },
                // 渲染成功后的回调
                success: function (d) {

                }
            });


            //初始化表格
            tableIns=table.render({
               elem:'#menuTab',
                url:'${ctx}/menu/loadAllMenu.action',
                title:'用户数据表',
                toolbar:'#menuToolBar',
                //height:'full-150',
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

            table.on("toolbar(menuTable)",function (obj) {
                switch (obj.event) {
                        case "add":
                            openAddMenu();
                            break;
                        case "batchDelete":
                            layer.msg("批量删除");
                            break;
                }
            });

            table.on('tool(menuTable)',function (obj) {
                let data=obj.data;
                let layEvent = obj.event;
                if(layEvent=='del'){
                    $.post("${ctx}/menu/checkMenuHasChildren.action?id="+data.id,function (obj) {
                        if(obj.code>=0){
                            layer.msg("当前菜单有子节点，请先删除子节点")
                        }else {
                            layer.confirm('真的删除【'+data.title+'】这个菜单吗?',
                                function (index) {
                                $.post('${ctx}/menu/deleteMenu.action',{id:data.id},function (res) {
                                    layer.msg(res.msg);
                                    tableIns.reload();
                                    window.parent.left.menuTree.reload();
                                    menuTree.reload();
                                })
                            })
                        }
                    })
                }else if(layEvent=='edit'){
                    openUpdateMenu(data);
                }
            });

            let url;
            let mainIndex;

            //打开添加页面
            function openAddMenu(){
                mainIndex=layer.open({
                    type:1,
                    title:'添加菜单',
                    content:$("#saveOrUpdateDiv"),
                    area:['800px','450px'],
                    success:function(index){
                        //清空表单数据
                        $("#dataFrm")[0].reset();
                        $("#menuSelectDiv").removeClass("layui-show");
                        url="${ctx}/menu/addMenu.action";
                    }
                });
            }
            //打开修改页面
            function openUpdateMenu(data){
                mainIndex=layer.open({
                    type:1,
                    title:'修改用户',
                    content:$("#saveOrUpdateDiv"),
                    area:['800px','450px'],
                    success:function(index){
                        form.val("dataFrm",data);
                        url="${ctx}/menu/updateMenu.action";
                        var pid=data.pid;
                        var params=dtree.dataInit('menuTree',pid);
                        $("#menuSelectDiv").removeClass("layui-show");
                        $("#pid_str").val(params.context);
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
                    layer.close(mainIndex);
                    //刷新数据 表格
                    tableIns.reload();
                    //刷新左边的树
                    window.parent.left.menuTree.reload();
                    //刷新添加和修改的下拉树
                    menuTree.reload();
                })
            });
            //初始化添加和修改页面的下拉树
            let menuTree = dtree.render({
                elem: "#menuTree",
                dataStyle: "layuiStyle",  //使用layui风格的数据格式
                response:{message:"msg",statusCode:0},  //修改response中返回数据的定义
                dataFormat: "list",  //配置data的风格为list
                url: "${ctx}/menu/loadMenuManagerLeftTreeJson.action",  // 使用url加载（可与data加载同时存在）
                icon: "2",
                accordion:true
            });
            $("#pid_div").on("click",function(){
                $(this).toggleClass("layui-form-selected");
                $("#menuSelectDiv").toggleClass("layui-show layui-anim layui-anim-upbit");
            });
            dtree.on("node(menuTree)", function(obj){
                $("#pid_str").val(obj.param.context);
                $("#pid").val(obj.param.nodeId);
                $("#pid_div").toggleClass("layui-form-selected");
                $("#menuSelectDiv").toggleClass("layui-show layui-anim layui-anim-upbit");
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
