<%--
  Created by IntelliJ IDEA.
  User: JiangZhikuan
  Date: 2020/5/9
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>客户管理</title>
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
    <!-- 搜索条件 -->
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>查询条件</legend>
    </fieldset>
    <form class="layui-form" method="post" id="searchFrm">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">身份证号:</label>
                <div class="layui-input-inline">
                    <input type="text" name="identity"  autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">客户姓名:</label>
                <div class="layui-input-inline">
                    <input type="text" name="custname"  autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">客户地址:</label>
                <div class="layui-input-inline">
                    <input type="text" name="address"  autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">客户电话:</label>
                <div class="layui-input-inline">
                    <input type="text" name="phone"  autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">客户职位:</label>
                <div class="layui-input-inline">
                    <input type="text" name="career"  autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">性别:</label>
                <div class="layui-input-inline">
                    <input type="radio" name="sex" value="1" title="男">
                    <input type="radio" name="sex" value="0" title="女">
                </div>
            </div>
        </div>
        <div  class="layui-form-item" style="text-align: center;">
            <div class="layui-input-block" >
                <button type="button" class="layui-btn layui-btn-normal  layui-icon layui-icon-search" id="doSearch">查询</button>
                <button type="reset" class="layui-btn layui-btn-warm  layui-icon layui-icon-refresh">重置</button>
            </div>
        </div>
    </form>

    <%--数据表格--%>
    <table class="layui-hide" id="customerTable" lay-filter="customerTable"></table>

    <%--数据表格工具--%>
    <div style="display: none;" id="customerToolBar">
        <button type="button" class="layui-btn layui-btn-sm" lay-event="add">增加</button>
        <button type="button" class="layui-btn layui-btn-danger layui-btn-sm" lay-event="deleteBatch">批量删除</button>
    </div>
    <div  id="customerBar" style="display: none;">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </div>
    <div style="display: none;padding: 20px" id="saveOrUpdateDiv" >
        <form class="layui-form"  lay-filter="dataFrm" id="dataFrm">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">身份证号:</label>
                    <div class="layui-input-inline">
                        <input type="text" name="identity" lay-verify="required"   placeholder="请输入身份证号" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">客户姓名:</label>
                    <div class="layui-input-inline">
                        <input type="text" name="custname" lay-verify="required"   placeholder="请输入客户姓名" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">客户电话:</label>
                    <div class="layui-input-inline">
                        <input type="text" name="phone"  placeholder="请输入客户电话" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">客户地址:</label>
                    <div class="layui-input-inline">
                        <input type="text" name="address"  placeholder="请输入客户地址" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">客户职位:</label>
                    <div class="layui-input-inline">
                        <input type="text" name="career"   placeholder="请输入客户职位" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">客户性别:</label>
                    <div class="layui-input-inline">
                        <input type="radio" name="sex" value="1" checked="checked" title="男">
                        <input type="radio" name="sex" value="0" title="女">
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
        layui.use([ 'jquery', 'layer', 'form', 'table'  ], function() {
            let $ = layui.jquery,
                layer = layui.layer,
                form = layui.form,
                table = layui.table;
            var tableIns=table.render({
               elem:'#customerTable',
               url:'${ctx}/customer/loadAllCustomer.action',
               title:'客户数据表',
               toolbar:'#customerToolBar',
               //height:'full-220',
               cellMinWidth:100,
               page:true,
               cols:[[
                   {type: 'checkbox', fixed: 'left'}
                   ,{field:'identity', title:'身份证号',align:'center',width:'15%'}
                   ,{field:'custname', title:'客户姓名',align:'center',width:'12%'}
                   ,{field:'phone', title:'客户电话',align:'center',width:'13%'}
                   ,{field:'address', title:'客户地址',align:'center',width:'15%'}
                   ,{field:'career', title:'客户职位',align:'center',width:'10%'}
                   ,{field:'sex', title:'性别',align:'center',width:'10%',templet:function(d){
                           return d.sex=='1'?'<font color=blue>男</font>':'<font color=red>女</font>';
                       }}
                   ,{field:'createtime', title:'录入时间',align:'center',width:'10%'}
                   ,{fixed: 'right', title:'操作', toolbar: '#customerBar', width:180,align:'center'}
               ]], 
                done:function (data,curr,count) {
                    if(data.data.length==0&&curr!=1){
                        tableIns.reload({
                           page:{
                               curr:curr-1
                           }
                        });
                    }
                }
            });
            $('#doSearch').click(function () {
                let params=$('#searchForm').serialize();
                tableIns.reload({
                    url: "${ctx}/customer/loadAllCustomer.action?"+params,
                    page:{
                        curr: 1
                    }
                })
            });

            table.on('toolbar(customerTable)',function (obj) {
                switch (obj.event) {
                    case 'add':
                        openAddCustomer();
                        break;
                    case 'deleteBatch':
                        deleteBatch();
                        break;
                }
            });

            table.on('tool(customerTable)',function (obj) {
                let data=obj.data;
                let layEvent=obj.event;
                if (layEvent==='del'){
                    layer.confirm('真的要删除【'+data.custname+'】这个客户么',function (index) {
                        $.post('${ctx}/customer/deleteCustomer.action',
                            {identity:data.identity},
                            function (res) {
                            layer.msg(res.msg);
                            tableIns.reload();
                        })
                    })
                }else if (layEvent==='edit') {
                    openUpdateCustomer(data);
                }
            });

            var url;
            var mainIndex;
            function openAddCustomer() {
                mainIndex=layer.open({
                    type:1,
                    title:"添加客户",
                    content:$('#saveOrUpdateDiv'),
                    area:['800px','400px'],
                    success:function (index) {
                        $('#dataFrm')[0].reset();
                        url="${ctx}/customer/addCustomer.action";
                    }
                })
            }
            function openUpdateCustomer(data) {
                mainIndex=layer.open({
                    type:1,
                    title:'修改客户',
                    content:$('#saveOrUpdateDiv'),
                    area: ['800px','400px'],
                    success:function (index) {
                        form.val('dataFrm',data);
                        url="${ctx}/customer/updateCustomer.action";
                    }
                })
            }
            form.on('submit(doSubmit)',function (obj) {
                let params=$('#dataFrm').serialize();
                $.post(url,params,function (obj) {
                    layer.msg(obj.msg);
                    layer.close(mainIndex);
                    tableIns.reload();
                })
            });
            function deleteBatch() {
                let checkStatus=table.checkStatus('customerTable');
                let data=checkStatus.data;
                let params='';
                $.each(data,function (i,item) {
                    if(i===0){
                        params+='identitys='+item.identity;
                    }else {
                        params+="&identitys="+item.identity;
                    }
                });
                layer.confirm('真的删除选中的这些客户嘛',function (index) {
                    $.post('${ctx}/customer/deleteBatchCustomer.action',params,function (res) {
                        layer.msg(res.msg);
                        tableIns.reload();
                    })
                })
            }
        });
    </script>
</body>
</html>
