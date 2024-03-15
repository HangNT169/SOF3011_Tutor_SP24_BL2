<%--
  Created by IntelliJ IDEA.
  User: Ducbu
  Date: 14/03/2024
  Time: 11:38 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm giảng viên</title>
</head>
<body>
<form action="/giang-vien/add" method="post">
     <div>
         <span>ID:</span>
         <input type="text" name="id">
     </div>
    <div>
        <span>Mã:</span>
        <input type="text" name="ma">
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
        <input type="radio" name="gioiTinh" checked value="false">Nữ
    </div>
    <div>
        <span>Địa chỉ:</span>
        <input type="text" name="diaChi">
    </div>
    <button type="submit">Add</button>
</form>
</body>
</html>
