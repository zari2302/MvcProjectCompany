
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="2px">
        <th>id</th>
        <th>first name</th>
        <th>last name</th>
        <th>email</th>
        <th>format</th>
        <th>delete</th>
        <th>update</th>
    <t:forEach items="${allstudent}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>
                <a href="/get/by/student/${student.id}">${student.firstName}</a>
            </td>
            <td>${student.lastName}</td>
            <td>${student.email}</td>
            <td>${student.studentFormat}</td>
            <td>
                <form action="/student/deleteStudent/${student.id}" method="get">
                    <button type="submit">DELETE</button>
                </form>
            </td>
            <td>
                <form action="/student/update/student/${student.id}">
                    <button type="submit">UPDATE</button>
                </form>
            </td>
        </tr>
    </t:forEach>
</table>
<button><a href="/student/student-save/${studentId}">save student</a></button>
<button><a href="/groups/findGroup/${studentId}">main</a></button>
<style>
    table {
        border-collapse: collapse;
        width: 100%;
        max-width: 600px;
        margin: 0 auto;
        background-color: cornsilk;
        font-family: Arial, sans-serif;
    }

    th, td {
        padding: 4px;
        text-align: left;
        border: 1px solid cornsilk;
    }

    th {
        background-color: seagreen;
        color: cornsilk;
    }

    tr:nth-child(even) {
        background-color: cornsilk;
    }

    tr:hover {
        background-color: cornsilk;
    }

    button, a {
        display: block;
        margin: 0 auto;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        font-size: 16px;
        font-weight: bold;
        color: cornsilk;
        background-color: seagreen;
        cursor: pointer;
    }

    button:hover, a:hover {
        background-color: seagreen;
    }

</style>
</body>
</html>