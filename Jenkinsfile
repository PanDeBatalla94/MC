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
                publishHTML([allowMissing: true, 
                                 alwaysLinkToLastBuild: false,  
                                 keepAll: true, 
                                 reportDir: 'gradle/quickstart/build/reports/tests', 
                                 reportFiles: 'index.html', 
                                 reportName: 'JUnit Test Reports'])
                publishHTML([allowMissing: true, 
                                 alwaysLinkToLastBuild: false, 
                                 keepAll: true, 
                                 reportDir: 'gradle/quickstart/build/reports/jacoco', 
                                 reportFiles: 'index.html', 
                                 reportName: 'JaCoCo Coverage Reports'])
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }

	
    }
}
