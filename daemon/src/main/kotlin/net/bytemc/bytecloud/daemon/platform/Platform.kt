package net.bytemc.bytecloud.daemon.platform

import net.bytemc.bytecloud.daemon.platform.enums.AddonType
import net.bytemc.bytecloud.daemon.platform.enums.PlatformType
import java.io.File

class Platform(
    val name: String,
    val type: PlatformType,
    val addonType: AddonType,
    val addonFolder: String = addonType.addonFolder,

    val jarNamePattern: String? = null,
    val getMcVersions: () -> List<String>,
    val getBuilds: () -> List<String>,
    val getJarFile: () -> File
)
