<%@ page import="ru.ifmo.soclosetoheaven.AreaCheckServlet" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String jsonData = (String) application.getAttribute(AreaCheckServlet.CONTEXT_ATTRIBUTE);
    if (jsonData == null)
        jsonData = "[]";
%>
<!DOCTYPE html>
<html>
<head>
    <title>ITMO WEB #2 - JSP</title>
    <script defer>
        const POINTS = <%= jsonData %>;
        const ROUNDING_ACCURACY = 5;
    </script>
    <script defer src="./js/drawGraph.js"></script>
    <script defer src="./js/form.js"></script>
    <script>
        async function sendForm(event) {
            await formSubmit(event);
            fillGraph();
        }
    </script>
</head>
<body>
    <div>
        <div id="graph">
            <canvas
                    id="graph-canvas"
                    width="300"
                    height="300"
                    onmousemove="drawPointer(event)"
                    onmouseleave="fillGraph()"
                    onmousedown="sendPointOnClick(event)"
            >
            </canvas>
        </div>
        <form
                method="post"
                action="./check-hit-controller"
                onsubmit="sendForm(event)"
        >
            <div>
              <label for="x">Select X value</label>
              <select name="x" id="x">
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
            <div>
                <label for="y">Type Y value</label>
                <input
                        type="text"
                        id="y"
                        name="y"
                        placeholder="Type Y value"
                        oninput="validateY()"
                />
                <label for="y" id="y-warning-label"></label>
            </div>
            <div>
                <label for="r1">1</label>
                <input type="radio" id="r1" name="r" value="1" checked onchange="fillGraph()">
                <label for="r2">2</label>
                <input type="radio" id="r2" name="r" value="2" onchange="fillGraph()">
                <label for="r3">3</label>
                <input type="radio" id="r3" name="r" value="3" onchange="fillGraph()">
                <label for="r4">4</label>
                <input type="radio" id="r4" name="r" value="4" onchange="fillGraph()">
                <label for="r5">5</label>
                <input type="radio" id="r5" name="r" value="5" onchange="fillGraph()">
            </div>
            <div>
                <input type="submit" value="Send" id="send-form" />
            </div>
        </form>
    </div>
</body>
</html>