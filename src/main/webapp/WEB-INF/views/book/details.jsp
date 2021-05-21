<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book Details</title>
</head>
<body>
<table border="1">
    <thead>
    <th>Isbn</th>
    <th>Title</th>
    <th>Author</th>
    <th>Publisher</th>
    <th>Type</th>
    <th colspan="3">Action</th>
    </thead>
    <tbody>
        <tr>
            <td><c:out value="${book.isbn}"/></td>
            <td><c:out value="${book.title}"/></td>
            <td><c:out value="${book.author}"/></td>
            <td><c:out value="${book.publisher}"/></td>
            <td><c:out value="${book.type}"/></td>
            <td><button><a href="<c:url value="/admin/books/edit/${book.id}"/>">Edit</a></button></td>
            <td><button><a href="<c:url value="/admin/books/delete/${book.id}"/>">Remove</a></button></td>
            <td><button><a href="<c:url value="/admin/books/all"/>">Back</a></button></td>
        </tr>
    </tbody>
</table>
</body>
</html>