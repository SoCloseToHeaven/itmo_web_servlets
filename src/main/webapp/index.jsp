<%@ page import="ru.ifmo.soclosetoheaven.AreaCheckServlet" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>ITMO WEB #2 - JSP</title>
    <script defer>
        const POINTS = <%= (String) application.getAttribute(AreaCheckServlet.CONTEXT_ATTRIBUTE) %>;
    </script>
    <script defer src="./js/drawGraph.js"></script>
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
            >
            </canvas>
        </div>
        <form method="post" action="./check-hit-controller">
            <div>
              <select name="x">
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
                <input type="text" name="y" placeholder="Type Y value" />
            </div>
            <div>
                <input type="radio" name="r" value="1" checked onchange="fillGraph()">
                <input type="radio" name="r" value="2" onchange="fillGraph()">
                <input type="radio" name="r" value="3" onchange="fillGraph()">
                <input type="radio" name="r" value="4" onchange="fillGraph()">
                <input type="radio" name="r" value="5" onchange="fillGraph()">
            </div>
            <div>
                <input type="button" placeholder="Send"/>
            </div>
        </form>
    </div>
</body>
</html>