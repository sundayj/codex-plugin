package com.codex.plugin.actions

import com.codex.plugin.CodexCLI
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class CodexGenerateCommitDescriptionAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return
        val result = CodexCLI.run("commit", "describe")
        Messages.showInfoMessage(project, result, "Codex Commit Description")
    }
}
