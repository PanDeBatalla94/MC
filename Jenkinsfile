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
	        sh './gradle/quickstart/gradlew clean test -p gradle/quickstart/'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }

	stage('Report Gathering') {
            steps {
               
                echo 'Preparing reports....'
		sh './gradle/quickstart/gradlew clean build gradle/quickstart/'

                    publishHTML([allowMissing: true, 
                                 alwaysLinkToLastBuild: false,  
                                 keepAll: true, 
                                 reportDir: 'gradle/quickstart/build/reports/tests', 
                                 reportFiles: 'index.html', 
                                 reportName: 'JUnit Test Reports'])
		sh './gradle/quickstart/gradle test jacocoTestReport gradle/quickstart/'
                    publishHTML([allowMissing: true, 
                                 alwaysLinkToLastBuild: false, 
                                 keepAll: true, 
                                 reportDir: 'gradle/quickstart/build/reports/jacoco', 
                                 reportFiles: 'index.html', 
                                 reportName: 'JaCoCo Coverage Reports'])
            }
        } 
    }
}
