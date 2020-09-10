<%--
  Created by IntelliJ IDEA.
  User: 23896
  Date: 2020/9/8
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>">
    <link href="static/css/app.css" rel="stylesheet">
    <!-- jQuery -->
    <script type="text/javascript" src="static/jquery/jquery-1.12.4.min.js"></script>
</head>
<body>
    <form action="login">
        <!---->
        <input type="text" name ="username" placeholder="请输入用户名">
        <input type="password" name ="password" placeholder="请输入密码">
        <input type="submit"  value="提交">
    </form>
</body>
</html>
