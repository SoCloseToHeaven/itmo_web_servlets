package ru.ifmo.soclosetoheaven.areas

import ru.ifmo.soclosetoheaven.model.Point

interface Area {
    fun checkHit(point: Point) : Boolean
}