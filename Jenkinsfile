pipeline {
    agent any

    environment {
        IMAGE_NAME = "springboot"
        CONTAINER_NAME = "sp"
        NETWORK = "my-network"
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/KBSudHanVa/jenkins_test.git'
            }
        }

        stage('Build JAR') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $IMAGE_NAME .'
            }
        }

        stage('Stop Old Container') {
            steps {
                sh 'docker stop $CONTAINER_NAME || true'
                sh 'docker rm $CONTAINER_NAME || true'
            }
        }

        stage('Deploy Container') {
            steps {
                sh '''
                docker run -d \
                  --name $CONTAINER_NAME \
                  --network $NETWORK \
                  -p 8080:8080 \
                  -e SPRING_DATASOURCE_URL=jdbc:postgresql://my_postgres:5432/mydb \
                  -e SPRING_DATASOURCE_USERNAME=postgres \
                  -e SPRING_DATASOURCE_PASSWORD='P0$tGre$' \
                  $IMAGE_NAME
                '''
            }
        }
    }

    post {
        success {
            echo '✅ Deployment Successful!'
        }
        failure {
            echo '❌ Pipeline Failed!'
        }
    }
}