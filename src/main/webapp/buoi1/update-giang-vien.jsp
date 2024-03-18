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

<form action="/giang-vien/update" method="post">
    ID: <input type="text" name="id" value="${gv111.id}"/>
    <br/>
    Mã: <input type="text" name="ma" value="${gv111.ma}"/>
    <br/>
    Tên: <input type="text" name="ten" value="${gv111.ten}"/>
    <br/>
    Tuổi: <input type="text" name="tuoi" value="${gv111.tuoi}"/>
    <br/>
    Giới tính:
    <input type="radio" name="gioiTinh" value="true" ${gv111.gioiTinh == true?"checked":""}/>Nam
    <input type="radio" name="gioiTinh" value="false" ${gv111.gioiTinh == false?"checked":""}/>Nữ
    <br/>
    Địa chỉ: <input type="text" name="diaChi" value="${gv111.diaChi}"/>
    <br>
    <button type="submit">Update</button>
</form>
</body>
</html>
