pipeline {
  agent any
  stages {
    stage('startService') {
      parallel {
        stage('war') {
          steps {
            dir(path: 'restService') {
              sh 'gradle war'
            }

          }
        }
        stage('deploy') {
          steps {
            dir(path: 'restService') {
              sh 'gradle cargoRedeployLocal '
            }

          }
        }
        stage('start') {
          steps {
            dir(path: 'restService') {
              sh 'gradle cargoStartLocal'
            }

          }
        }
      }
    }
    stage('test') {
      steps {
        dir(path: 'restService') {
          sh 'gradle clean test'
        }

      }
    }
    stage('stopService') {
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