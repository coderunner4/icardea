cls
call title Step 10 Problems example
call mvn clean compile
call mvn test-compile
call mvn exec:java -Dexec.mainClass=at.srfg.kmt.ehealth.phrs.ws.soap.pcc10.ProblemsStep10ClientExample -Dexec.classpathScope=test
pause