# ChMotd
Simple and useful MOTD plugin for Minecraft in less than 50 lines

### Commands
`/motd` - reloads the plugin; shows plugin info if player doesn't have enought permissions

### Permissions
`motd.reload` - makes that `/motd` command reloads the plugin

### Config
#### Default Config
```yaml
maxPlayers: 13
motds:
  - "&aChMotd is a very good plugin!"
```
Plugin picks random motd from config.
