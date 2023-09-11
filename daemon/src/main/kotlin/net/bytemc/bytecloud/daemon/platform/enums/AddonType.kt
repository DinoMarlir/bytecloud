package net.bytemc.bytecloud.daemon.platform.enums

enum class AddonType(val addonFolder: String) {
    PAPER_PLUGIN("plugins"),
    MINESTOM_EXTENSION("extensions"),
    FABRIC_MOD("mods"),
    FORGE_MOD("mods"),
    SPONGE_MOD("mods"),
    VELOCITY_PLUGIN("plugins"),
    BUNGEECORD_PLUGIN("plugins")
}