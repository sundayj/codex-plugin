package com.codex.plugin

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage

@State(name = "CodexSettings", storages = [Storage("codex.xml")])
class CodexSettingsState : PersistentStateComponent<CodexSettingsState> {
    var cliPath: String = "codex"

    override fun getState(): CodexSettingsState = this

    override fun loadState(state: CodexSettingsState) {
        this.cliPath = state.cliPath
    }

    companion object {
        fun instance(): CodexSettingsState = com.intellij.openapi.components.service()
    }
}
