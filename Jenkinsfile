pipeline {
  agent {
    docker {
      image 'gradle'
    }

  }

  def configureEnvBeforeBuild(String toolName) {
      def currentBuildToolHome = tool toolName
      env.PATH = "${currentBuildToolHome}/bin:${env.PATH}"
  }

  stages {
    stage('Build') {
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