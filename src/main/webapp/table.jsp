<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.ifmo.soclosetoheaven.model.ProcessedPoint" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.ifmo.soclosetoheaven.model.managers.PointManager" %><%--
  Created by IntelliJ IDEA.
  User: Дмитрий
  Date: 01.10.2023
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<ProcessedPoint> data;
    if (application.getAttribute(PointManager.CONTEXT_ATTRIBUTE_LIST) != null)
        data = (ArrayList<ProcessedPoint>) application.getAttribute(PointManager.CONTEXT_ATTRIBUTE_LIST);
    else
        data = null;
%>
<html>
<head>
    <title>ITMO WEB #2 - JSP</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="icon" href="<%=request.getContextPath()%>/resources/img/favicon.ico">
</head>
<body>
    <jsp:include page="./components/nav.jsp" />
    <div
            id="results-table"
            class="w-80"
    >
        <table class="table">
            <thead class="table-dark">
                <tr>
                    <th>X</th>
                    <th>Y</th>
                    <th>R</th>
                    <th>Hit?</th>
                    <th>Processing time(ns)</th>
                    <th>Creation date</th>
                    <th>Color</th>
                </tr>
            </thead>
            <tbody>
                <%
                    if (data != null) {
                        for (ProcessedPoint point : data) { %>
                            <tr>
                                <td><%= point.getX()%></td>
                                <td><%= point.getY()%></td>
                                <td><%= point.getR()%></td>
                                <td><%= point.getHit()%></td>
                                <td><%= point.getProcessingTime()%></td>
                                <td><%= point.getCreationDate()%></td>
                                <td><%= point.getColor()%></td>
                            </tr>
                    <%
                        }
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
