package com.tidbyt_cta_tracker.bff.domain

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TrainArrivalPrediction(
    val line: Line,
    val predictedArrivalTimeInMinutes: Int,
    val destination: Destination
)

@Serializable
enum class Destination {
    @SerialName("Howard")
    HOAWRD,
    @SerialName("95th/Dan Ryan")
    NINETY_FIFTH_AND_DAN_RYAN,
    @SerialName("Loop")
    LOOP,
    @SerialName("Kimball")
    KIMBALL,
    @SerialName("Linden")
    LINDEN
}

@Serializable
enum class Line {
    BROWN,
    RED,
    PURPLE
}