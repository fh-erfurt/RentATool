<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>

<h1>Add Dummy to DB</h1>
<form action="addDummy">
    <input type="text" name="id"><br>
    <input type="text" name="name"><br>
    <input type="submit"><br>
</form>

<h1>Add Tool to DB</h1>
<form action="addTool">
    <input type="text" name="id"><br>
    <input type="text" name="name"><br>
    <input type="submit"><br>
</form>


<h1>Get Dummy from DB</h1>
<form action="getDummy">
    <input type="text" name="id"><br>
    <input type="submit"><br>
</form>
<h1>Get Tool from DB</h1>
<form action="getTool">
    <input type="text" name="id"><br>
    <input type="submit"><br>
</form>
</body>
</html>