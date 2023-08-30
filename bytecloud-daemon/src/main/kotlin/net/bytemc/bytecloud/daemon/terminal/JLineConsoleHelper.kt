package net.bytemc.bytecloud.daemon.terminal

import net.bytemc.bytecloud.daemon.Daemon
import org.fusesource.jansi.Ansi

object JLineConsoleHelper {

    fun upLine(y: Int) {
        this.terminal(Ansi.ansi().reset().cursorUp(y).toString())
    }

    fun resetLine(y: Int) {
        this.terminal(Ansi.ansi().reset().cursorUp(y).eraseLine().toString())
    }

    fun updateLine(y: Int, input: String) {
        this.terminal(Ansi.ansi().reset().cursorUp(y).eraseLine().toString() + "\n");
        this.terminal(Ansi.ansi().reset().cursorUp(y).toString() + input)

        //reset current input
        this.terminal(Ansi.ansi().reset().cursorDown(y).toString())
    }

    private fun terminal(output: String) {
        Daemon.getInstance().console.write(output);
    }
}