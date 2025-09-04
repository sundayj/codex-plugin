package com.codex.plugin.actions

import com.codex.plugin.CodexCLI
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class CodexReviewPRAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return
        val result = CodexCLI.run("review", "pr")
        Messages.showInfoMessage(project, result, "Codex PR Review")
    }
}
