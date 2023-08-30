package net.bytemc.bytecloud.daemon.terminal.utils

import org.fusesource.jansi.Ansi

enum class Color(red: Int, green: Int, blue: Int) {

    DEFAULT(181, 181, 181),
    HIGHLIGHTER(66, 204, 235),
    DARK(59, 59, 59),
    SECOND_HIGHLIGHTER(255, 188, 66);

    val ansi: String = Ansi.ansi().a(Ansi.Attribute.RESET).fgRgb(red, green, blue).toString()

    companion object {

        private val COLOR_CODES = values()

        fun translate(input: String): String {
            var output = input
            for (code in COLOR_CODES) {
                output = output.replace("&" + (code.ordinal + 1), code.ansi)
            }
            return output
        }
    }

}