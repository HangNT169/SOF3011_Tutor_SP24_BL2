<%--
  Created by IntelliJ IDEA.
  User: hangnt
  Date: 27/3/24
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<form action="/giang-vien/add" method="post">
    <div>
        <span>Mã:</span>
        <input type="text" name="mssv1">
    </div>
    <div>
        <span>Tên:</span>
        <input type="text" name="ten">
    </div>
    <div>
        <span>Tuổi:</span>
        <input type="text" name="tuoi">
    </div>
    <div>
        <span>Giới tính:</span>
        <input type="radio" name="gioiTinh" checked value="true">Nam
        <input type="radio" name="gioiTinh" value="false">Nữ
    </div>
    <div>
        <span>Quê quán:</span>
        <input type="text" name="queQuan">
    </div>
    <button type="submit">Add</button>
</form>
<table class="table">
    <thead>
    <tr>
        <th scope="col">MaSV</th>
        <th scope="col">HoTen</th>
        <th scope="col">Tuoi</th>
        <th scope="col">GioiTinh</th>
        <th scope="col">QueQuan</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${a}" var="gv">
        <tr>
            <td>${gv.mssv1}</td>
            <td>${gv.ten}</td>
            <td>${gv.tuoi}</td>
            <td>${gv.gioiTinh}</td>
            <td>${gv.queQuan}</td>
            <td>
                <a href="/giang-vien/remove?idXoa=${gv.id2343}">Xoá</a>
                <a href="/giang-vien/detail?idDetail=${gv.id2343}">Detail</a>
                <a href="/giang-vien/view-update?idUpdate=${gv.id2343}">Update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
