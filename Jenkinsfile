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
			script {
            allure([
                    includeProperties: false,
                    jdk: '',                  
                    results: [[path: 'build/allure-results']]
            ])
            }
          sh 'gradle test --stacktrace'
        }

      }
    }
  }
  tools {
    gradle 'gradle'
  }
}