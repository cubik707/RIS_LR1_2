<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Course</title>
</head>
<body>
<h2>Add New Course</h2>
<form action="addCourse" method="post">
    <label for="courseName">Course Name:</label>
    <input type="text" name="courseName" id="courseName" required/><br/>

    <label for="pricePerMonth">Price per Month:</label>
    <input type="number" name="pricePerMonth" id="pricePerMonth" required/><br/>

    <label for="paymentMethod">Payment Method:</label>
    <select name="paymentMethod" id="paymentMethod">
        <option value="CREDIT_CARD">Credit Card</option>
        <option value="PAYPAL">PayPal</option>
        <option value="BANK_TRANSFER">Bank Transfer</option>
    </select><br/>

    <label for="companyName">Company Name:</label>
    <input type="text" name="companyName" id="companyName" required/><br/>

    <c:if test="${not empty errorMessage}">
        <p style="color: red; font-weight: bold;">${errorMessage}</p>
    </c:if>

    <button type="submit">Add Course</button>
</form>
</body>
</html>
