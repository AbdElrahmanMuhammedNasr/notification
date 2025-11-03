pipeline {
	agent {label 'agent2'}
	tools {
		maven 'MAVEN3'
		jdk 'JDK21'
	}
	environment {

		SONARQUBE_SERVER = 'sonar-scanner'
		SONAR_HOST_URL = 'http://host.docker.internal:9000' // your SonarQube URL

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
				git branch: 'master', url: 'https://github.com/AbdElrahmanMuhammedNasr/notification.git'
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

/*		stage('UNIT TEST') {
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
		}*/


stage('SonarQube analysis') {
		steps {
        withSonarQubeEnv(credentialsId: 'sonar-token' , installationName: 'soner-qube') {
		  script {
           sh "${maven}/bin/mvn sonar:sonar"
		  }
    }
		}
  }
    



		

		// stage('Quality Gate') {
		// 	steps {
		// 		timeout(time: 3, unit: 'MINUTES') {
		// 			waitForQualityGate abortPipeline: true

		// 		}
		// 	}
		// }

	}
}
