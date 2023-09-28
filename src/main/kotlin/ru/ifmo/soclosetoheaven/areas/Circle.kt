package ru.ifmo.soclosetoheaven.areas

import ru.ifmo.soclosetoheaven.model.Point

class Circle : Area {

    override fun checkHit(point: Point): Boolean {
        val inThirdQuarter = (point.x <= 0 && point.y <= 0)
        val inCircle = (point.x * point.x + point.y * point.y) <= point.r * point.r
        return inThirdQuarter && inCircle
    }
}