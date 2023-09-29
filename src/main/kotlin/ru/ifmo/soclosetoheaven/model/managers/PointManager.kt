package ru.ifmo.soclosetoheaven.model.managers


import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject

import ru.ifmo.soclosetoheaven.model.Point
import ru.ifmo.soclosetoheaven.model.ProcessedPoint
import ru.ifmo.soclosetoheaven.util.Manager
import java.util.*
import kotlin.collections.ArrayList


@ApplicationScoped
class PointManager : Manager<Point, ProcessedPoint> {


    private val RGB_LOWER_BOUND = 0
    private val RGB_UPPER_BOUND = 255

    private val random = Random()

    @Inject
    private lateinit var areaManager: AreaManager

    val data = ArrayList<ProcessedPoint>()

    override fun manage(arg: Point) : ProcessedPoint {
        val startTime = System.currentTimeMillis()


        val processedPoint = ProcessedPoint(
            arg,
            areaManager.manage(arg),
            System.currentTimeMillis() - startTime,
            Date(),
            randomRgb()
        )
        data.add(processedPoint)
        return processedPoint
    }

    private fun randomRgb() : String {
        val red = random.nextInt(RGB_LOWER_BOUND, RGB_UPPER_BOUND)
        val green = random.nextInt(RGB_LOWER_BOUND, RGB_UPPER_BOUND)
        val blue = random.nextInt(RGB_LOWER_BOUND, RGB_UPPER_BOUND)
        return "rgb($red, $green, $blue)"
    }
}