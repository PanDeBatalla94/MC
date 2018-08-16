pipeline {
    agent any
    stages {
        stage('Build') {
            parallel {
                stage('Build App') {
                    steps {               
                        echo 'Building..'
                        sh './gradle/quickstart/gradlew clean assemble -p gradle/quickstart/'               
                    }
                    post {
                        success {
                            archiveArtifacts artifacts: 'gradle/quickstart/build/libs/*.jar', fingerprint: true
                        }
                    }
                }
                stage('Build App-web') {
                    steps {               
                        echo 'Building web app..'
	                    sh './gradle/quickstart-web/gradlew clean assemble -p gradle/quickstart-web/'
                    }
                    post {
                        success {
                            archiveArtifacts artifacts: 'gradle/quickstart-web/build/libs/*.war', fingerprint: true
                        }
                    }
                }

            }    
        }
        stage('Test') {
            parallel {
                stage('Test App') {
                    steps {               
                        echo 'Testing..'
	                    sh './gradle/quickstart/gradlew test jacocoTestReport -p gradle/quickstart/'
                    }
                    post {
                        success {
                            junit 'gradle/quickstart/build/test-results/test/*.xml'
                            publishHTML(target: [allowMissing: true, 
                                        alwaysLinkToLastBuild: false,  
                                        keepAll: true, 
                                        reportDir: 'gradle/quickstart/build/reports/tests/test', 
                                        reportFiles: 'index.html', 
                                        reportTitles: "Simple Report",
                                        reportName: 'JUnit Test Reports'])

                            publishHTML(target: [allowMissing: true, 
                                        alwaysLinkToLastBuild: false, 
                                        keepAll: true, 
                                        reportDir: 'gradle/quickstart/build/jacocoHtml', 
                                        reportFiles: 'index.html',
                                        reportTitles: "SimpleCov Report", 
                                        reportName: 'JaCoCo Coverage Reports'])
                        }
                        
                    }
                }
                stage('Test Web App') {
                    steps {               
                       echo 'Testing web app..'
	                    sh './gradle/quickstart-web/gradlew test jacocoTestReport -p gradle/quickstart-web/'
                    }
                   
                }
            }

        }

        stage('Code quality') {
            parallel {
                stage('CodeQuality App') {
                    steps {               
                       echo 'Sonarqube...'
	                    sh './gradle/quickstart/gradlew sonarqube -p gradle/quickstart/'
                    }                
                }
                stage('CodeQuality Web App') {
                    steps {               
                       echo 'Sonarqube web...'
	                    sh './gradle/quickstart-web/gradlew sonarqube -p gradle/quickstart-web/'
                    }
                   
                }
            }
            
        }

        stage('Deploy') {
            parallel {
                stage('Deploy App') {
                    steps {               
                       echo 'Deploying...'
	                }
                   
                }
                stage('Deploy Web App') {
                    steps {               
                       echo 'Deploying web ...'
                       sh './gradle/quickstart-web/gradlew -b deploy.gradle deploy -Pdev_server=10.28.135.235 -Puser_home=/home -Pwar_path=gradle/quickstart-web/build/libs -p gradle/quickstart-web/'
                
	                }
                   
                }
            }
         

        }
    }
}

