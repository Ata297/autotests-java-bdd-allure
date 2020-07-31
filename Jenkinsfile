pipeline {
    agent any

    stages {
        stage('Print en message') {
            steps {
                echo "Testing english massage"
            }
        }
        stage('Print ru message') {
            steps {
                echo "Тестирование русского сообщения"
            }
        }
        stage('Run test') {
            steps {
                withMaven(maven: 'maven_3.6.3') {
                    bat 'clean -Denviroment=enviroment install'
                }
            }
        }
        stage('Generate Allure Report') {
            steps {
                allure includeProperties: false,
                        jdk: '',
                        results: [[path: 'target/allure-results']]
            }
        }
    }
}