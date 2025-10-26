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

	}
}