<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<h2>Notes</h2>
    <table>
        <tr>
            <th>id</th>
            <th>title</th>
            <th>text</th>
        </tr>

    <c:forEach var="note" items="${notesList}">
        <tr>
            <td>${note.id}</td>
            <td>${note.title}</td>
            <td>${note.text}</td>
            <td>
                <a href="/edit/${note.id}">Edit</a>
                <a href="/delete/${note.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </table>
<h2>Add</h2>
<c:url value="/add" var="add"/>
<a href="${add}">Add new note</a>
</body>
</html>
