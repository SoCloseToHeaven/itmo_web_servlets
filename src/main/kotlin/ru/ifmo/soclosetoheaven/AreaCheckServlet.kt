package ru.ifmo.soclosetoheaven

import jakarta.inject.Inject
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import ru.ifmo.soclosetoheaven.model.managers.PointManager


@WebServlet(name = "AreaCheckServlet")
class AreaCheckServlet : HttpServlet() {

    companion object {
        private const val CONTEXT_ATTRIBUTE = "point-data"
    }

    @Inject
    lateinit var pointManager: PointManager
    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {
        TODO("DO-POST")
    }
}