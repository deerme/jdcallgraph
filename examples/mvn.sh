#!/bin/bash

dir="$(dirname "$(pwd)")"
config="$(pwd)/config.ini"
mvn "$@" -DargLine="-javaagent:$dir/jdcallgraph/target/jdcallgraph-1.0-SNAPSHOT-agent.jar=$config"
