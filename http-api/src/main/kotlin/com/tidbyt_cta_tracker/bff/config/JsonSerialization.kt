package com.tidbyt_cta_tracker.bff.config

import kotlinx.serialization.json.Json

val jsonSerializer = Json {
    encodeDefaults = true
    isLenient = true
    ignoreUnknownKeys = true
    coerceInputValues = true
}