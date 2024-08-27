package com.tidbyt_cta_tracker.bff.plugins

import com.tidbyt_cta_tracker.bff.client.CTAClient
import com.tidbyt_cta_tracker.bff.config.HttpClient
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            CTAClient(HttpClient(baseUrl = "https://lapi.transitchicago.com")).getTrainArrivalPredictions()
        }
    }
}
