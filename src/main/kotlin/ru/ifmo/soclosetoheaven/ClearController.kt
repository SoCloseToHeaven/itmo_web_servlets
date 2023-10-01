package ru.ifmo.soclosetoheaven

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "ClearController", urlPatterns = ["/clear-controller"])
class ClearController : HttpServlet() {

    companion object {
        const val METHOD_POST = "POST";
    }

    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
        if (req.method != METHOD_POST) {
            servletContext.getRequestDispatcher("/error").forward(req, resp)
            return;
        }
        doPost(req, resp)
    }

    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {
        servletContext.getRequestDispatcher("/clear").forward(req, resp)
    }
}