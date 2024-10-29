package com.tidbyt_cta_tracker.bff.client.dtos

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
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
    val rt: Line,
    val arrT: LocalDateTime,
    val destNm: Destination
)

@Serializable
enum class Line {
    @SerialName("Brn")
    BROWN {
        override fun toDomainValue() = com.tidbyt_cta_tracker.bff.domain.Line.BROWN
    },
    @SerialName("Red")
    RED {
        override fun toDomainValue() = com.tidbyt_cta_tracker.bff.domain.Line.RED
    },
    @SerialName("P")
    PURPLE {
        override fun toDomainValue() = com.tidbyt_cta_tracker.bff.domain.Line.PURPLE
    };

    abstract fun toDomainValue(): com.tidbyt_cta_tracker.bff.domain.Line
}

@Serializable
enum class Destination {
    @SerialName("Howard")
    HOAWRD {
        override fun toDomainValue() = com.tidbyt_cta_tracker.bff.domain.Destination.HOAWRD
    },
    @SerialName("95th/Dan Ryan")
    NINETY_FIFTH_AND_DAN_RYAN {
        override fun toDomainValue() = com.tidbyt_cta_tracker.bff.domain.Destination.NINETY_FIFTH_AND_DAN_RYAN
    },
    @SerialName("Loop")
    LOOP {
        override fun toDomainValue() = com.tidbyt_cta_tracker.bff.domain.Destination.LOOP
    },
    @SerialName("Kimball")
    KIMBALL {
        override fun toDomainValue() = com.tidbyt_cta_tracker.bff.domain.Destination.KIMBALL
    },
    @SerialName("Linden")
    LINDEN {
        override fun toDomainValue() = com.tidbyt_cta_tracker.bff.domain.Destination.LINDEN
    };

    abstract fun toDomainValue(): com.tidbyt_cta_tracker.bff.domain.Destination
}