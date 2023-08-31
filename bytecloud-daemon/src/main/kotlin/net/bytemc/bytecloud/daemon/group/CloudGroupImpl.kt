package net.bytemc.bytecloud.daemon.group

import net.bytemc.bytecloud.api.groups.CloudGroup

class CloudGroupImpl(private var name: String) : CloudGroup {

    override fun getName(): String {
        return name
    }
}