package ru.ifmo.soclosetoheaven.areas

import ru.ifmo.soclosetoheaven.model.Point

class Triangle : Area {



    override fun checkHit(point: Point): Boolean {
        val inSecondQuarter = point.x <= 0 && point.y >= 0
        val inTriangle = point.y <= point.x + point.r
        return inSecondQuarter && inTriangle
    }
}