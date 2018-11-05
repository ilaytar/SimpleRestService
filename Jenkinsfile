pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'ls'
        dir(path: 'restService')
        powershell(script: 'gradle war cargoRedeployLocal cargoStartLocal', returnStatus: true, returnStdout: true)
      }
    }
    stage('Test') {
      steps {
        powershell(script: 'gradle test cargoStopLocal', returnStatus: true, returnStdout: true)
      }
    }
  }
}