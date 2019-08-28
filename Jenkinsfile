pipeline {
    agent {
        label 'qa'
    }
    
    stages {
        
        stage('Clean') {
            steps {
                sh 'mvn clean'
            }
        }
       
      
        stage('Build & Publish') {
            steps {
                sh 'mvn install package'
		       } 
        }
          
        stage('Save to tmp') {
            steps {
                sh 'mkdir -p /tmp/location_for_dashboard_artifacts;  cp target/*.jar  /tmp/location_for_dashboard_artifacts'
            }        
        }
    }
}
