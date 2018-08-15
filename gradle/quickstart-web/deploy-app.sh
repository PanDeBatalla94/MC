WAR_NAME=$1
echo 'Stopping Tomcat service...'
sudo systemctl stop tomcat8
sudo rm -f ${tomcat_webapps}/$WAR_NAME.war
sudo rm -rf ${tomcat_webapps}/$WAR_NAME

echo 'Sending war file...'
sudo cp -f /tmp/$WAR_NAME.war ${tomcat_webapps}/$WAR_NAME.war
sudo rm /tmp/$WAR_NAME.war

echo 'Starting Tomcat service...'
sudo systemctl start tomcat8
