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
	        sh './gradle/quickstart/gradlew clean test jacocoTestReport -p gradle/quickstart/'
                
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }

	
    }

    post {
        always {
            junit 'gradle/quickstart/build/test-results/test/*.xml'
            archiveArtifacts artifacts: 'gradle/quickstart/build/libs/*.jar', fingerprint: true
            publishHTML([allowMissing: true, 
                         alwaysLinkToLastBuild: false,  
                         keepAll: true, 
                         reportDir: 'gradle/quickstart/build/reports/tests/test', 
                         reportFiles: 'index.html', 
                         reportName: 'JUnit Test Reports'])
           publishHTML([allowMissing: true, 
                        alwaysLinkToLastBuild: false, 
                        keepAll: true, 
                        reportDir: 'gradle/quickstart/build/jacocoHtml', 
                        reportFiles: 'index.html', 
                        reportName: 'JaCoCo Coverage Reports'])
        }
    }
}
