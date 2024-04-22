<%--
  Created by IntelliJ IDEA.
  User: nghie
  Date: 19/04/2024
  Time: 6:47 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Từ điển </title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
  <h2>TỪ ĐIỂN ANH - VIỆT</h2>
  <form class="form-control" action="/find" method="get">
    <label class="form-label"></label>
    <input type="text" name="word" class="form-control" value="${word}">
    <span class="my-3"> Kết quả : </span>
    <c:if test="${meaning==null}">
      <span>Không tìm thay </span>
    </c:if>
    <c:if test="${meaning!=null}">
      <span>${meaning} </span>
    </c:if>
    <br>
    <button type="submit" class="btn btn-primary my-3">Tìm</button>
  </form>
</div>


</body>
</html>
