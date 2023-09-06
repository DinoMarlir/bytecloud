package net.bytemc.bytecloud.daemon.terminal

import org.fusesource.jansi.AnsiConsole
import org.jline.reader.LineReader
import org.jline.reader.LineReaderBuilder
import org.jline.terminal.TerminalBuilder

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

        JLineTerminalReader(this.reader).start()
    }

    fun print() {

    }

}