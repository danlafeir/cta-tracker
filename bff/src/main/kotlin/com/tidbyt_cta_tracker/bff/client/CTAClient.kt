package com.tidbyt_cta_tracker.bff.client

import com.tidbyt_cta_tracker.bff.config.HttpClient
import io.ktor.http.*

class CTAClient(
    val httpClient: HttpClient
){
    val ARRIVAL_PATH = "/api/1.0/ttarrivals.aspx"
    val FULLERTON = "41220"

    suspend fun getTrainArrivalPredictions() {
        httpClient.get(ARRIVAL_PATH, Headers.Empty, mapOf(Pair("mapid", FULLERTON)))
    }
}