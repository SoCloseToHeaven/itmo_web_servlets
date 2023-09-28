package ru.ifmo.soclosetoheaven.areas

import ru.ifmo.soclosetoheaven.models.Point

class JointArea(
    vararg areas: Area
) : Area {

    private val areas: Array<Area> = arrayOf(*areas)

    override fun checkHit(point: Point): Boolean {
        return areas.any {
            area: Area -> area.checkHit(point)
        }
    }
}