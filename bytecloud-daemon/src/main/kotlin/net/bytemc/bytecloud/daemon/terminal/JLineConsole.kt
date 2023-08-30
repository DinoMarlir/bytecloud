package net.bytemc.bytecloud.daemon.terminal

import net.bytemc.bytecloud.daemon.terminal.process.JLineReadingProcess
import net.bytemc.bytecloud.daemon.terminal.utils.Color
import org.fusesource.jansi.AnsiConsole
import org.jline.reader.LineReader
import org.jline.reader.LineReaderBuilder
import org.jline.reader.impl.LineReaderImpl
import org.jline.terminal.Terminal
import org.jline.terminal.TerminalBuilder
import org.jline.utils.InfoCmp

class JLineConsole : Console {

    private var terminal: Terminal = TerminalBuilder.builder()
        .system(true)
        .dumb(true)
        .streams(System.`in`, System.out)
        .encoding(Charsets.UTF_8)
        .build()

    private var reader: LineReaderImpl = LineReaderBuilder.builder()
        .terminal(this.terminal)
        .option(LineReader.Option.DISABLE_EVENT_EXPANSION, true)
        .option(LineReader.Option.AUTO_REMOVE_SLASH, false)
        .build() as LineReaderImpl

    private var process = JLineReadingProcess(this, this.reader)
    private var prompt = Color.translate("&2cloud&3 » &1")

    init {
        AnsiConsole.systemInstall()

        this.clear()
        this.process.start()
    }

    override fun write(message: String) {
        this.terminal.puts(InfoCmp.Capability.carriage_return)
        this.terminal.writer().write(Color.translate(message))
        this.terminal.writer().flush()
        this.update()
    }

    override fun prompt(): String {
        return this.prompt
    }

    fun updatePrompt(prompt: String) {
        this.prompt = prompt
        this.reader.setPrompt(Color.translate(prompt))
    }

    override fun clear() {
        this.terminal.puts(InfoCmp.Capability.clear_screen)
        this.terminal.writer().flush()
    }

    private fun update() {
        if (this.reader.isReading) {
            this.reader.callWidget(LineReader.REDRAW_LINE)
            this.reader.callWidget(LineReader.REDISPLAY)
        }
    }
}