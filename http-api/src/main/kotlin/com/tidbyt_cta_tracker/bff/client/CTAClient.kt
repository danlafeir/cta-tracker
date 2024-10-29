package com.tidbyt_cta_tracker.bff.client

import com.tidbyt_cta_tracker.bff.client.dtos.ArrivalsResponse
import com.tidbyt_cta_tracker.bff.config.HttpClient
import com.tidbyt_cta_tracker.bff.config.jsonSerializer
import com.tidbyt_cta_tracker.bff.domain.TrainArrivalPrediction
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlin.time.DurationUnit

class CTAClient(
    val httpClient: HttpClient
){
    val ARRIVAL_PATH = "/api/1.0/ttarrivals.aspx"
    val FULLERTON = "41220"

    suspend fun getTrainArrivalPredictions(): List<TrainArrivalPrediction> {
        val response = httpClient.get(ARRIVAL_PATH, Headers.Empty, mapOf(Pair("mapid", FULLERTON)))
        val arrivalsResponse = jsonSerializer.decodeFromString<ArrivalsResponse>(response.bodyAsText())
        return arrivalsResponse.ctatt.eta
            .map {
                TrainArrivalPrediction(
                    it.rt.toDomainValue(),
                    it.arrT.toInstant(timeZone = TimeZone.of("UTC-05")).minus(Clock.System.now()).toInt(DurationUnit.MINUTES),
                    it.destNm.toDomainValue())
            }
    }
}