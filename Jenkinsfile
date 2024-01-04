#!/usr/bin/env groovy

def gv

pipeline {
    agent any
    stages {
        stage('build version') {
            steps {
                script {
                    def buildNumber = env.BUILD_NUMBER
                    echo "Build Number: ${buildNumber}"
                }
            }
        } 
        stage("init"){
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build image") {
            steps {
               script {
                gv.buildImage()
               }
            }
        }
        stage("deploy") {
            steps {
                script {
                    gv.deployApplication()
                }
            }
        }
    }
}
