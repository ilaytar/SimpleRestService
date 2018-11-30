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
          script {
            allure includeProperties: false,
            jdk: '',
            report: "build/allure-report/",
            results: [[path: "build/allure-results/"]]
          }

        }

      }
    }
  }
  tools {
    gradle 'gradle'
  }
}