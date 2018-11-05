pipeline {
  agent {
    docker {
      image 'gradle'
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