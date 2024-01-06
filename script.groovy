def buildImage() {
     def buildNumber = env.BUILD_NUMBER
     echo "Build Number: ${buildNumber}"
     echo "building the image"
                withCredentials([usernamePassword(credentialsId: 'Docker-hub-credientials', passwordVariable: 'PASS', usernameVariable: 'USER')]){
                    sh "docker build -t sivanesansaravanan/demo-app:test-${buildNumber} ."
                    sh "echo $PASS | docker login -u $USER --password-stdin"
                    sh "docker push sivanesansaravanan/demo-app:test-${buildNumber}"
                }
}

return this
