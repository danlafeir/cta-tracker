package com.tidbyt_cta_tracker.bff.plugins

import com.tidbyt_cta_tracker.bff.client.CTAClient
import com.tidbyt_cta_tracker.bff.config.HttpClient
import com.tidbyt_cta_tracker.bff.config.jsonSerializer
import com.tidbyt_cta_tracker.bff.domain.TrainArrivalPrediction
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.datetime.*
import kotlinx.serialization.builtins.ListSerializer

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respond(
                jsonSerializer.encodeToString(
                    ListSerializer(TrainArrivalPrediction.serializer()),
                    CTAClient(HttpClient(baseUrl = "https://lapi.transitchicago.com"))
                        .getTrainArrivalPredictions()
                        .filter { it.predictedArrivalTimeInMinutes > 7 })
            )
        }
    }
}
