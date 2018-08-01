pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
	        sh './quickstart/gradlew clean assemble -p quickstart/'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
	        sh './quickstart/gradlew clean test -p quickstart/'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
