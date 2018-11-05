pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'ls'
        powershell(script: 'cd restService gradle war cargoRedeployLocal cargoStartLocal', returnStatus: true, returnStdout: true)
        dir(path: './restService')
      }
    }
    stage('Test') {
      steps {
        powershell(script: 'gradle test cargoStopLocal', returnStatus: true, returnStdout: true)
      }
    }
  }
}