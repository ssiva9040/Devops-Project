pipeline {
    agent any
    stages {
        stage("build image") {
            steps {
                echo "building the image"
                withCredentials([usernamePassword(credentialsId: 'Docker-hub-credientials', passwordVariable: 'PASS', usernameVariable: 'USER')]){
                    sh 'docker build -t sivanesansaravanan/demo-app:test .'
                    sh "echo $PASS | docker login -u $USER --password-stdin"
                    echo 'docker push sivanesansaravanan/demo-app:test'
                }

            }
        }
        stage("test") {
            steps {
                echo "testing the application"
            }
        }
        stage("deploy") {
            steps {
                echo "deploying the application"
            }
        }
    }
}
