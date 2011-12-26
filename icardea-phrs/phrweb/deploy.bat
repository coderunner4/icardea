rem this bash script is used to pack and deploy the phrweb project in to an
rem existing Tomcat instance. 

cls

call package.bat

set tomcat_home="D:\tomcat\apache-tomcat-6.0.20"

call mvn  cargo:deploy  -Dcatalina.home=%tomcat_home%

echo "------------------------------------------"
echo "The phrweb is deployed on :"%tomcat_home%
echo "------------------------------------------"