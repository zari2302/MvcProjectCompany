
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="course" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="2px">
    <th>id</th>
    <th>course name</th>
    <th>course duration</th>
    <th>delete</th>
    <th>update</th>
    <c:forEach items="${allcourse}" var="course">
        <tr>
            <td>${course.id}</td>
            <td>${course.courseName}</td>
            <td>${course.duration}</td>
                <td>
                        <form action="/course/deleteCourse/${course.id}" method="get">
                            <button type="submit">delete</button>
                        </form>
                    </td>
            <td>
                <form action="/course/update/course/${course.id}" method="get">
                    <button type="submit">update</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<button><a href="/course/course-save/${courseId}">save course</a></button>
<button><a href="/">main</a></button>
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
</style>
</body>
</html>