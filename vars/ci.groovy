def call() {

    
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
            echo 'unittest'
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
}