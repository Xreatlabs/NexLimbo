# NexLimbo

A lightweight Minecraft limbo server built on top of [NanoLimbo](https://github.com/Nan1t/NanoLimbo) by Nan1t, extended with plugin support for BungeeCord and Velocity proxies.

## Credits

This project is based on **NanoLimbo** by [Nan1t](https://github.com/Nan1t):
- Original project: https://github.com/Nan1t/NanoLimbo
- Original author: Nan1t
- License: GNU General Public License v3.0

**NexLimbo Contributors:**
- [bivashy](https://github.com/bivashy) - BungeeCord and Velocity plugin implementations
- Plugin architecture and multi-platform support

## Features

NexLimbo extends the original NanoLimbo with:

### General Features (from NanoLimbo):
* **High performance** - Doesn't save or cache any useless data
* **Efficient threading** - Uses a fixed thread pool instead of spawning threads per player
* **Multiple versions support** - 1.7.X through 1.21.X (all minor versions)
* **Fully configurable** - Customize server behavior through settings
* **Lightweight** - Application size around 3MB
* **Modern protocol support** - Built with Netty for reliable connections

### Extended Features (NexLimbo additions):
* **BungeeCord plugin** - Run limbo servers directly from BungeeCord
* **Velocity plugin** - Native Velocity proxy support with modern API (3.4.0-SNAPSHOT)
* **Multiple limbo servers** - Configure and run multiple limbo instances
* **Command framework** - Enhanced command system using [Lamp](https://github.com/Revxrsal/Lamp)
* **Info forwarding support**:
  - LEGACY (BungeeCord IP forwarding)
  - MODERN (Velocity native forwarding)
  - BUNGEE_GUARD (BungeeGuard integration)

### Supported Features:
* Boss bar information display
* Chat messages
* Multiple Minecraft protocol versions
* Dimension customization
* Brand name configuration (F3 menu)

## System Requirements

* **Java**: 17 or higher
* **Platform**: Standalone, BungeeCord, or Velocity

## Versions Support

Symbol `X` means all minor versions.

- [x] 1.7.X
- [x] 1.8.X
- [x] 1.9.X
- [x] 1.10.X
- [x] 1.11.X
- [x] 1.12.X
- [x] 1.13.X
- [x] 1.14.X
- [x] 1.15.X
- [x] 1.16.X
- [x] 1.17.X
- [x] 1.18.X
- [x] 1.19.X
- [x] 1.20.X
- [x] 1.21.X

**Note:** Snapshot versions are not supported.

## Installation

### Standalone Server

1. Download the latest API jar from releases
2. Run: `java -jar NexLimbo-api-<version>.jar`
3. Configure `settings.yml`
4. Restart the server

### BungeeCord Plugin

1. Download the BungeeCord jar from releases
2. Place in your BungeeCord `plugins` folder
3. Restart BungeeCord
4. Configure in `plugins/NexLimboBungee/config.yml`

### Velocity Plugin

1. Download the Velocity jar from releases
2. Place in your Velocity `plugins` folder
3. Restart Velocity
4. Configure in `plugins/nexlimbovelocity/config.yml`

## Configuration

### Player Info Forwarding

Configure in `settings.yml`:

**BungeeCord (LEGACY forwarding):**
```yaml
infoForwarding:
  type: LEGACY
```

**Velocity (MODERN forwarding):**
```yaml
infoForwarding:
  type: MODERN
  secret: "your-secret-key-from-velocity-config"
```

**BungeeGuard:**
```yaml
infoForwarding:
  type: BUNGEE_GUARD
  tokens:
    - "your-token-1"
    - "your-token-2"
```

## Commands

* `help` - Show help message
* `conn` - Display number of connections
* `mem` - Display memory usage statistics
* `start` - Start a limbo server (proxy plugins)
* `stop` - Stop a limbo server or shutdown

**Note:** Server closes correctly with `Ctrl+C`.

## API Usage

### Maven
```xml
<repositories>
   <repository>
      <id>jitpack.io</id>
      <url>https://jitpack.io</url>
   </repository>
</repositories>

<dependencies>
    <dependency>
       <groupId>com.github.bivashy.NanoLimboPlugin</groupId>
       <artifactId>api</artifactId>
       <version>1.0.0</version>
    </dependency>
</dependencies>
```

### Gradle
```gradle
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.bivashy.NanoLimboPlugin:api:1.0.0'
}
```

### Basic Example
```java
// Load configuration
LimboConfig config = new YamlLimboConfig(Paths.get("./"), classLoader).load();

// Create command handler
CommandHandler<Command> commandHandler = new ConsoleCommandHandler();

// Create and start server
LimboServer server = new LimboServer(config, commandHandler, getClass().getClassLoader());
server.start();

// Stop when done
server.stop();
```

### Custom Configuration
```java
public class CustomLimboConfig implements LimboConfig {
    @Override
    public int getDebugLevel() {
        return -1; // Disable debug
    }

    @Override
    public String getBrandName() {
        return "My Custom Brand";
    }

    @Override
    public SocketAddress getAddress() {
        return new InetSocketAddress("localhost", 25555);
    }
    
    // Implement remaining methods...
}
```

### Custom Command Handler (No Commands)
```java
public class CustomCommandHandler implements CommandHandler<Command> {
    @Override
    public Collection<Command> getCommands() {
        return Collections.emptyList();
    }

    @Override
    public void register(Command command) {
        // No-op
    }

    @Override
    public boolean executeCommand(String input) {
        return false;
    }
}
```

## Building from Source

### Requirements
* JDK 17+
* Gradle 7+ (or use included wrapper)

### Build Commands
```bash
# Build all modules
./gradlew shadowJar

# Build specific module
./gradlew api:shadowJar
./gradlew bungee:shadowJar
./gradlew velocity:shadowJar

# Run tests
./gradlew test

# Clean build
./gradlew clean build
```

Built jars will be in `{module}/build/libs/` directories.

## Contributing

Contributions are welcome! Please:

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request

Keep contributions focused on:
- Bug fixes
- Performance optimizations
- Features suitable for a limbo server
- Code that doesn't significantly increase resource usage

## License

This project is licensed under the **GNU General Public License v3.0** - see the [LICENSE](LICENSE) file for details.

Based on [NanoLimbo](https://github.com/Nan1t/NanoLimbo) by Nan1t, also licensed under GPL-3.0.

## Support

For issues and questions:
- Open an issue on GitHub
- Check existing issues for solutions
- Review the original [NanoLimbo documentation](https://github.com/Nan1t/NanoLimbo)

## Acknowledgments

- **Nan1t** - Original NanoLimbo creator and maintainer
- **bivashy** - Plugin architecture and multi-platform support
- **Revxrsal** - [Lamp command framework](https://github.com/Revxrsal/Lamp)
- **PaperMC** - Velocity API
- **SpigotMC** - BungeeCord API
- All contributors to the NanoLimbo and NexLimbo projects

---

**Note:** This is an extended version of NanoLimbo. For the original standalone server, visit https://github.com/Nan1t/NanoLimbo
