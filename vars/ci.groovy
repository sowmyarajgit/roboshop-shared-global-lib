def call() {
try{
    
pipeline {
    agent {
     label 'ansible'   
    }
 stages  {
    stage ('compile/build') {
        steps {
            script{
                common.compile()
            }
        }

    }
    stage ('unittest') {
        steps {
            script{
                common.unittest()
            }
        }

    }
    stage ('qualitycontrol') {
        environment {
         SONAR_USER ='$(aws ssm get-parameters --region us-east-1 --names sonarqube_user --query Parameters[0].Value --with-decryption | sed \'s/"//g\')'
        SONAR_PASS ='$(aws ssm get-parameters --region us-east-1 --names sonarqube_pass --query Parameters[0].Value --with-decryption | sed \'s/"//g\')'
    }
        steps {
            wrap([$class: 'MaskPasswordsBuildWrapper', varPasswordPairs: [[password: "${SONAR_PASS}", var: 'PASSWORD']]]){
            sh  "sonar-scanner -Dsonar.host.url=http://172.31.3.81:9000 -Dsonar.login=${SONAR_USER} -Dsonar.password=${SONAR_PASS} -Dsonar.projectkey=cart"
    }
        }

 }
    stage ('upload file to centalized place') {
        steps {
            echo 'upload file to centralized place'
        }

    }
 } 

}

}
catch(Exception e) {
   // Do something with the exception 

  common.email("Failed")
   
}
}