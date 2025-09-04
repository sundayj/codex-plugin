package com.codex.plugin

import java.io.BufferedReader

object CodexCLI {
    fun run(vararg args: String): String {
        val cmd = listOf(CodexSettingsState.instance().cliPath) + args
        val process = ProcessBuilder(cmd).redirectErrorStream(true).start()
        process.waitFor()
        return process.inputStream.bufferedReader().use(BufferedReader::readText)
    }
}
