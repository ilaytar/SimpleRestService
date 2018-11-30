pipeline {
  agent any
  stages {
    stage('war') {
      steps {
        dir(path: 'restService') {
          sh 'gradle clean war'
        }

      }
    }
    stage('deploy') {
      steps {
        dir(path: 'restService') {
          sh 'gradle cargoRedeployRemote --stacktrace'
        }

      }
    }
    stage('test') {
      steps {
        dir(path: 'restService') {
          sh 'gradle test'
          sh 'gradle allureReport'
        }

      }
    }
  }
  tools {
    gradle 'gradle'
  }
}