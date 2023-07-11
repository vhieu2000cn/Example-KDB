pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                echo 'Testing..'
                bat './gradlew test'
                echo 'Finish Test'
            }
        }
        stage('Build') {
            steps {
                echo 'Building..'
                bat './gradlew clean build --stacktrace'
                echo 'Finish build'
            }
        }
        stage('Archive') {
            environment {
                DOCKER_TAG="${GIT_BRANCH.tokenize('/').pop()}-${GIT_COMMIT.substring(0,7)}"
            }
            steps {
                echo 'archive'
                echo DOCKER_TAG
                archiveArtifacts artifacts:'app/build/outputs/apk/debug/*.apk',
                onlyIfSuccessful: true
            }
        }
    }
    post{
        always {
            echo 'finish'
        }
    }
}