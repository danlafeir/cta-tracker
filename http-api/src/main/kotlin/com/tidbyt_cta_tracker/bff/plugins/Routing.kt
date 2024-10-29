package com.tidbyt_cta_tracker.bff.plugins

import com.tidbyt_cta_tracker.bff.client.CTAClient
import com.tidbyt_cta_tracker.bff.config.HttpClient
import com.tidbyt_cta_tracker.bff.config.jsonSerializer
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.encodeToString

fun Application.configureRouting() {
    routing {
        get("/") {
            val response = CTAClient(HttpClient(baseUrl = "https://lapi.transitchicago.com"))
                .getTrainArrivalPredictions()
                .filter { it.predictedArrivalTimeInMinutes > 7 }
                .groupBy { it.line }

            call.respond(jsonSerializer.encodeToString(response))
        }
    }
}
