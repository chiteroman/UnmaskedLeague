package unmaskedLeague

import com.github.pgreze.process.Redirect
import com.github.pgreze.process.process

suspend fun isRiotClientRunning(): Boolean {
    val proc = process(
        "ps", "-A",
        stdout = Redirect.CAPTURE
    )
    return proc.output.any { it.contains("RiotClientServic", ignoreCase = true) }
}

suspend fun killRiotClient() {
    process("killall", "-9", "RiotClientServic")
}
