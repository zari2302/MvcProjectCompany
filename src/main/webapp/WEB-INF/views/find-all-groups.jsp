
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="course" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Title</title>
</head>
<body>
<table border="2px">
    <th>id</th>
    <th>group name</th>
    <th>group data start</th>
    <th>group data finish</th>
    <th>update</th>
    <th>delete</th>
    <th>teacher</th>
    <th>student</th>
    <c:forEach items="${allgroups}" var="groups">
        <tr>
            <td>${groups.id}</td>
            <td>${groups.groupName}</td>
            <td>${groups.dateStart}</td>
            <td>${groups.dateFinish}</td>
            <td>
                <button>
                    <a href="/groups/update/groups/${groups.id}">
                        update
                    </a>
                </button>
            </td>
            <td>
                <button>
                    <a href="/groups/deleteGroups/${groups.id}">
                        delete
                    </a>
                </button>
            </td><td>
                <button>
                    <a href="/teacher/findTeacher/${groups.id}">
                        teacher
                    </a>
                </button>
            </td>
            <td>
                <button>
                    <a href="/student/findStudent/${groups.id}">
                        student
                    </a>
                </button>
            </td>
        </tr>
    </c:forEach>
</table>
<button><a href="/groups/groups-save/${groupId}">save group</a></button>
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

    button:hover, a:hover {
        background-color: seagreen;
    }
</style>
</body>
</html>