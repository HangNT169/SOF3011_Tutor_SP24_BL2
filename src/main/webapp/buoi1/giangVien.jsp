<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách giảng viên</title>
</head>
<body>
<form action="/giang-vien/search">
    <Span>Tên:</Span>
    <input type="text" name="ten">
    <br>
    <button type="submit">Search</button>
</form>
<br>
<br>
<div>
    <a href="/giang-vien/view-add"><button>Add</button></a>
    <a href="#"><button>Giảng viên nữ</button></a>
</div>
<br>
<table border="1">
    <thead>
    <tr>
        <th>STT</th>
        <th>Mã</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Giới tính</th>
        <th>Địa chỉ</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
<%--            for(Doi tuong : ten mang)--%>
    <c:forEach items="${a}" var="gv">
        <tr>
            <td>STT</td>
            <td>${gv.id}</td>
            <td>${gv.ma}</td>
            <td>${gv.ten}</td>
            <td>${gv.tuoi}</td>
            <td>${gv.gioiTinh}</td>
            <td>${gv.diaChi}</td>
            <td>
                <a href="/giang-vien/detail?id=${gv.id}"><button>Detail</button></a>
                <a href="/giang-vien/remove?abc=${gv.id}"><button>Remove</button></a>
                <a href="/giang-vien/view-update?id1=${gv.id}"><button>Update</button></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
