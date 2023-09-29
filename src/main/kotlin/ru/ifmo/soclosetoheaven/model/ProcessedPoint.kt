package ru.ifmo.soclosetoheaven.model

import java.util.Date

class ProcessedPoint(
    point: Point,
    val hit: Boolean,
    val processingTime: Long,
    val creationDate: Date,
    val color: String
) : Point(point.x, point.y, point.r)