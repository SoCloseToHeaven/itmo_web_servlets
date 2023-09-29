package ru.ifmo.soclosetoheaven

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "DataErrorPageServlet", urlPatterns = ["/error"])
class DataErrorPageServlet : HttpServlet() {

    companion object {
        const val INVALID_DATA_HTTP_CODE = 450
        const val ERROR_CODE_MESSAGE = "Invalid data!"
    }

    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
        resp.sendError(INVALID_DATA_HTTP_CODE, ERROR_CODE_MESSAGE)
    }
}