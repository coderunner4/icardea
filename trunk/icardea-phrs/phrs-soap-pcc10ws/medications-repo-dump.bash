#!/bin/bash
#set -xv

clear

rem mvn clean compile
rem mvn test-compile
mvn exec:java -Dexec.mainClass=at.srfg.kmt.ehealth.phrs.ws.soap.pcc10.MedicationRepoDumpExample -Dexec.classpathScope=test -Dexec.args="191" -X
