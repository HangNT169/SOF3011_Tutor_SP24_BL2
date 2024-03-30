<%--
  Created by IntelliJ IDEA.
  User: Ducbu
  Date: 14/03/2024
  Time: 11:39 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sửa giảng viên</title>
</head>
<body>
<form action="/giang-vien/update?id=${gv1.id2343}" method="post">
    Mã: <input type="text" name="mssv1" value="${gv1.mssv1}"/>
    <br/>
    Tên: <input type="text" name="ten" value="${gv1.ten}"/>
    <br/>
    Tuổi: <input type="text" name="tuoi" value="${gv1.tuoi}"/>
    <br/>
    Giới tính:
    <input type="radio" name="gioiTinh" value="true" ${gv1.gioiTinh == true  ? "checked" : ""}/>Nam
    <input type="radio" name="gioiTinh" value="false" ${gv1.gioiTinh == false  ? "checked" : ""}/>Nữ
    <br/>
    Quê quán: <input type="text" name="queQuan" value="${gv1.queQuan}"/>
    <br>
    <button type="submit">Update</button>
</form>
</body>
</html>
