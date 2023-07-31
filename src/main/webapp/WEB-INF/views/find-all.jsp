
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1px">
    <thead>
    <tr>
        <th>id</th>
        <th>company name</th>
        <th>locatedCountry</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${all}" var="company">
        <tr>
            <td>${company.id}</td>
            <td>
                <a href="/get/by/${company.id}">${company.companyName}</a>
            </td>
            <td>${company.locatedCountry}</td>
            <td>
                <button type="submit"><a href="/course/findCourse/${company.id}">course</a></button>
            </td>
            <td>
                <button type="submit"><a href="/groups/findGroup/${company.id}">groups</a></button>
            </td>
            <td>
                <form action="/deleteCompany/${company.id}" method="get">
                    <button type="submit">DELETE</button>
                </form>
            </td>
            <td>
                <form action="/updateCompany/${company.id}" method="get">
                    <button type="submit">UPDATE</button>
                </form>
            </td>
            <td>
                <form action="/findAll/${company.id}" method="get">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="button">
    <button><a href="/companyForm" class="company">create new company</a></button>
    <br>
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
</div>
</body>
</html>
