package com.tidbyt_cta_tracker.bff.client.dtos

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class ArrivalsResponse(
    val ctatt: Arrivals
)

@Serializable
data class Arrivals(
    val eta: List<Arrival>
)

@Serializable
data class Arrival(
    val rt: String,
    val arrT: LocalDateTime
)

@Serializable
enum class Line(line: String) {
    BROWN("Brn"),
    RED("Red"),
    PURPLE("P")
}
