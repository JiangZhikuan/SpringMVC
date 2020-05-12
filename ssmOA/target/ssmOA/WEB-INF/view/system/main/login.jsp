<%--
  Created by IntelliJ IDEA.
  User: JiangZhikuan
  Date: 2020/4/23
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>OA系统管理-登陆</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="icon" href="${ctx}/resources/images/favicon.ico">
    <link rel="stylesheet" href="${ctx}/resources/lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="${ctx}/resources/css/login.css" media="all">
</head>
<body>
    <div id="container">
        <div></div>
        <div class="admin-login-background">
            <div class="admin-header">
                <span>OA系统管理</span>
            </div>
            <form class="layui-form" id="loginFrm" method="post" action="${ctx }/login/login.action">
                <div>
                    <i class="layui-icon layui-icon-username admin-icon"></i>
                    <input type="text" name="loginname" placeholder="请输入用户名"
                           autocomplete="off" class="layui-input admin-input admin-input-username" value="admin">
                </div>
                <div>
                    <i class="layui-icon layui-icon-password admin-icon"></i>
                    <input type="password" name="pwd"
                           placeholder="请输入密码" autocomplete="off" class="layui-input admin-input" value="123456">
                </div>
                <div>
                    <input type="text" name="identity" placeholder="请输入验证码" autocomplete="off" class="layui-input admin-input admin-input-verify" value="">
                    <img class="admin-captcha" width="90" height="30" src="${ctx}/kaptcha" onclick="this.src='${ctx}/kaptcha'">
                </div>
                <button class="layui-btn admin-button" lay-submit lay-filter="login">登 陆</button>
                <div style="text-align: center;color: red;">
                    ${error }
                </div>
            </form>
        </div>
    </div>
    <script src="${ctx}/resources/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
    <script>
        layui.use(['form','layer','jquery'], function () {
            var form = layui.form,
                layer = layui.layer,
                $ = layui.jquery;

            // 登录过期的时候，跳出ifram框架
            if (top.location != self.location) top.location = self.location;

            // 进行登录操作
            form.on('submit(login)', function (data) {
                data = data.field;
                if (data.username == '') {
                    layer.msg('用户名不能为空');
                    return false;
                }
                if (data.password == '') {
                    layer.msg('密码不能为空');
                    return false;
                }
                if (data.captcha == '') {
                    layer.msg('验证码不能为空');
                    return false;
                }
                $(this).text("登录中...").attr("disabled","disabled").addClass("layui-disabled");
                setTimeout(function(){
                    $("#loginFrm").submit();
                },1000);
                return false;
            });
        });
    </script>
</body>
</html>
