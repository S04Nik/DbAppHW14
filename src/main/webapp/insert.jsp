<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>
<body>
<form action="/home" method="post">
    <label>NAME:
        <input type="text" name="name" id="nameId">
    </label>
    <br>
    <label>MANUFACTURE:
        <input type="text" name="manufacture" id="manufactureId">
    </label>
    <br>
    <label>V:
        <input type="text" name="V" id="VId">
    </label>
    <br>
    <label>YEAR:
        <input type="text" name="year" id="yearId">
    </label>
    <br>
    <label>COLOR:
        <input type="text" name="color" id="colorId">
    </label>
    <br>
    <label>
        СЕДАН
        <input type="radio" name="type" value="Sedan">
    </label>
    <label>
        ХЕТЧБЕК
        <input type="radio" name="type" value="HatchBak">
    </label>
    <label>
        УНИВЕРСАЛ
        <input type="radio" name="type" value="Universal">
    </label>
<br>
    <input type="submit" name="1" value="Insert">
</form>
</body>
</html>