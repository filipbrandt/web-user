<%@ page import="com.example.demo1.controllers.UserController" %>
<%@ page import="com.example.demo1.models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style.css">
    <title>User Summary</title>
</head>
<body>

<%
    UserController userController = new UserController();
    User user = userController.getUserById(Integer.parseInt(request.getParameter("id")));
%>

<div class="card" style="width: 18rem;">
    <div class="card-header">
        Name: <%=user.getName()%>
    </div>
    <ul class="list-group list-group-flush">
        <li class="list-group-item">Email: <%=user.getEmail()%></li>
        <li class="list-group-item">Person Id: <%=user.getId()%></li>
    </ul>
</div>

<a href="user-update.jsp?id=<%=user.getId()%>" class="btn btn-outline-danger">Update</a>

</body>
</html>
