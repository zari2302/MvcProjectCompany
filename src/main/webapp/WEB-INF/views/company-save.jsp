
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<div class="box">
    <form action="/saveCompany" method="post">
        <div class="input-box">
            <input type="text" name="name" placeholder="CompanyName:">
            <i></i>
        </div>
        <div class="input-box">
            <input type="text" name="locatedCountry" id="locatedCountry" placeholder="Country:"
                   required="required">
            <i></i>
        </div>
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
        h1{
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
