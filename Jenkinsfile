pipeline {
	agent any
	tools {
		maven 'MAVEN3'
		jdk 'JDK21'
	}
	environment {

		SCANNER_HOME = tool 'sonar-scanner'

		NEXUS_VERSION = 'nexus3'
		NEXUS_PROTOCOL = "http"
		NEXUS_URL = "host.docker.internal:8081"
		NEXUS_REPOSITORY = "notification-repo"
		NEXUS_REPO_ID = "notification-repo"
		NEXUS_CREDENTIAL_ID = "nexuslogin"
		ARTVERSION = "${env.BUILD_ID}"
	}

	stages {
		stage("Clean Workspace") {
			steps {
				cleanWs()
			}
		}

		stage("Git Checkout") {
			steps {
				git branch: 'msater', url: 'https://github.com/AbdElrahmanMuhammedNasr/notification.git'
			}
		}
		stage('BUILD') {
			steps {
				sh 'mvn clean install -DskipTests'
			}
			post {
				success {
					echo 'Now Archiving...'
 				}
			}
		}

		stage('UNIT TEST') {
			steps {
				sh 'mvn test'
			}
		}

		stage('INTEGRATION TEST') {
			steps {
				sh 'mvn verify -DskipUnitTests'
			}
		}

		stage('CODE ANALYSIS WITH CHECKSTYLE') {
			steps {
				sh 'mvn checkstyle:checkstyle'
			}
			post {
				success {
					echo 'Generated Analysis Result'
				}
			}
		}

	}
}