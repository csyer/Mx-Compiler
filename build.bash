#!/bin/bash

cd "$(dirname "$0")" || exit
cd antlr4 || exit
antlr4 -no-listener -visitor -package parser -o ../src/parser MxLexer.g4 MxParser.g4 -Dlanguage=Java
cd ..
