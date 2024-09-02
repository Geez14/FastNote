@echo off
REM compile, build
echo "----------Compiling----------"
javac -d out FastNoteApp.java
if %errorlevel%  neq 0 (
  echo "Compile Failed"
) else (
  echo "Compile Successful"
echo "-------Building FastNoteApp.jar-------"
jar cvfm FastNoteApp.jar MANIFEST.MF -C out .
 if %errorlevel% neq 0 (
   echo "Build Failed"
 ) else (
  echo "Compile and Build Successful"
 )
)
