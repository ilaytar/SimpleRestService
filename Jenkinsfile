pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'ls'
        dir(path: 'restService') {
          sh 'gradle war cargoRedeployLocal cargoStartLocal'
        }

      }
    }
    stage('Test') {
      steps {
        powershell(script: 'gradle test cargoStopLocal', returnStatus: true, returnStdout: true)
      }
    }
  }
}