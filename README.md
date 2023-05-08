# Minecraft Mod new Biome
## QuickStart


## Logs
Download MDK from the URL
https://files.minecraftforge.net/net/minecraftforge/forge/index_1.18.2.html

Copy Directories to Work DIR

modify build.gradle file as follows for implement TerraBlender library
https://github.com/Glitchfiend/TerraBlender/wiki/Getting-started

gradle.properties
```shell
forge_version=40.2.0
minecraft_version=1.18.2
terrablender_version=1.1.0.99
```



re-setting up run configuration
```shell
 ./gradlew genIntellijRuns
```

modify config.toml to update some dependencies

modify build.gradle to replace mod name 


re-setting up run configuration
```shell
 ./gradlew genIntellijRuns
```

Error
以下 `property 'mixin.env.disableRefMap', 'false'` をbuild.gradleに加えるのが大事だった
```shell
    runs {
        client {
            workingDirectory project.file('run')

            property 'forge.logging.markers', 'REGISTRIES'
            property 'forge.logging.console.level', 'debug'
            property 'forge.enabledGameTestNamespaces', 'brokencity'
            property 'mixin.env.disableRefMap', 'false'
            mods {
                brokencity {
                    source sourceSets.main
                }
            }
        }

        server {
            workingDirectory project.file('run')

            property 'forge.logging.markers', 'REGISTRIES'
            property 'forge.logging.console.level', 'debug'
            property 'forge.enabledGameTestNamespaces', 'brokencity'
            property 'mixin.env.disableRefMap', 'false'
            mods {
                brokencity {
                    source sourceSets.main
                }
            }
        }
```

## Info
### Libraries



