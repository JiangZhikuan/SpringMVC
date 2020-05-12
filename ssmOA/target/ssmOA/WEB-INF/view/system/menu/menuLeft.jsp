<%--
  Created by IntelliJ IDEA.
  User: JiangZhikuan
  Date: 2020/4/24
  Time: 15:18
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

</head>
<body>
    <div class="layuimini-container">
        <div class="layuimini-main">
            <ul id="menuTree" class="dtree" data-id="0"></ul>
        </div>
    </div>
    <script src="${ctx}/resources/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
    <script src="${ctx}/resources/js/lay-config.js?v=2.0.0" charset="utf-8"></script>
    <script type="text/javascript">
        var menuTree;
    layui.extend({
        dtree:'layui_ext/dist/dtree'
    }).use(['layer', 'miniTab','form','dtree','jquery'],function () {
        let form = layui.form,
            layer = layui.layer,
            dtree = layui.dtree,
            $ = layui.jquery,
            miniTab = layui.miniTab;
        miniTab.listen();
        // 初始化树
        menuTree = dtree.render({
            elem: "#menuTree",
            dataStyle: "layuiStyle",  //使用layui风格的数据格式
            response:{message:"msg",statusCode:0},  //修改response中返回数据的定义
            dataFormat: "list",  //配置data的风格为list
            url: "${ctx}/menu/loadMenuManagerLeftTreeJson.action" // 使用url加载（可与data加载同时存在）
        });

        //监听树的节点点击 事件
        dtree.on("node('menuTree')" ,function(obj){
            var id=obj.param.nodeId;
            window.parent.right.reloadTable(id);
        });
    });

</script>
</body>
</html>
