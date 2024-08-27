package com.tidbyt_cta_tracker.bff.client.dtos

import java.time.LocalDateTime

data class ArrivalsResponse(
    val ctatt: Arrivals
)

data class Arrivals(
    val eta: List<Arrival>
)

data class Arrival(
    val rt: Line,
    val arrT: LocalDateTime
)

enum class Line(line: String) {
    BROWN("Brn"),
    RED("Red"),
    PURPLE("P")
}
