pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        dir(path: 'cd restService') {
          powershell(script: 'gradle war cargoRedeployLocal cargoStartLocal', returnStatus: true, returnStdout: true)
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