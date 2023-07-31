<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="box">
    <h1>Save teacher</h1>
    <form action="/teacher/saveTeacher/${teacherId}" method="post">
        <div class="input-box">
            <input type="text" name="firstName" placeholder="firstName:">
            <i></i>
        </div>
        <div class="input-box">
            <input type="text" name="lastName" placeholder="lastName:">
            <i></i>
        </div>
        <div class="input-box">
            <input type="text" name="email" placeholder="email:">
            <i></i>
        </div>
        <c:forEach items="${groupsId}" var="groups">
        </c:forEach>
        <input type="submit" value="save">
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
</div>
</body>
</html>
