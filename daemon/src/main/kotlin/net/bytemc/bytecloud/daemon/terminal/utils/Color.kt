package net.bytemc.bytecloud.daemon.terminal.utils

import org.fusesource.jansi.Ansi

enum class Color(var id: Char, red: Int, green: Int, blue: Int) {

    WHITE('f',255, 255, 255);

    val ansi: String = Ansi.ansi().a(Ansi.Attribute.RESET).fgRgb(red, green, blue).toString()

    companion object {

        private val COLOR_CODES = values()

        fun translate(input: String): String {
            var output = input
            for (code in COLOR_CODES) {
                output = output.replace("&" + code.id, code.ansi)
            }
            return output
        }
    }

}