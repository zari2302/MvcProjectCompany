
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1px;color : red">
    <thead>
    <tr>
        <th>id</th>
        <th>courseName</th>
        <th>duration</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${course.id}</td>
        <td>${course.courName}</td>
        <td>${course.duration}</td>
    </tr>
    </tbody>
</table>
<div style="margin: auto">
    <button><a href="/course/findCourse/${courseId}">back</a></button>
    <button><a href="/">main</a></button>
</div>
</body>
</html>
