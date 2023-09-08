package net.bytemc.bytecloud.api.config

import com.google.gson.GsonBuilder

object ConfigurationLayout {

    // only for packet information or clean context
    val DEFAULT_SCHEMA = GsonBuilder()
        .serializeNulls()
        .disableHtmlEscaping()
        .create()

    // for configuration files or user outputs
    val CONFIGURATION_SCHEMA = DEFAULT_SCHEMA
        .newBuilder()
        .setPrettyPrinting()
        .create()

}