package ru.ifmo.soclosetoheaven.middleware

import jakarta.servlet.FilterChain
import jakarta.servlet.annotation.WebFilter
import jakarta.servlet.http.HttpFilter
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse


@WebFilter(filterName = "PointFilter", servletNames = ["ControllerServlet"])
class PointFilter : HttpFilter() {

    companion object {
        const val X_REQ_PARAM = "x"
        const val Y_REQ_PARAM = "y"
        const val R_REQ_PARAM = "r"
        const val X_Y_BOUND = 8.0
        val R_VALUES = arrayOf(1.0, 2.0, 3.0, 4.0, 5.0)
    }


    override fun doFilter(req: HttpServletRequest, res: HttpServletResponse, chain: FilterChain) {
        val x = req.getParameter(X_REQ_PARAM)?.toDoubleOrNull()
        val y = req.getParameter(Y_REQ_PARAM)?.toDoubleOrNull()
        val r = req.getParameter(R_REQ_PARAM)?.toDoubleOrNull()

        if (x == null || y == null || r == null) {
            servletContext.getRequestDispatcher("/error").forward(req, res)
            return
        }

        if (x !in -X_Y_BOUND..X_Y_BOUND || y !in -X_Y_BOUND..X_Y_BOUND || r !in R_VALUES) {
            servletContext.getRequestDispatcher("/error").forward(req, res)
            return
        }
        chain.doFilter(req, res)


    }
}