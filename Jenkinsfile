// Jenkinsfile
pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    // Maven build
                    sh 'mvn clean package'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                // Build Docker image using the Dockerfile                script {
                    docker.build("nginx")
                }
            }
        }

        stage('Push to Docker Registry') {
            steps {
                // Push Docker image to a registry (e.g., Docker Hub)
                script {
                    docker push public.ecr.aws/x5r0g9c3/testing:latest
                    }
                }
            }
        }
    }
}

