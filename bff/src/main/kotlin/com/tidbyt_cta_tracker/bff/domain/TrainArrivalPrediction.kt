package com.tidbyt_cta_tracker.bff.domain

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class TrainArrivalPrediction(
    val line: Line,
    val prediction: LocalDateTime
)

@Serializable
enum class Line {
    BROWN,
    RED,
    PURPLE
}