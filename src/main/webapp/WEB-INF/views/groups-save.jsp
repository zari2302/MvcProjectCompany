<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/groups/saveGroups/${groupId}" method="post">
    <h1>group name</h1>
    <input type="text" name="groupName">
    <h1>data start</h1>
    <input type="date" name="dateStart">
    <h1>data finish</h1>
    <input type="date" name="dateFinish">
    <br>
    <c:forEach items="${company}" var="company">
        <input type="checkbox" id="${company.id}" name="id" value="${company.id}">
        <label for="${company.id}">${company.companyName}</label>
    </c:forEach>
    <c:forEach items="${courses}" var="courseId">
        <input type="checkbox" id="${courseId.id}" name="courseId" value="${courseId.id}">
        <label for="${courseId.id}">${courseId.courseName}</label><br>
    </c:forEach>
    <input type="submit" value="save group">
</form>
<style>
    form {
        background-color: cornsilk;
        border: 1px solid cornsilk;
        padding: 10px;
        width: 50%; /* ширина формы */
        margin: 0 auto; /* автоматически центрирует форму */
        text-align: center; /* выравнивание содержимого по центру */
    }

    h1 {
        margin: auto 0;
    }

    label {;
        padding: 5px;
        border: 1px solid cornsilk;
        border-radius: 4px;
        text-align: left; /* выравнивание полей ввода по левому краю */

        display: block;
        font-weight: bold;
        color: seagreen;
        margin-bottom: 5px;
    }

    input[type="text"],
    input[type="email"],
    input[type="password"] {
        padding: 5px;
        border: 1px solid cornsilk;
        border-radius: 4px;
        text-align: left; /* выравнивание полей ввода по левому краю */
        margin-bottom: 10px; /* отступ между полями ввода */
    }

    input[type="submit"] {
        background-color: seagreen;
        color: cornsilk;
        padding: 5px 10px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: seagreen;
    }
</style>
</body>
</html>
