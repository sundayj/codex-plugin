package com.codex.plugin

import com.intellij.openapi.options.Configurable
import javax.swing.JComponent
import javax.swing.JPanel
import javax.swing.JTextField
import javax.swing.BoxLayout
import javax.swing.JLabel

class CodexSettingsConfigurable : Configurable {
    private val cliPathField = JTextField()
    private val panel = JPanel()

    init {
        panel.layout = BoxLayout(panel, BoxLayout.Y_AXIS)
        panel.add(JLabel("Codex CLI path:"))
        panel.add(cliPathField)
    }

    override fun createComponent(): JComponent = panel

    override fun isModified(): Boolean =
        cliPathField.text != CodexSettingsState.instance().cliPath

    override fun apply() {
        CodexSettingsState.instance().cliPath = cliPathField.text
    }

    override fun reset() {
        cliPathField.text = CodexSettingsState.instance().cliPath
    }

    override fun getDisplayName(): String = "Codex"
}
