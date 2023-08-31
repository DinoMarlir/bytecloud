package net.bytemc.bytecloud.daemon.commands

interface Command {

    fun execute(args: Array<String>)

    fun info(): Info {
        return this::class.java.getAnnotation(Info::class.java)
    }

    @Target(AnnotationTarget.CLASS)
    @Retention(AnnotationRetention.RUNTIME)
    annotation class Info(
        val name: String,
        val aliases: Array<String> = [],
    )

}