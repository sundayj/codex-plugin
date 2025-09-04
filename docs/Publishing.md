# Publishing the Codex JetBrains Plugin

This guide outlines how to release the plugin to the JetBrains Marketplace.

## Prerequisites

- JetBrains Marketplace account with access to publish `com.codex.plugin`.
- Publish token stored in `ORG_GRADLE_PROJECT_intellijPublishToken` or `INTELLIJ_PUBLISH_TOKEN`.

## Steps

1. Update the version in `build.gradle.kts` and provide release notes in `src/main/resources/META-INF/plugin.xml`.
2. Build the plugin distribution:

   ```bash
   gradle buildPlugin
   ```

   The ZIP appears under `build/distributions/`.

3. Publish the plugin:

   ```bash
   gradle publishPlugin
   ```

   The Gradle IntelliJ Plugin reads the publish token from the environment.

4. Complete the remaining metadata (description, tags, icon) on the Marketplace website.

For more details, see the [Gradle IntelliJ Plugin documentation](https://plugins.jetbrains.com/docs/intellij/gradle-build-system.html#publishing-your-plugin).
