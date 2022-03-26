# Gradle
Examples for `Gradle`

---

## What I've learned
### Initialize project
- Generate maven project by `maven archetype:genarate`
### groupId
- Set the groupId.
- It's rules `com.{title}.{sub-title}`. Write with small letter
### artifactId
- Set the project name
### properties
- It may set the properties for maven project
#### maven.compiler.source/target
- Set the compiler version
- Write `1.1`, `1.5`, `1.8` as you want, if you want to set higher than `10`, set `11`
### dependencies
- May set the library to use
- It's the one of powerful dependency libraries version controller
- If there is libraries for using, maven automatically call libaries to local repository (Default : `~/.m2/repository`)
### build
#### sourceDirectory
- Maven's default compile path is `${project.basedir}/src/java/com/src`
- This property is for setting compile path customly
#### pluginManagement
- Set the plugins what to use when `maven package`
- Default plugins exist. It may not defined if you want to depend on maven's default plugins
- This is for defining plugin settings. If you want to use when packaging, you have to set in `plugins`(See the `pom.xml`)
### Plugins for making `jar with dependency` or `uber jar` (Jar that assembled whole jars in dependency)
#### maven-dependency-plugin
- Call libraries to the project
#### maven-jar-plugin
- Make `jar` file. It may set the entry point of java source files
- Must use `maven-dependency-plugin` for dependency
#### maven-assembly-plugin
- Assemble all sources and libraries in own `jar` file
- It's not recommended. Most programs made by java is huge. It's good for light source files

#### maven-shade-plugin
- Assemble all sources and libraries in own `jar` file. Same as `maven-assembly-plugin`
- It's better than `maven-assembly-plugin`. It's recommended to use this rather than `maven-assembly-plugin`

