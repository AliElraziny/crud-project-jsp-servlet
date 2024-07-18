<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Product</title>
</head>
<body>
    <h1>Edit Product</h1>
    <form action="editProduct" method="post">
        <input type="hidden" name="id" value="${product.id}">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${product.name}"><br>
        <label for="price">Price:</label>
        <input type="text" id="price" name="price" value="${product.price}"><br>
        <input type="submit" value="Update">
    </form>
</body>
</html>