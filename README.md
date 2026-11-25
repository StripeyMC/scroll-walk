Copyright (c) 2026 Stripey

Scroll Walk

Unofficial Fabric port of **Scroll Walk** to Minecraft 26.3.

**Scroll Walk was created by [Naw7k](https://github.com/Naw7k).** All credit for the idea and the original code goes to the original author. This port only updates the mod to work on Minecraft 26.3 with Fabric.

- Original mod: https://modrinth.com/mod/scroll-walk
- Original source code: https://github.com/Naw7k/Scroll-Walk

If the original author would like anything here changed or removed, please open an issue and it will be taken care of right away.

What the mod does

Hold **Alt** (or Control or Shift, in the settings) and scroll your mouse wheel to change your walking speed. It also has an optional speedometer and settings for speed limits, scroll step, and acceleration.

Changes in this port compared to the original 1.2:

- Sprinting uses your normal speed, and your scroll-wheel speed returns when you stop sprinting
- Taking damage cancels the slow walking and restores normal speed
- A **Modifier Key** setting (Alt, Control, or Shift), so it can avoid clashing with other mods

Requirements

- Minecraft 26.3 with Fabric Loader
- Java 25
- Fabric API, Cloth Config, Mod Menu

This version is client-side only. Install it on the player's side, not on a server.

Building

1. Install Java 25.
2. Open a terminal inside this folder.
3. Run `gradlew build` (Windows) or `./gradlew build` (Mac or Linux).
4. The mod is in the `build/libs` folder.

Notes:

- The first build downloads Minecraft and takes several minutes.
- `gradlew runClient` starts a test copy of the game.

## License

MIT, the same as the original. See [LICENSE](LICENSE): the copyright notice for the original author must stay with every copy of this code.
