<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Courses</title>
</head>
<body>
<h2>Courses List</h2>
<a href="addCourse.jsp">Add New Course</a>
<h3>All Courses</h3>
<table border="1">
    <thead>
    <tr>
        <th>Course Name</th>
        <th>Price per Month</th>
        <th>Payment Method</th>
        <th>Company</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="course" items="${courses}">
        <tr>
            <td>${course.name}</td>
            <td>${course.pricePerMonth}</td>
            <td>${course.paymentMethod}</td>
            <td>${course.company.name}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h3>Company Price Calculation</h3>
<form action="calculatePrice" method="post">
    <label for="companyId">Select Company:</label>
    <select name="companyId" id="companyId">
        <c:forEach var="company" items="${companies}">
            <option value="${company.id}">${company.name}</option>
        </c:forEach>
    </select>
    <button type="submit">Calculate Total Price</button>
</form>

<c:if test="${not empty totalPrice}">
    <h3>Total Price for Company: ${totalPrice}</h3>
</c:if>

<h3>Find Cheapest Course</h3>
<form action="findCheapestCourse" method="post">
    <button type="submit">Find Cheapest Course</button>
</form>

<c:if test="${not empty cheapestCourse}">
    <h3>Cheapest Course: ${cheapestCourse.name}</h3>
    <p>Price: ${cheapestCourse.pricePerMonth}</p>
</c:if>
</body>
</html>
