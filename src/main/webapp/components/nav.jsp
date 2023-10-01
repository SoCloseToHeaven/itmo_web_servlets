<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="nav nav-pills justify-content-center bg-black p-3 mb-3">
    <img class="d-inline-block m-2" src="<%=request.getContextPath()%>/resources/img/itmo-cs-logo.png" alt="itmo-cs-logo"/>
    <div class="nav-item d-inline-block m-2 w-10 h-75" data-bs-toggle="pill" role="presentation">
        <a class="nav-link active" data-toggle="pill" href="<%=request.getContextPath()%>/index.jsp">Form</a>
    </div>
    <div class="nav-item d-inline-block m-2 w-10 h-75" role="presentation">
        <a class="nav-link active" data-toggle="pill" href="<%=request.getContextPath()%>/table.jsp">Results</a>
    </div>
</nav>
