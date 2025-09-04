# Codex JetBrains Plugin

Integrates the open-source Codex CLI into JetBrains IDEs such as IntelliJ IDEA and PyCharm.

## Features

- Generate commit descriptions from staged changes
- Review pull requests on popular Git hosts
- Interactive code generation with a pause button to refine prompts
- Configurable Codex CLI path under *Settings/Preferences > Tools > Codex*

## Requirements

- Java 17 or later
- Codex CLI installed and available on your system `PATH`
- JetBrains IDE 2023.3 or newer with the Git plugin enabled

## Building

```bash
# Download dependencies and build the plugin
gradle build

# Run the plugin inside a sandboxed IDE
gradle runIde

# Produce a distributable ZIP in build/distributions
gradle buildPlugin
```

The repository includes Gradle wrapper scripts; you may substitute `./gradlew` for `gradle` if the wrapper JAR is present locally.

## Installation

1. Build the plugin using `gradle buildPlugin`.
2. In the IDE, open **Settings/Preferences > Plugins**, click the gear icon, and choose **Install Plugin from Disk**.
3. Select the generated ZIP from `build/distributions`.
4. Configure the Codex CLI path via **Settings/Preferences > Tools > Codex**.

## Publishing

See [docs/Publishing.md](docs/Publishing.md) for steps to publish the plugin to the JetBrains Marketplace.

## Contributing

Pull requests and issue reports are welcome!
