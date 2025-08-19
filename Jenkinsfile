pipeline {
    agent any

    environment {
        // Set JAVA and MAVEN manually (Windows paths, adjust to your system)
        JAVA_HOME = "C:\\Program Files\\Java\\jdk-21"
        MAVEN_HOME = "C:\\SR\\SR12\\apache-maven-3.9.9"
        PATH = "${JAVA_HOME}\\bin;${MAVEN_HOME}\\bin;${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                // Pull code from GitHub (already handled by Jenkins SCM usually)
                git branch: 'main', url: 'https://github.com/SaurabhRaut45/Ecommerceproject2.git'
            }
        }

        stage('Build') {
            steps {
                echo "Building with Maven..."
                bat "mvn clean install -DskipTests"
            }
        }

        stage('Test') {
            steps {
                echo "Running tests..."
                bat "mvn test"
            }
        }

        stage('Package') {
            steps {
                echo "Packaging application..."
                bat "mvn package"
            }
        }
    }

    post {
        success {
            echo "✅ Build Successful!"
        }
        failure {
            echo "❌ Build Failed!"
        }
    }
}
