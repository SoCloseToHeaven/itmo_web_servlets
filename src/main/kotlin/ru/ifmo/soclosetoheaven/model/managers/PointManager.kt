package ru.ifmo.soclosetoheaven.model.managers


import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.inject.Named
import jakarta.servlet.ServletContext
import ru.ifmo.soclosetoheaven.AreaCheckServlet

import ru.ifmo.soclosetoheaven.model.Point
import ru.ifmo.soclosetoheaven.model.ProcessedPoint
import ru.ifmo.soclosetoheaven.model.json.JsonParserBean
import ru.ifmo.soclosetoheaven.util.Manager
import ru.ifmo.soclosetoheaven.util.Savable
import java.time.Instant
import java.util.*
import kotlin.collections.ArrayList


@ApplicationScoped
@Named(value = "pointManager")
class PointManager : Manager<Point, ProcessedPoint>, Savable<ServletContext> {


    companion object {
        const val CONTEXT_ATTRIBUTE = "point-data"
        const val CONTEXT_ATTRIBUTE_LIST = "point-data-list"
    }

    private val RGB_LOWER_BOUND = 0
    private val RGB_UPPER_BOUND = 255

    private val random = Random()

    @Inject
    private lateinit var areaManager: AreaManager

    @Inject
    private lateinit var jsonParser: JsonParserBean

    val data = ArrayList<ProcessedPoint>()

    override fun manage(arg: Point) : ProcessedPoint {
        val startTime = System.nanoTime();


        val processedPoint = ProcessedPoint(
            arg,
            areaManager.manage(arg),
            System.nanoTime() - startTime,
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

    override fun save(arg: ServletContext) {
        arg.setAttribute(CONTEXT_ATTRIBUTE, jsonParser.stringify(data))
        arg.setAttribute(CONTEXT_ATTRIBUTE_LIST, data)
    }

    override fun clear(arg: ServletContext) {
        data.clear()
        arg.setAttribute(CONTEXT_ATTRIBUTE, jsonParser.stringify(data))
        arg.setAttribute(CONTEXT_ATTRIBUTE_LIST, data)
    }
}