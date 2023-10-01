package ru.ifmo.soclosetoheaven

import jakarta.inject.Inject
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import ru.ifmo.soclosetoheaven.model.json.JsonParserBean
import ru.ifmo.soclosetoheaven.model.managers.PointManager

@WebServlet(name = "ClearServlet", urlPatterns = ["/clear"])
class ClearServlet : HttpServlet() {

    @Inject
    lateinit var pointManager: PointManager

    @Inject
    lateinit var jsonParser: JsonParserBean

    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {
        pointManager.data.clear()
        servletContext.setAttribute(AreaCheckServlet.CONTEXT_ATTRIBUTE, jsonParser.stringify(pointManager.data))
        servletContext.setAttribute(AreaCheckServlet.CONTEXT_ATTRIBUTE_LIST, pointManager.data)
    }
}