package net.bytemc.bytecloud.api.misc

import net.bytemc.bytecloud.api.CloudAPI
import net.bytemc.bytecloud.api.dependencies.Dependency

object ConfigurationHelper {

    init {
        // add required dependencies
        Dependency("com.google.code.gson", "gson", "2.10.1").download(CloudAPI.getInstance().getDependencyLoader())
    }
}