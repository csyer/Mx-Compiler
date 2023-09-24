#!/bin/bash

cd "$(dirname "$0")" || exit

# bash build.bash
make

./bin/mxc <test.mx >test.s

ravel --input-file=test.in --output-file=test.out test.s lib/builtin.s
