package net.bytemc.bytecloud.daemon.platform

import net.bytemc.bytecloud.daemon.platform.enums.AddonType
import net.bytemc.bytecloud.daemon.platform.enums.PlatformType

class Platform(
    val name: String,
    val type: PlatformType,
    val addonType: AddonType,
    val addonFolder: String = addonType.addonFolder,

    val getMcVersions: () ->  List<String>,
    val getBuilds: () ->  List<String>,
    val downloadJarFile: () ->  List<String>
)
