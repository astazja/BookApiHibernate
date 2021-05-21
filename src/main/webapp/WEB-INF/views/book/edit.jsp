<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Book add</title>
</head>
<body>

<form:form action="/admin/books/update" method="post" modelAttribute="book">
    <form:hidden path="id"/>
    <label>ISBN:</label>
    <form:input path="isbn"/>
    <form:errors path="isbn"/>
    <br>
    <label>Title:</label>
    <form:input path="title"/>
    <form:errors path="title"/>
    <br>
    <label>Author:</label>
    <form:input path="author"/>
    <form:errors path="author"/>
    <br>
    <label>Publisher:</label>
    <form:input path="publisher"/>
    <form:errors path="publisher"/>
    <br>
    <label>Type:</label>
    <form:input path="type"/>
    <form:errors path="type"/>
    <br>
    <input type="submit" value="Update">
</form:form>

</body>
</html>
