def buildImage() {
     echo "building the image"
                withCredentials([usernamePassword(credentialsId: 'Docker-hub-credientials', passwordVariable: 'PASS', usernameVariable: 'USER')]){
                    sh 'docker build -t sivanesansaravanan/demo-app:test .'
                    sh "echo $PASS | docker login -u $USER --password-stdin"
                    sh 'docker push sivanesansaravanan/demo-app:test'
                }
}
def deployApplication() {
    echo "deploying application"
}

return this
