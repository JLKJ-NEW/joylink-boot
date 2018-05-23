#!/usr/bin/env groovy
pipeline {
    agent { docker { image 'maven:3.5.3' } }

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
	post {
		always {
			echo 'always do'
		}
		success {
			echo 'success do'
		}
		failure {
			echo 'failure do'
		}
		unstable {
			echo 'unstable do'
		}
		changed {
			echo 'changed do'
		}
	}
}