cls
call title Medications step 8 client example
call mvn clean compile
call mvn test-compile
call mvn exec:java -Dexec.mainClass=at.srfg.kmt.ehealth.phrs.ws.soap.pcc10.MedicationsStep8ClientExample -Dexec.classpathScope=test

pause