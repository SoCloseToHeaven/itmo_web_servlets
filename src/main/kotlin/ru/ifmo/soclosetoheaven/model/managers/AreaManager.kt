package ru.ifmo.soclosetoheaven.model.managers


import jakarta.enterprise.context.ApplicationScoped
import ru.ifmo.soclosetoheaven.areas.*
import ru.ifmo.soclosetoheaven.model.Point
import ru.ifmo.soclosetoheaven.util.Manager


@ApplicationScoped
class AreaManager : Manager<Point, Boolean> {

    private val areas: List<Area> = listOf(
        Circle(),
        Rectangle(),
        Triangle()
    )

    override fun manage(arg: Point) : Boolean {
        return areas.any {
            area: Area -> area.checkHit(arg)
        }
    }
}