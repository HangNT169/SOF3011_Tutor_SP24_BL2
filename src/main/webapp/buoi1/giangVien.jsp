<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách giảng viên</title>
</head>
<body>
<div>
    <Span>Tên:</Span>
    <input type="text">
    <br>
    <button>Search</button>
</div>
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
                <a href="/giang-vien/detail"><button>Detail</button></a>
                <a href="/giang-vien/remove?abc=${gv.id}"><button>Remove</button></a>
                <a href="/giang-vien/view-update"><button>Update</button></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
