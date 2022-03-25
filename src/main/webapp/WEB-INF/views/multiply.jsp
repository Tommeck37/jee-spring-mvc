<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Multiply</title>
</head>
<body>
<title>Multiply</title>
<style>
    table {
        border-collapse: collapse;
    }

    table, th, td {
        border: 1px solid grey;
    }

    th, td {
        text-align: center;
        padding: 6px;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
</style>

<table>
    <tr>
        <th>x</th>
        <c:forEach varStatus="loop" begin="1" end="${looper}">
            <th>${loop.index}</th>
        </c:forEach>
    </tr>
    <c:forEach varStatus="loop1" begin="1" end="${looper}">
        <tr>
            <th>${loop1.index}</th>

            <c:forEach varStatus="loop2" begin="1" end="${looper}">

                <td>${loop1.count * loop2.count}</td>

            </c:forEach>
        </tr>
    </c:forEach>
</table>
</body>
</html>