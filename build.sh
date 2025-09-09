#!/bin/bash

# Parar al primer error
set -e

SRC_DIR="src"
OUT_DIR="out"
JAR_NAME="AgendaElectronica.jar"
MAIN_CLASS="AgendaElectronica"

rm -rf "$OUT_DIR" "$JAR_NAME"
mkdir -p "$OUT_DIR"
javac -d "$OUT_DIR" $(find "$SRC_DIR" -name "*.java")

# MANIFEST.MF
echo "Manifest-Version: 1.0" > MANIFEST.MF
echo "Main-Class: $MAIN_CLASS" >> MANIFEST.MF
echo "" >> MANIFEST.MF   # must end with a newline

# JAR
jar cfm "$JAR_NAME" MANIFEST.MF -C "$OUT_DIR" .
rm MANIFEST.MF
