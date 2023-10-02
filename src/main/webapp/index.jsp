<%@ page import="ru.ifmo.soclosetoheaven.model.managers.PointManager" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String jsonData = (String) application.getAttribute(PointManager.CONTEXT_ATTRIBUTE);
    if (jsonData == null)
        jsonData = "[]";
%>
<!DOCTYPE html>
<html>
<head>
    <title>ITMO WEB #2 - JSP</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="icon" href="<%=request.getContextPath()%>/resources/img/favicon.ico">
    <script defer>
        const POINTS = <%= jsonData %>;
        const ROUNDING_ACCURACY = 5;
    </script>
    <script type="module" defer src="./js/drawGraph.js"></script>
    <script type="module" defer src="./js/form.js"></script>
</head>
<body>
        <jsp:include page="./components/nav.jsp" />
        <jsp:include page="./components/header.jsp" />
        <div class="container border border-primary rounded text-center shadow-lg ">
            <canvas
                    id="graph-canvas"
                    width="600"
                    height="600"
                    class="border border-secondary shadow-lg  rounded mt-5 mb-5"
            >
            </canvas>
        </div>
        <form

                method="post"
                action="./check-hit-controller"
                id="point-form"
                class="d-grid gap-3 container border border-secondary rounded text-center w-50 p-3 mt-5"
        >
            <h3 class="text-center mb-4">Enter point data</h3>
            <div class="input-group">
              <label for="x" class="input-group-text">Select X value</label>
              <select
                      name="x"
                      id="x"
                      class="form-control w-50 p-3">
                  <option value="-2">-2</option>
                  <option value="-1.5">-1.5</option>
                  <option value="-1">-1</option>
                  <option value="-0.5">-0.5</option>
                  <option value="0" selected>0</option>
                  <option value="0.5">0.5</option>
                  <option value="1">1</option>
                  <option value="1.5">1.5</option>
                  <option value="2">2</option>
              </select>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <label for="y" class="input-group-text">Type Y value</label>
                    <input
                            type="text"
                            id="y"
                            name="y"
                            placeholder="Type Y value"
                            class="form-control w-50 p-3"
                    />
                </div>
                <div class="mt-3">
                    <label for="y" id="y-warning-label"></label>
                </div>
            </div>
            <div class="form-group">
                <label class="alert alert-primary" role="alert" for="r-group">Choose R value</label>
                <div id="r-group">
                    <div class="d-inline-block">
                        <label for="r1" class="d-block">1</label>
                        <input type="radio" class="form-check-input" id="r1" name="r" value="1" checked >
                    </div>
                    <div class="d-inline-block">
                        <label for="r2" class="d-block">2</label>
                        <input type="radio" class="form-check-input" id="r2" name="r" value="2">
                    </div>
                    <div class="d-inline-block">
                        <label for="r3" class="d-block">3</label>
                        <input type="radio" class="form-check-input" id="r3" name="r" value="3">
                    </div>
                    <div class="d-inline-block">
                        <label for="r4" class="d-block">4</label>
                        <input type="radio" class="form-check-input" id="r4" name="r" value="4">
                    </div>
                    <div class="d-inline-block">
                        <label for="r5" class="d-block">5</label>
                        <input type="radio" class="form-check-input" id="r5" name="r" value="5">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <input
                        type="submit"
                        class="btn btn-lg btn-primary"
                        value="Send"
                        id="send-form"
                />
                <input
                        type="button"
                        class="btn btn-lg btn-primary"
                        value="Clear"
                        id="clear"
                />
            </div>
        </form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>