pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                parallel(app: {
                    echo 'Building..'
                    sh './gradle/quickstart/gradlew clean assemble -p gradle/quickstart/'
                },
                web: {
                    echo 'Building web app..'
	                sh './gradle/quickstart-web/gradlew clean assemble -p gradle/quickstart-web/'
                })
            }
        }
        stage('Test') {
            steps {
                parallel(app: {
                    echo 'Testing..'
	                sh './gradle/quickstart/gradlew test jacocoTestReport -p gradle/quickstart/'
                },
                web: {
                    echo 'Testing web app..'
	                sh './gradle/quickstart-web/gradlew test jacocoTestReport -p gradle/quickstart-web/'
                })                  
            }
        }

        stage('Code quality') {
            steps {

                parallel(app: {
                    echo 'Sonarqube...'
	                sh './gradle/quickstart/gradlew sonarqube -p gradle/quickstart/'
                },
                web: {
                    echo 'Sonarqube web...'
	                sh './gradle/quickstart-web/gradlew sonarqube -p gradle/quickstart-web/'
                }) 
            }
        }

        stage('Deploy') {
            steps {
                parallel(app: {
                    echo 'deploying...'
                },
                web: {
                    echo 'deploying web...'
	                sh '''
                        ./gradle/quickstart-web/gradlew sonarqube -p gradle/quickstart-web/
                        b
                        deploy.gradle
                        deploy
                        -Pdev_server=10.28.135.235
                        -Puser_home=/home/go
                        -Pwar_path=war
                        -p
                         gradle/quickstart-web/
                    '''
                })                
            }

        }
    }

    post {
        always {
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
        success {
            archiveArtifacts artifacts: 'gradle/quickstart/build/libs/*.jar', fingerprint: true
        }
    }
}
