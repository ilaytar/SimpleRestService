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
    stage('start') {
      steps {
        dir(path: 'restService')
      }
    }
    stage('test') {
      steps {
        dir(path: 'restService') {
          sh 'gradle clean test'
        }

      }
    }
    stage('stop') {
      steps {
        dir(path: 'restService') {
          sh 'gradle cargoStopLocal'
        }

      }
    }
  }
  tools {
    gradle 'gradle'
  }
}