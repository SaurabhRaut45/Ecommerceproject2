pipeline {
    agent any

    tools {
        maven 'Maven'   // Configure Maven in Jenkins Global Tools
        jdk 'JDK11'     // Configure JDK in Jenkins Global Tools
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo "Running Maven Build..."
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Run Tests') {
            steps {
                echo "Executing Selenium + TestNG Tests..."
                sh 'mvn test -Dsurefire.suiteXmlFiles=testng.xml'
            }
        }

        stage('Publish Reports') {
            steps {
                script {
                    // ✅ Archive TestNG reports (HTML)
                    publishHTML([
                        allowMissing: false,
                        alwaysLinkToLastBuild: true,
                        keepAll: true,
                        reportDir: 'test-output',
                        reportFiles: 'index.html',
                        reportName: 'TestNG Report'
                    ])

                    // ✅ Archive ExtentReports (if stored in "reports/extent-report.html")
                    publishHTML([
                        allowMissing: true,
                        alwaysLinkToLastBuild: true,
                        keepAll: true,
                        reportDir: 'reports',
                        reportFiles: 'extent-report.html',
                        reportName: 'Extent Report'
                    ])
                }
            }
        }
    }

    post {
        always {
            // Archive surefire test results
            junit 'target/surefire-reports/*.xml'

            // Save reports as build artifacts (downloadable)
            archiveArtifacts artifacts: 'test-output/**, reports/**', fingerprint: true
        }
    }
}
