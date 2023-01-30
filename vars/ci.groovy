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
        steps {
            echo 'qualitycontrol'
        }

    }
    stage ('upload file to centalized place') {
        steps {
            echo 'upload file to centralized place'
        }

    }
 } 

}
catch(Exception e) {
   // Do something with the exception 

common.email("Failed")
   
}
}
catch(Exception e) {
   // Do something with the exception 

common.email("Failed")
   
}
}