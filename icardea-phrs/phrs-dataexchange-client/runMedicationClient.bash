#!/bin/bash
#set -xv

clear

mvn clean 
mvn compile
mvn test-compile;mvn exec:java -Dexec.mainClass=at.srfg.kmt.ehealth.phrs.dataexchange.client.MedicationClientExample -Dexec.classpathScope=test

echo "Done"
