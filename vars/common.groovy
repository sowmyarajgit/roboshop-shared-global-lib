def compile() {
  if (app_lang == "nodejs") {
  sh 'npm install'  
  sh 'env'
}
if (app_lang == "maven") {
  sh 'mvn package'  
}


}


def unittest() {
 // developer need to provide the test cases for the code
  if (app_lang == "nodejs") {
  sh 'npm test || true'
  
   }
if (app_lang == "maven") {
  sh 'mvn test'  
}

if (app_lang == "python") {
  sh 'python3 -m unittest'  
}
}

def email(email_notes){

  mail bcc: '', body: "JOB FAILED - ${JOB_BASE_NAME} \n JOB URL - ${JOB_URL}", cc: '', from: 'sowmyaraj435@gmail.com', replyTo: '', subject: "Test from jenkins - ${JOB_BASE_NAME}", to: 'sowmyaraj435@gmail.com'
}