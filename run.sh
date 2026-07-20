#!/bin/sh
# usage: ./run.sh [path/to/SolutionXX.java]
SRC=${1:-src/main/java/com/cihangir/algorithms/_03/Solution01.java}
CLS=$(echo "$SRC" | sed 's|^src/main/java/||; s|\.java$||; s|/|.|g')
javac -d out "$SRC" && java -cp out "$CLS"
