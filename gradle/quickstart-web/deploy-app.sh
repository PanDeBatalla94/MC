WAR_NAME=$1
TOMCAT_WEBAPPS=$2
echo 'Stopping Tomcat service...'
sudo systemctl stop tomcat8
sudo rm -f $TOMCAT_WEBAPPS/$WAR_NAME.war
sudo rm -rf $TOMCAT_WEBAPPS/$WAR_NAME

echo 'Sending war file...'
sudo cp -f /tmp/$WAR_NAME.war $TOMCAT_WEBAPPS/$WAR_NAME.war
sudo rm /tmp/$WAR_NAME.war

echo 'Starting Tomcat service...'
sudo systemctl start tomcat8
