pipeline {
  agent any
  stages {
    stage('startService') {
      parallel {
        stage('build') {
          steps {
            dir(path: '/restService') {
              sh 'gradle war'
            }

          }
        }
        stage('deploy') {
          steps {
            sh 'gradle cargoRedeployLocal '
          }
        }
        stage('start') {
          steps {
            sh 'gradle cargoStartLocal'
          }
        }
      }
    }
    stage('test') {
      steps {
        sh 'gradle clean test'
      }
    }
    stage('stopService') {
      steps {
        sh 'gradle cargoStopLocal'
      }
    }
  }
  tools {
    gradle 'gradle'
  }
}