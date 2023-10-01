<%--
  Created by IntelliJ IDEA.
  User: Дмитрий
  Date: 01.10.2023
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ITMO WEB #2 - JSP</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="icon" href="<%=request.getContextPath()%>/resources/img/favicon.ico">
</head>
<body>
    <jsp:include page="./components/nav.jsp" />
    <div id="results-table">
        <table>
            <thead>
                <th></th>
            </thead>

        </table>
    </div>
</body>
</html>
