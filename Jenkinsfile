pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
	        sh './quickstart/gradlew clean assemble -p gradle/quickstart/'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
	        sh './quickstart/gradlew clean test -p gradle/quickstart/'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....i'
            }
        }
    }
}
