package ru.ifmo.soclosetoheaven

import jakarta.inject.Inject
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import ru.ifmo.soclosetoheaven.middleware.PointFilter
import ru.ifmo.soclosetoheaven.model.Point
import ru.ifmo.soclosetoheaven.model.json.JsonParserBean
import ru.ifmo.soclosetoheaven.model.managers.PointManager


@WebServlet(name = "AreaCheckServlet", urlPatterns = ["/check-hit"])
class AreaCheckServlet : HttpServlet() {

    companion object {
        const val CONTEXT_ATTRIBUTE = "point-data"
        const val CONTEXT_ATTRIBUTE_LIST = "point-data-list"
        const val JSON_CONTENT_TYPE = "application/json"
    }

    @Inject
    lateinit var pointManager: PointManager

    @Inject
    lateinit var jsonParser: JsonParserBean
    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {
        val processedPoint = pointManager.manage(
            Point(
                req.getParameter(PointFilter.X_REQ_PARAM).toDouble(),
                req.getParameter(PointFilter.Y_REQ_PARAM).toDouble(),
                req.getParameter(PointFilter.R_REQ_PARAM).toDouble()
            )
        )
        servletContext.setAttribute(CONTEXT_ATTRIBUTE, jsonParser.stringify(pointManager.data))
        servletContext.setAttribute(CONTEXT_ATTRIBUTE_LIST, pointManager.data)

        resp.contentType = JSON_CONTENT_TYPE

        val writer = resp.writer
        writer.println(jsonParser.stringify(processedPoint))
        writer.close()
    }
}