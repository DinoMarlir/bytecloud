package net.bytemc.bytecloud.daemon.logging

enum class LogType(var id: Char) {

    INFO('f'), WARN('e'), ERROR('c'), EMPTY('7');

    override fun toString(): String {
        return "&$id" + this.name
    }
}