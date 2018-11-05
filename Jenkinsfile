pipeline {
  agent {
    docker {
      image 'gradle:4.10.2-jdk8'
    }

  }
  stages {
    stage('Build') {
      steps {
        sh 'ls'
        sh 'cd restService && java -version && gradle -version'
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