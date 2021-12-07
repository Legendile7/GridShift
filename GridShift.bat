COLOR 0b
@echo off
cls
:start
echo.
java Main.java
echo.
set choice=
set /p choice="Enter key to exit or r to restart: "
if not '%choice%'=='' set choice=%choice:~0,1%
if '%choice%'=='r' goto start
