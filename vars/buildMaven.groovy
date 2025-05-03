def call(String pomPath = '.') {
    pipeline {
        agent any
        tools {
            maven 'Maven 3.8.5'
        }
        stages {
            stage('Checkout') {
                steps {
                    checkout scm
                }
            }
            stage('Build') {
                steps {
                    sh "mvn -f ${pomPath}/pom.xml clean install"
                }
            }
            stage('Run') {
                steps {
                    sh "java -cp target/hello-world-1.0-SNAPSHOT.jar com.example.HelloWorld"
                }
            }
        }
    }
}
