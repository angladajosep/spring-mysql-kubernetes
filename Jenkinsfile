pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
/*         stage('Deliver') {
            steps {
                sh './jenkins/scripts/deliver.sh'
            }
        } */
        stage('Deliver2'){
            steps {
                sh 'mvn jar:jar install:install help:evaluate -Dexpression=project.name'
            }
        }
        stage('Run') {
            steps {
                sh 'pwd'
                sh 'set -x'
                sh 'java -jar target/test-sample.jar'
            }
        }

    }
}