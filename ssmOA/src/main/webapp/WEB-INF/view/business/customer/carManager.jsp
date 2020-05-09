<%--
  Created by IntelliJ IDEA.
  User: JiangZhikuan
  Date: 2020/5/9
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>车辆管理</title>
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
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>查询条件</legend>
    </fieldset>
    <form class="layui-form" method="post" id="searchFrm">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">车牌号:</label>
                <div class="layui-input-inline">
                    <input type="text" name="carnumber"  autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">车辆类型:</label>
                <div class="layui-input-inline">
                    <input type="text" name="cartype"  autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">车辆颜色:</label>
                <div class="layui-input-inline">
                    <input type="text" name="color"  autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">车辆描述:</label>
                <div class="layui-input-inline">
                    <input type="text" name="description"  autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">是否出租:</label>
                <div class="layui-input-inline">
                    <input type="radio" name="isrenting" value="1" title="已出租">
                    <input type="radio" name="isrenting" value="0" title="未出租">
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
    <table class="layui-hide" id="carTable" lay-filter="carTable"></table>
    <div style="display: none;" id="carToolBar">
        <button type="button" class="layui-btn layui-btn-sm" lay-event="add">增加</button>
        <button type="button" class="layui-btn layui-btn-danger layui-btn-sm" lay-event="deleteBatch">批量删除</button>
    </div>
    <div  id="carBar" style="display: none;">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
        <a class="layui-btn layui-btn-xs" lay-event="viewImage">查看大图</a>
    </div>

    <div style="display: none;padding: 20px" id="saveOrUpdateDiv" >
        <form class="layui-form layui-row layui-col-space10"  lay-filter="dataFrm" id="dataFrm">
            <div class="layui-col-md12 layui-col-xs12">
                <div class="layui-row layui-col-space10">
                    <div class="layui-col-md9 layui-col-xs7">
                        <div class="layui-form-item magt3">
                            <label class="layui-form-label">车牌号:</label>
                            <div class="layui-input-block">
                                <input type="text" name="carnumber" id="carnumber" class="layui-input" lay-verify="required" placeholder="请输入车牌号">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">车辆类型:</label>
                            <div class="layui-input-block">
                                <input type="text" name="cartype" class="layui-input" lay-verify="required" placeholder="请输入车辆类型">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">车辆颜色:</label>
                            <div class="layui-input-block">
                                <input type="text" name="color" class="layui-input" lay-verify="required" placeholder="请输入车辆颜色">
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md3 layui-col-xs5">
                        <div class="layui-upload-list thumbBox mag0 magt3" id="carimgDiv">
                            <!-- 显示上传的图片 -->
                            <img class="layui-upload-img thumbImg" id="showCarImg">
                            <!-- 保存当前显示图片的地址 -->
                            <input type="hidden" name="carimg" id="carimg">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item magb0">
                    <div class="layui-inline">
                        <label class="layui-form-label">购买价格:</label>
                        <div class="layui-input-block">
                            <input type="text" name="price" class="layui-input" lay-verify="required|number" placeholder="请输入购买价格">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">出租价格:</label>
                        <div class="layui-input-block">
                            <input type="text" name="rentprice" class="layui-input" lay-verify="required|number" placeholder="请输入出租价格">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">出租押金:</label>
                        <div class="layui-input-block">
                            <input type="text" name="deposit" class="layui-input" lay-verify="required|number" placeholder="请输入出租押金">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item magb0">
                    <label class="layui-form-label">车辆描述:</label>
                    <div class="layui-input-block">
                        <input type="text" name="description" class="layui-input" lay-verify="required" placeholder="请输入车辆描述">
                    </div>
                </div>
                <div class="layui-form-item magb0">
                    <label class="layui-form-label">出租状态:</label>
                    <div class="layui-input-block">
                        <input type="radio" name="isrenting" value="1" title="已出租">
                        <input type="radio" name="isrenting" value="0" title="未出租" checked="checked">
                    </div>
                </div>
                <div class="layui-form-item magb0" style="text-align: center;">
                    <div class="layui-input-block">
                        <button type="button" class="layui-btn layui-btn-normal layui-btn-sm layui-icon layui-icon-release" lay-filter="doSubmit" lay-submit="">提交</button>
                        <button type="reset" class="layui-btn layui-btn-warm layui-btn-sm layui-icon layui-icon-refresh" >重置</button>
                    </div>
                </div>
            </div>
        </form>

    </div>

    <script src="${ctx}/resources/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
    <script src="${ctx}/resources/js/lay-config.js?v=2.0.0" charset="utf-8"></script>
    <script type="text/javascript">
        layui.use([ 'jquery', 'layer', 'form', 'table' ,'upload' ], function() {
            var $ = layui.jquery,
                layer = layui.layer,
                form = layui.form,
                table = layui.table,
                upload=layui.upload;
            var tableIns=table.render({
                elem:'#carTable',
                url:'${ctx}/car/loadAllCar.action',
                title:'车辆数据表',
                toolbar:'#carToolBar',
                cellMinWidth:100,
                page:true,
                cols:[[
                    {type: 'checkbox', fixed: 'left'}
                    ,{field:'carnumber', title:'车牌号',align:'center',width:'10%'}
                    ,{field:'cartype', title:'车辆类型',align:'center',width:'7%'}
                    ,{field:'color', title:'车辆颜色',align:'center',width:'7%'}
                    ,{field:'price', title:'购买价格',align:'center',width:'7%'}
                    ,{field:'rentprice', title:'出租价格',align:'center',width:'7%'}
                    ,{field:'deposit', title:'出租押金',align:'center',width:'7%'}
                    ,{field:'isrenting', title:'出租状态',align:'center',width:'7%',templet:function(d){
                            return d.isrenting=='1'?'<font color=blue>已出租</font>':'<font color=red>未出租</font>';
                        }}
                    ,{field:'description', title:'车辆描述',align:'center',width:'10%'}
                    ,{field:'carimg', title:'缩略图',align:'center',width:'10%'}
                    ,{field:'createtime', title:'录入时间',align:'center',width:'10%'}
                    ,{fixed: 'right', title:'操作', toolbar: '#carBar', width:220,align:'center'}

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

            $("#doSearch").click(function(){
                var params=$("#searchFrm").serialize();
                tableIns.reload({
                    url:"${ctx}/car/loadAllCar.action?"+params ,
                    page:{
                        curr:1
                    }
                })
            });
            //监听头部工具栏事件
            table.on("toolbar(carTable)",function(obj){
                switch(obj.event){
                    case 'add':
                        openAddCar();
                        break;
                    case 'deleteBatch':
                        deleteBatch();
                        break;
                };
            })
            //监听行工具事件
            table.on('tool(carTable)', function(obj){
                var data = obj.data; //获得当前行数据
                var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
                if(layEvent === 'del'){ //删除
                    layer.confirm('真的删除【'+data.custname+'】这个车辆吗', function(index){
                        //向服务端发送删除指令
                        $.post("${ctx}/car/deleteCar.action",{identity:data.identity},function(res){
                            layer.msg(res.msg);
                            //刷新数据 表格
                            tableIns.reload();
                        })
                    });
                } else if(layEvent === 'edit'){ //编辑
                    openUpdateCar(data);
                }
            });

            var url;
            var mainIndex;
            //打开添加页面
            function openAddCar(){
                mainIndex=layer.open({
                    type:1,
                    title:'添加车辆',
                    content:$("#saveOrUpdateDiv"),
                    area:['1000px','450px'],
                    success:function(index){
                        //清空表单数据
                        $("#dataFrm")[0].reset();
                        //设置默认图片
                        $("#showCarImg").attr("src","${ctx}/file/downloadShowFile.action?path=images/defaultcarimage.jpg")
                        $("#carimg").val("images/defaultcarimage.jpg")
                        url="${ctx}/car/addCar.action";
                        $("#carnumber").removeAttr("readonly");
                    }
                });
            }
            //打开修改页面
            function openUpdateCar(data){
                mainIndex=layer.open({
                    type:1,
                    title:'修改车辆',
                    content:$("#saveOrUpdateDiv"),
                    area:['1000px','450px'],
                    success:function(index){
                        form.val("dataFrm",data);
                        $("#showCarImg").attr("src","${ctx}/file/downloadShowFile.action?path="+data.carimg);
                        url="${ctx}/car/updateCar.action";
                        $("#carnumber").attr("readonly","readonly");
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
                var checkStatus = table.checkStatus('carTable');
                var data = checkStatus.data;
                var params="";
                $.each(data,function(i,item){
                    if(i==0){
                        params+="ids="+item.identity;
                    }else{
                        params+="&ids="+item.identity;
                    }
                });
                layer.confirm('真的删除选中的这些车辆吗', function(index){
                    //向服务端发送删除指令
                    $.post("${ctx}/car/deleteBatchCar.action",params,function(res){
                        layer.msg(res.msg);
                        //刷新数据 表格
                        tableIns.reload();
                    })
                });
            }

            upload.render({
                elem: '#carimgDiv',
                url: '${ctx}/file/uploadFile.action',
                method : "post",  //此处是为了演示之用，实际使用中请将此删除，默认用post方式提交
                acceptMime:'images/*',
                field:"mf",
                done:function (res,index,upload) {
                    $('#showCarImg').attr('src',
                        "${ctx}/file/downloadShowFile.action?path="+res.data.src);
                    $('#carimg').val(res.data.src);
                    $('#carimgDiv').css("background","#fff");
                }
            });
        });
    </script>
</body>
</html>
