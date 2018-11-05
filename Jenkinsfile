pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'ls'
        sh 'cd restService && gradle war'
        sh 'ls'
        sh 'gradle war cargoRedeployLocal cargoStartLocal'
      }
    }
    stage('Test') {
      steps {
        sh 'gradle test cargoStopLocal'
      }
    }
  }
}