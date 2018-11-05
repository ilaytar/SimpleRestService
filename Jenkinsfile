pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'ls'
        powershell(script: 'cd restService gradle war cargoRedeployLocal cargoStartLocal', returnStatus: true, returnStdout: true)
        dir(path: './restService')
        sh 'cd restService gradle war'
      }
    }
    stage('Test') {
      steps {
        powershell(script: 'gradle test cargoStopLocal', returnStatus: true, returnStdout: true)
      }
    }
  }
}