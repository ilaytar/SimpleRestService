pipeline {
  agent {
    docker {
      image 'gradle'
    }

  }

  stages {
    stage('Build') {
    def currentBuildToolHome = tool 'gradle'
    env.PATH = "${currentBuildToolHome}/bin:${env.PATH}"
    configureEnvBeforeBuild('gradle')
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