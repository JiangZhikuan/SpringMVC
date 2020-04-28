<%--
  Created by IntelliJ IDEA.
  User: JiangZhikuan
  Date: 2020/4/24
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜单管理</title>
</head>

<frameset cols="250,*" border="1">
    <frame src="${ctx}/sys/toMenuLeft.action" name="left">
    <frame src="${ctx}/sys/toMenuRight.action" name="right">
</frameset>

</html>
