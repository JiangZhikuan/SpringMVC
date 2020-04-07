<%--
  Created by IntelliJ IDEA.
  User: JZK
  Date: 2020/3/28
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SpringMVC-Maven</title>
    <link rel="stylesheet" href="/layui/css/layui.css">
    <script type="text/javascript" src="/layui/layui.js"/>
    <script type="text/javascript" src="/js/index.js"></script>

</head>
<body>

    <h1>SpringMVC-Maven</h1>

    <div class="layui-row">
        <div class="layui-col-md3">
            <label class="layui-form-label">名称：</label>
            <input type="text" class="layui-input" id="txt_user">
        </div>
        <div class="layui-col-md9">

        </div>
    </div>

    <script>
        layui.use(['form','layer','jquery'],function(){

            let form = layui.form;
            let layer = layui.layer;
            let $=layui.jquery;

            layer.msg('layer-Msg');
            $.ajax({
                type: "get",
                url: "/user/getUser",
                //后台数据处理-下面有具体实现
                data: {
                    "id": "1"
                },
                success: function(d) {
                    let a = eval("(" + d + ")");
                    $('#txt_user').val(a.name);
                }
            });


        });
    </script>
</body>
</html>
