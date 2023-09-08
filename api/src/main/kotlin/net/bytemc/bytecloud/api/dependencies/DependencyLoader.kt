package net.bytemc.bytecloud.api.dependencies

import java.nio.file.Path

interface DependencyLoader {

    fun load(dependency: Dependency)

    fun getDependencies(): List<Dependency>

    fun addToClassPath(path: Path)

}