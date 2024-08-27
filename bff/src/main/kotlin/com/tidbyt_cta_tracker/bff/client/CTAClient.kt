package com.tidbyt_cta_tracker.bff.client

import com.tidbyt_cta_tracker.bff.client.dtos.ArrivalsResponse
import com.tidbyt_cta_tracker.bff.config.HttpClient
import com.tidbyt_cta_tracker.bff.config.jsonSerializer
import io.ktor.client.statement.*
import io.ktor.http.*

class CTAClient(
    val httpClient: HttpClient
){
    val ARRIVAL_PATH = "/api/1.0/ttarrivals.aspx"
    val FULLERTON = "41220"

    suspend fun getTrainArrivalPredictions(): ArrivalsResponse {
        val response = httpClient.get(ARRIVAL_PATH, Headers.Empty, mapOf(Pair("mapid", FULLERTON)))
        println(response.bodyAsText())
        val arrivalsResponse = jsonSerializer.decodeFromString<ArrivalsResponse>(response.bodyAsText())
        println(arrivalsResponse.toString())
        return arrivalsResponse
    }
}