COLOR 0b
@echo off
cls
echo GridShift Cipher v1.10.4 (May 25, 2022) Copyright 2022 by Divesh Gupta is licensed under CC BY-NC-ND 4.0. To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/
:start
echo.
java Main
echo.
set choice=
set /p choice="Press Enter to exit or r + Enter to restart: "
if not '%choice%'=='' set choice=%choice:~0,1%
if '%choice%'=='r' goto start
