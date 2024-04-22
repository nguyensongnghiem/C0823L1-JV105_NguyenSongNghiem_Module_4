<%--
  Created by IntelliJ IDEA.
  User: nghie
  Date: 17/04/2024
  Time: 6:02 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exchange</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<h1> Chuyển đổi tiền tệ </h1>
<form action="/calculate" method="get" class="form-control">
    <label for="usd" class="form-label">Số tiền theo USD </label>
    <input class="form-control" id="usd" type="text" name="usd" placeholder="Nhập số tiền theo USD"></input>
    <div>
        <label class="form-label" >Tỷ giá: 25.000 </label>
    </div>
    <button type="submit" class="btn btn-primary">Chuyển đổi</button>
</form>

</body>
</html>
