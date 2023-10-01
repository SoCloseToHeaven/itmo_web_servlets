package ru.ifmo.soclosetoheaven.areas

import ru.ifmo.soclosetoheaven.model.Point

class Rectangle : Area {

    companion object {
        private const val X_DIVISION = 2
    }

    override fun checkHit(point: Point): Boolean {
        val inFourthQuarter = point.x >= 0 && point.y <= 0
        val inRectangle = (point.x <= (point.r / X_DIVISION)) && (point.y >= -point.r)
        return inFourthQuarter && inRectangle
    }
}