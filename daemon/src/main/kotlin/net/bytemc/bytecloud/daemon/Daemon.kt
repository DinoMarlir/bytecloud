package net.bytemc.bytecloud.daemon

import net.bytemc.bytecloud.api.CloudAPI
import net.bytemc.bytecloud.api.dependencies.DependencyLoader
import net.bytemc.bytecloud.daemon.dependencies.DependencyLoaderImpl

class Daemon : CloudAPI() {

    private var dependencyLoader = DependencyLoaderImpl()

    override fun getDependencyLoader(): DependencyLoader {
        return dependencyLoader
    }
}