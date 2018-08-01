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
    }
}
