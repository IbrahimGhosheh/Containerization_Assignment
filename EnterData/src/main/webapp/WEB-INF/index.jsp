<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login to enter your data</title>
</head>
<body>
<div align="center">
    <h1>Login to enter your data</h1>
    <form action="/login/now" method="get">
        <table style="with: 100%">
            <tr>
                <td>ID</td>
                <td><input type="number" name="ID" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="number" name="password" /></td>
            </tr>

        </table>
        <input type="submit" value="Submit" />
    </form>
</div>
</body>
</html>
