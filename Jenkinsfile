pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
	        sh '''
                  chmod +x gradle/quickstart/gradlew
                  ./gradle/quickstart/gradlew clean assemble -p gradle/quickstart/
                '''
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
	        sh './gradle/quickstart/gradlew test jacocoTestReport -p gradle/quickstart/'                
            }
        }

        stage('Code quality') {
            steps {
                echo 'sonarqube...'
	        sh './gradle/quickstart/gradlew sonarqube -p gradle/quickstart/'                
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
