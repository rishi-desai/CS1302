#!/bin/bash -ex

mvn -e -q clean

mvn -e -q compile

export MAVEN_OPTS=-Dprism.order=sw;

mvn -e -q -Dprism.order=sw exec:java
