#!/bin/bash
#set -xv

clear

mvn clean compile
mvn test-compile
mvn exec:java -Dexec.mainClass=at.srfg.kmt.ehealth.phrs.ws.soap.pcc9.PCC9EndpointExample -Dexec.classpathScope=test -Dexec.args="localhost 8989 testws/pcc9"


