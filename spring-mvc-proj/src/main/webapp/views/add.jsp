<%--
  Created by IntelliJ IDEA.
  User: nghie
  Date: 12/04/2024
  Time: 7:01 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <form action="/add" class="form-control px-2">
        <label for="id" class="form-label mt-3 fw-bold">Nhập Id</label>
        <input id="id" type="text" class="form-control">
        <label for="name" class="form-label mt-3 fw-bold">Nhập tên</label>
        <input id="name" type="text" class="form-control">
        <button type="submit" class="btn btn-primary mt-3">Thêm mới</button>
    </form>
</div>
</body>
</html>
