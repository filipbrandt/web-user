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
    <title>User Update</title>
</head>
<body>

<%
    UserController userController = new UserController();
    User user = userController.getUserById(Integer.parseInt(request.getParameter("id")));
%>

<div class="container-fluid">
    <div class="row justify-content-center align-item-center vh-100">
        <div class="col col-sm-6 col-md-6 col-lg-4 col-xl-3 h-100">
            <form action="/update-user" method="post">
                <input type="hidden" name="id" value="<%=user.getId()%>">
                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text"
                           name="name"
                           id="name"
                           class="form-control"
                           value="<%=user.getName()%>"
                    >
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email"
                           name="email"
                           id="email"
                           class="form-control"
                           value="<%=user.getEmail()%>"
                    >
                </div>
                <div class="form-group">
                    <input type="submit" value="Update" class="btn btn-primary">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
