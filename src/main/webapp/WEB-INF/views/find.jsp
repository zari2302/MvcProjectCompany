
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1px">
    <thead>
    <tr>
        <th>id</th>
        <th>companyName</th>
        <th>locatedCountry</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${company.id}</td>
        <td>${company.companyName}</td>
        <td>${company.locatedCountry}</td>
    </tr>
    </tbody>
</table>
<a href="/">main</a>
<style>{
        text-align: center;
    }
    h1 {
        display: inline-block; /* элементы в виде блоков */
        color: seagreen;
        background-color: transparent; /* прозрачный фон */
        border: 2px solid seagreen;
        border-radius: 4px; /* скругленные углы */
        padding: 10px; /* внутренний отступ */
        text-decoration: none; /* отключение подчеркивания для ссылок */
        font-size: 24px; /* размер шрифта */
        margin: 10px; /* внешний отступ */
    }

    button:hover,
    a:hover,
    h1:hover {
        background-color: seagreen;
        color: cornsilk;
    }

    button:focus,
    a:focus,
    h1:focus {
        outline: none; /* убираем обводку при фокусе */
    }
</style>
</body>
</html>
