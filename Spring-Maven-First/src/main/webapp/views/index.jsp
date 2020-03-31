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
    <script>
        window.onload=function () {
            const request = new XMLHttpRequest();
            request.open("POST","/Spring_Maven_First/user/getUser",true);
            request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            request.send("id=1");
            request.onreadystatechange=function () {
                if(request.status==200&&request.readyState==4){
                document.getElementById("user").innerText=request.responseText;
                }
            }
        }
    </script>
</head>
<body>

    <h1>SpringMVC-Maven</h1>

    <div id="user">

    </div>
</body>
</html>
