## NexLimbo

This is a lightweight Minecraft limbo server, written in Java with Netty.
The main goal of this project is maximum simplicity with a minimum number of sent and processed packets.
The limbo is empty; there is no ability to set a schematic building since this is not necessary.
You can send useful information via chat or boss bar.

The server is fully clear. It is only able to keep a lot of players while the main server is down.

General features:
* High performance. The server doesn't save or cache any useless (for limbo) data.
* Doesn't spawn threads per player. Use a fixed thread pool.
* Support for **BungeeCord** and **Velocity** info forwarding (compatible with all versions).
* Support for [BungeeGuard](https://www.spigotmc.org/resources/79601/) handshake format.
* Multiple versions support (1.8.X-1.21.X).
* Fully configurable.
* Lightweight. App size around **3MB**.

![](https://i.imgur.com/sT8p1Gz.png)

### Versions support

Symbol `X` means all minor versions.

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

The server **doesn't** support snapshots.

### Commands

* `help` - Show help message
* `conn` - Display number of connections
* `mem` - Display memory usage stats
* `stop` - Stop the server

Note that the server also will be closed correctly if you just press `Ctrl+C`.

### Installation

Required software: JRE 11+

The installation process is simple.

1. Download the latest version of the program.
2. Put the jar file in the folder you want.
3. Create a start script as you did for Bukkit or BungeeCord, with a command like this:
   `java -jar NexLimbo-<version>.jar`
4. The server will create `settings.yml` file, which is the server configuration. 
5. Configure it as you want and restart the server.

### Player info forwarding

The server supports player info forwarding from the proxy. There are several types of info forwarding:

* `LEGACY` - The **BungeeCord** IP forwarding.
* `MODERN` - **Velocity** native info forwarding type.
* `BUNGEE_GUARD` - **BungeeGuard** forwarding type.

If you use BungeeCord, or Velocity with `LEGACY` forwarding, just set this type in the config.  
If you use Velocity with `MODERN` info forwarding, set this type and paste the secret key from
Velocity config into `secret` field.
If you installed BungeeGuard on your proxy, then use `BUNGEE_GUARD` forwarding type.
Then add your tokens to `tokens` list.

### Contributing

Feel free to create a pull request if you find some bug or optimization opportunity, or if you want
to add some functionality that is suitable for a limbo server and won't significantly load the server.

### Building

Required software:

* JDK 11+
* Gradle 7+ (optional)

To build a minimized jar, go to the project root directory and run in the terminal:

```
./gradlew shadowJar
```

### Contacts

If you have any questions or suggestions, join our [Discord server](https://discord.gg/yAgRafG6JD)!
