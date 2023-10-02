package ru.ifmo.soclosetoheaven.middleware

import jakarta.servlet.FilterChain
import jakarta.servlet.annotation.WebFilter
import jakarta.servlet.http.HttpFilter
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse


@WebFilter(filterName = "AreaCheckFilter", servletNames = ["AreaCheckServlet"])
class AreaCheckFilter : HttpFilter() {

    companion object {
        const val ALLOWED_URL_PATTERN = "/check-hit-controller"
        const val ERROR_CODE = 403
    }

    override fun doFilter(req: HttpServletRequest, res: HttpServletResponse, chain: FilterChain) {
        if (!req.servletPath.equals(ALLOWED_URL_PATTERN)) {
            res.sendError(ERROR_CODE)
            return
        }

        chain.doFilter(req, res)
    }
}