<%--
  Created by IntelliJ IDEA.
  User: ayooo
  Date: 2018/1/18
  Time: 下午9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<img src="/account/authcode.jpg" alt="authcode" id="authcode">

<form action="/account/validation" method="get">
    <input type="text" name="code">
    <input type="submit" >
</form>

<script type="text/javascript">
    var btn = document.getElementById("authcode");
    btn.onclick = function () {
        window.location.href = window.location.href;
    }
</script>
</body>
</html>
