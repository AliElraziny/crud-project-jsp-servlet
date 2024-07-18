<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>
</head>
<body>
    <h1>Add Product</h1>
    <form action="addProduct" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name"><br>
        <label for="price">Price:</label>
        <input type="text" id="price" name="price"><br>
        <input type="submit" value="Add">
    </form>
</body>
</html>