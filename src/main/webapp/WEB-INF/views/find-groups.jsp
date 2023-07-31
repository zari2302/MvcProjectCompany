
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1px" style="margin: auto">
    <thead>
    <tr>
        <th>id</th>
        <th>group name</th>
        <th>date of start</th>
        <th>date of finish</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${groups.id}</td>
        <td>${groups.groupName}</td>
        <td>${groups.dateStart}</td>
        <td>${groups.dateFinish}</td>
    </tr>
    </tbody>
</table>
<button><a href="/groups/findGroup${groupsId}">back</a></button>
<button><a href="/">main</a></button>
</body>
</html>
