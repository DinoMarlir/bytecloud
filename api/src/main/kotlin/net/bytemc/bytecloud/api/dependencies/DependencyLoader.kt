package net.bytemc.bytecloud.api.dependencies

interface DependencyLoader {

    // todo
    // fun load(dependency: Dependency)

    fun getDependencies(): List<Dependency>

}