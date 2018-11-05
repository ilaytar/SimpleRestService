pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        dir(path: '/restService') {
          bat(script: 'gradle war cargoRedeployLocal cargoStartLocal', returnStatus: true, returnStdout: true)
        }

      }
    }
    stage('Test') {
      steps {
        bat(script: 'gradle test cargoStopLocal', returnStatus: true, returnStdout: true)
      }
    }
  }
}