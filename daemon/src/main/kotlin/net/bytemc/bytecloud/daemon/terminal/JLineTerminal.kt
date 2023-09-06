package net.bytemc.bytecloud.daemon.terminal

import net.bytemc.bytecloud.daemon.logging.LogType
import net.bytemc.bytecloud.daemon.terminal.utils.Color
import org.fusesource.jansi.AnsiConsole
import org.jline.reader.LineReader
import org.jline.reader.LineReaderBuilder
import org.jline.terminal.TerminalBuilder
import org.jline.utils.InfoCmp

class JLineTerminal {

    private var terminal = TerminalBuilder.builder()
        .system(true)
        .streams(System.`in`, System.out)
        .encoding(Charsets.UTF_8)
        .dumb(true)
        .build()

    private var reader = LineReaderBuilder.builder()
        .terminal(this.terminal)
        .option(LineReader.Option.INSERT_TAB, false)
        .option(LineReader.Option.DISABLE_EVENT_EXPANSION, true)
        .option(LineReader.Option.AUTO_REMOVE_SLASH, false)
        .build()

    init {
        AnsiConsole.systemInstall()
        clear()

        JLineTerminalReader(this.reader).start()
    }

    fun print(msg: String, logType: LogType) {

        var coloredMessage = Color.translate(msg)

        if (logType != LogType.EMPTY) {
            coloredMessage = "[06.09 12:32:33] $coloredMessage";
        } else {
            this.write(msg)
            return
        }

        this.reader.terminal.puts(InfoCmp.Capability.carriage_return)
        this.reader.terminal.writer().println(coloredMessage)
        this.reader.terminal.flush()
        this.update()
    }

    fun write(msg: String) {
        this.reader.terminal.puts(InfoCmp.Capability.carriage_return)
        this.reader.terminal.writer().write(msg)
        this.reader.terminal.flush()
        this.update()
    }

    fun clear() {
        this.terminal.puts(InfoCmp.Capability.clear_screen)
        this.terminal.flush()
        this.update()
    }

    private fun update() {
        if (this.reader.isReading) {
            this.reader.callWidget(LineReader.REDRAW_LINE)
            this.reader.callWidget(LineReader.REDISPLAY)
        }
    }
}