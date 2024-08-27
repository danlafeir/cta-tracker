package com.tidbyt_cta_tracker.bff.config;

import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.coroutineScope

class HttpClient (
    engine: HttpClientEngine = OkHttp.create(),
    val baseUrl: String,
) {
    val httpClient = HttpClient(engine) {
        install(Logging)
        install(ContentNegotiation)
        install(DefaultRequest)
    }

    suspend fun get(
        path: String,
        requestHeaders: Headers,
        queryParams: Map<String, String> = mapOf(),
    ) = coroutineScope {
        val httpResponse = httpClient.get {
            url(baseUrl+path)
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
            queryParams.forEach { parameter(it.key,it.value) }
            parameter("key", System.getenv("CTA_API_KEY"))
            parameter("outputType", "JSON")
        }
        return@coroutineScope httpResponse
    }
}

