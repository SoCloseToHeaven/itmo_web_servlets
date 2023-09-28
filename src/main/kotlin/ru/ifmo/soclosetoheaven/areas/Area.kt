package ru.ifmo.soclosetoheaven.areas

import ru.ifmo.soclosetoheaven.models.Point

interface Area {
    fun checkHit(point: Point) : Boolean
}