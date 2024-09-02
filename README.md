# A simple notepad application using java swing

## Features

1. Word Wraping
2. Open file
3. Read file
4. Save file
5. 3_Theme
   1. LightMode
   2. DarkMode
   3. HackerTheme
6. Line Number

# For Windows, Linux
## Compile
```code
javac --release 8 -d ./out FastNoteApp.java
```

## Build
```code
jar -cvfm FastNoteApp.jar MANIFEST.MF -C out .
```

## Run
```code
java -jar FastNoteApp.jar
```

## package info:
> **Supported by Java1.8 and +**

## Automation Windows
added build process automation.
added run code
```
!note you must be in the project directory to compile and build
.\build.bat
.\FastNoteApp.bat
```
> paste the FastNoteApp.jar and FastNoteApp.bat in a directory and add the environment variable to that path.
