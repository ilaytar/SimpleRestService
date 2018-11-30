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
          sh 'gradle cargoDeployRemote --stacktrace'
        }

      }
    }
    stage('test') {
      steps {
        dir(path: 'restService') {
          sh 'gradle test'
        }

      }
    }
  }
  tools {
    gradle 'gradle'
  }
}