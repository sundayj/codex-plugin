package com.codex.plugin.actions

import com.codex.plugin.CodexSettingsState
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogWrapper
import javax.swing.*

class CodexCodeGenerationAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return
        CodexGenerationDialog(project).show()
    }
}

private class CodexGenerationDialog(project: Project) : DialogWrapper(project) {
    private val input = JTextArea(5, 40)
    private val generate = JButton("Generate")
    private val pause = JButton("Pause")
    private var process: Process? = null
    private var paused = false

    init {
        init()
        title = "Codex Code Generation"
        generate.addActionListener {
            process = ProcessBuilder(CodexSettingsState.instance().cliPath, "code", input.text).start()
        }
        pause.addActionListener {
            if (paused) {
                process?.outputStream?.write(("\n" + input.text).toByteArray())
                process?.outputStream?.flush()
                paused = false
            } else {
                process?.outputStream?.write(3)
                process?.outputStream?.flush()
                paused = true
            }
        }
    }

    override fun createCenterPanel(): JComponent {
        val panel = JPanel()
        panel.layout = BoxLayout(panel, BoxLayout.Y_AXIS)
        panel.add(input)
        panel.add(generate)
        panel.add(pause)
        return panel
    }
}
