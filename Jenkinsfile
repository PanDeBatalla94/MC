pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                parallel app: {
                    node('a') {
                        echo 'Building..'
	                    sh './gradle/quickstart/gradlew clean assemble -p gradle/quickstart/'
                    }
                },
                web: {
                    node('b') {
                        echo 'Building web app..'
	                    sh './gradle/quickstart-web/gradlew clean assemble -p gradle/quickstart-web/'
                    }
                }
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

        stage('Loading Jenkins file') {
            jenkinsFile = fileLoader.fromGit('gradle/quickstart-web', 'https://github.com/PanDeBatalla94/MC.git', 'task13', null, '')
            jenkinsFile.runPipeline('https://github.com/PanDeBatalla94/MC.git')
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
