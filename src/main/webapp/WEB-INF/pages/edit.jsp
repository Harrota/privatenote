<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <c:if test="${empty note.title}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty note.title}">
        <title>Edit</title>
    </c:if>
</head>
<body>
<c:if test="${empty note.title}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty note.title}">
    <c:url value="/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty note.title}">
        <input type="hidden" name="id" value="${note.id}">
    </c:if>
    <label for="title">Title</label>
    <input type="text" name="title" id="title">
    <label for="text">Text</label>
    <input type="text" name="text" id="text">

    <c:if test="${empty note.title}">
        <input type="submit" value="Add new note">
    </c:if>
    <c:if test="${!empty note.title}">
        <input type="submit" value="Edit note">
    </c:if>
</form>

</body>
</html>
