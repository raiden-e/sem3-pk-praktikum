# PK-Praktikum

> Semester 3 Programmierkurs Praktikum

## Authors

- Herny Küfner
- Raiden Erdmann

## JAVA Setup

> VSCode is difficult to set up, especially when trying to include libraries

Download [JDK 15.0.1](https://download.oracle.com/otn/java/jdk/15.0.1%2B9/51f4f36ad4ef43e39d0dfdbaf6549e32/jdk-15.0.1_windows-x64_bin.exe)

Install [VS Code][1] and [Java Extension Pack][2]

[1]: https://code.visualstudio.com/Download
[2]: https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack

Set `JAVA_HOME` envoirentment variable:

```ps
setx -m JAVA_HOME "D:\java\bin" # Where D:\java... is the path to *your* java
```

Sometimes you need to `Add folder to Java Source Path`, by right-clicking inside to root folder in VSCode

Uninstall Maven and Java projectmgr extension

clean workspace

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

# Adding external classes

To add external classes such as `xmpcore.jar` or `metadata-extractor-2.16.0.jar`, you have to copy the `.jar` files into `lib` and create `.classpath` manually:

```xml
<!-- .classpath -->
<?xml version="1.0" encoding="UTF-8"?>
<classpath>
    <classpathentry kind="src" path="src"/>
    <classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER">
        <attributes>
            <attribute name="module" value="true"/>
        </attributes>
    </classpathentry>
    <classpathentry kind="lib" path="lib/metadata-extractor-2.16.0.jar">
        <attributes>
            <attribute name="module" value="true"/>
        </attributes>
    </classpathentry>
    <classpathentry kind="lib" path="lib/xmpcore-6.1.11.jar">
        <attributes>
            <attribute name="module" value="true"/>
        </attributes>
    </classpathentry>
</classpath>
```

You may also want to create `.vscode/settings.json`:
```json
// settings.json
{
    "java.project.sourcePaths": [
        "src",
        "lib",
        ""
    ],
    "java.project.referencedLibraries": [
        "lib/**/*.jar"
    ],
}
```