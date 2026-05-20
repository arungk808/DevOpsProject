pipeline{
    agent any
    environment{
        DOCKER_IMAGE="arungk808/javaapp"
        
    }

    stages{
        stage('Checkout'){
            steps{
                git branch: 'main', url: 'https://github.com/arungk808/DevOpsProject.git'
                echo 'checkout complete...'
            }
        }
        stage('Build'){
            steps{
                script{
                    def version = "v.$BUILD_NUMBER"
                    bat "mvn clean package -Dversion=${version}"
                }
            }
        }
        stage(' Build docker image'){
            steps{
                script{
                    bat 'docker build -t %DOCKER_IMAGE% .'
                }
            }
        }
        stage('Tag Docker Image') {
            steps {
                script {
                    def version = "v.$BUILD_NUMBER"
                    bat "docker tag %DOCKER_IMAGE%:latest %DOCKER_IMAGE%:${version}"
                }
            }
        }
        stage('Deploy'){
            steps{
               steps {
                bat 'docker stop spring-container || true'
                bat 'docker rm spring-container || true'
                bat "docker run -d -p 8080:8080 --name spring-container %DOCKER_IMAGE%:${version}"
            }
        }
    }
}
}