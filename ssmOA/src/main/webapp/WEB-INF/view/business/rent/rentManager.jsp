<%--
  Created by IntelliJ IDEA.
  User: JiangZhikuan
  Date: 2020/5/14
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>出租单管理</title>
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
<!-- 搜索条件开始 -->
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>查询条件</legend>
</fieldset>
<form class="layui-form" method="post" id="searchFrm">
    <div class="layui-form-item">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">出租单号:</label>
                <div class="layui-input-inline">
                    <input type="text" name="rentid"     autocomplete="off"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">身份证号:</label>
                <div class="layui-input-inline">
                    <input type="text" name="identity"     autocomplete="off"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">车牌号:</label>
                <div class="layui-input-inline">
                    <input type="text" name="carnumber"   autocomplete="off"
                           class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">开始时间:</label>
                <div class="layui-input-inline">
                    <input type="text" name="startTime" id="startTime" readonly="readonly"   autocomplete="off"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">结束时间:</label>
                <div class="layui-input-inline">
                    <input type="text" name="endTime" id="endTime"  readonly="readonly"  autocomplete="off"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">出租单状态:</label>
                <div class="layui-input-inline">
                    <input type="radio" name="rentflag" value="1" title="已归还">
                    <input type="radio" name="rentflag" value="0" title="未归还">
                </div>
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

<!-- 搜索条件结束 -->

<!-- 数据表格开始 -->
<table class="layui-hide" id="rentTable" lay-filter="rentTable"></table>
<div style="display: none;" id="rentToolBar">
</div>
<script type="text/html"  id="rentBar">
    {{#  if(d.rentflag ==1){ }}

    {{#  } else { }}
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    {{#  } }}


</script>
<!-- 数据表格结束 -->

<!-- 添加和修改的弹出层开始 -->
<div style="display: none;padding: 20px" id="saveOrUpdateDiv" >
    <form class="layui-form"  lay-filter="dataFrm" id="dataFrm">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">起租时间:</label>
                <div class="layui-input-inline">
                    <input type="text" name="begindate"  id="begindate" readonly="readonly" placeholder="请输入起租时间"  autocomplete="off"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">还车时间:</label>
                <div class="layui-input-inline">
                    <input type="text" name="returndate"  id="returndate" readonly="readonly" placeholder="请输入还车时间"  autocomplete="off"
                           class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">出租单号:</label>
            <div class="layui-input-block">
                <input type="text" name="rentid" lay-verify="required"  readonly="readonly"  placeholder="请输入出租单号" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">身份证号:</label>
            <div class="layui-input-block">
                <input type="text" name="identity" lay-verify="required" readonly="readonly"  placeholder="请输入身份证号" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">车牌号:</label>
                <div class="layui-input-inline">
                    <input type="text" name="carnumber" lay-verify="required"  readonly="readonly"  placeholder="请输入车牌号" autocomplete="off"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">出租价格:</label>
                <div class="layui-input-inline">
                    <input type="text" name="price" lay-verify="required"   placeholder="请输入出租价格" autocomplete="off"
                           class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">操作员:</label>
            <div class="layui-input-block">
                <input type="text" name="opername" lay-verify="required"  readonly="readonly" placeholder="请输入操作员" autocomplete="off"
                       class="layui-input">
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
<!-- 添加和修改的弹出层结束 -->

<script src="${ctx}/resources/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script src="${ctx}/resources/js/lay-config.js?v=2.0.0" charset="utf-8"></script>
<script type="text/javascript">
    var tableIns;
    layui.use([ 'jquery', 'layer', 'form', 'table','laydate'  ], function() {
        var $ = layui.jquery;
        var layer = layui.layer;
        var form = layui.form;
        var table = layui.table;
        var laydate = layui.laydate;
        laydate.render({
            elem:'#startTime',
            type:'datetime'
        });
        laydate.render({
            elem:'#endTime',
            type:'datetime'
        });
        laydate.render({
            elem:'#begindate',
            type:'datetime'
        });
        laydate.render({
            elem:'#returndate',
            type:'datetime'
        });

        //渲染数据表格
        tableIns=table.render({
            elem: '#rentTable'   //渲染的目标对象
            ,url:'${ctx}/rent/loadAllRent.action' //数据接口
            ,title: '出租单数据表'//数据导出来的标题
            ,toolbar:"#rentToolBar"   //表格的工具条
            //,height:'full-220'
            ,cellMinWidth:100 //设置列的最小默认宽度
            ,page: true  //是否启用分页
            ,cols: [[   //列表数据
                {field:'rentid', title:'出租单号',align:'center',width:'280'}
                ,{field:'identity', title:'身份证号',align:'center',width:'180'}
                ,{field:'carnumber', title:'车牌号',align:'center',width:'150'}
                ,{field:'rentflag', title:'出租单状态',align:'center',width:'80',templet:function(d){
                        return d.rentflag=='1'?'<font color=blue>已归还</font>':'<font color=red>未归还</font>';
                    }}
                ,{field:'begindate', title:'起租时间',align:'center',width:'180'}
                ,{field:'returndate', title:'还车时间',align:'center',width:'180'}
                ,{field:'price', title:'出租价格',align:'center',width:'120'}
                ,{field:'opername', title:'操作员',align:'center',width:'120'}
                ,{field:'createtime', title:'录入时间',align:'center',width:'180'}
                ,{fixed: 'right', title:'操作', toolbar: '#rentBar', width:180,align:'center'}
            ]],
            done:function(data,curr,count){
                //不是第一页时如果当前返回的的数据为0那么就返回上一页
                if(data.data.length==0&&curr!=1){
                    tableIns.reload({
                        page:{
                            curr:curr-1
                        }
                    });
                }
            }
        })
        //模糊查询
        $("#doSearch").click(function(){
            var params=$("#searchFrm").serialize();
            tableIns.reload({
                url:"${ctx}/rent/loadAllRent.action?"+params ,
                page:{
                    curr:1
                }
            })
        });

        //监听行工具事件
        table.on('tool(rentTable)', function(obj){
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            if(layEvent === 'del'){ //删除
                layer.confirm('真的删除【'+data.rentid+'】这个出租单吗', function(index){
                    //向服务端发送删除指令
                    $.post("${ctx}/rent/deleteRent.action",{rentid:data.rentid},function(res){
                        layer.msg(res.msg);
                        //刷新数据 表格
                        tableIns.reload();
                    })
                });
            } else if(layEvent === 'edit'){ //编辑
                openUpdateRent(data);
            }
        });

        var url;
        var mainIndex;
        //打开修改页面
        function openUpdateRent(data){
            mainIndex=layer.open({
                type:1,
                title:'修改出租单',
                content:$("#saveOrUpdateDiv"),
                area:['800px','400px'],
                success:function(index){
                    form.val("dataFrm",data);
                    url="${ctx}/rent/updateRent.action";
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
    });

</script>
</body>
</html>
