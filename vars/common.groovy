def compile() {
  if (app_lang == "nodejs") {
  sh 'npm install'  
}
if (app_lang == "maven") {
  sh 'mvn package'  
}


}


def unittest() {
 // developer need to provide the test cases for the code
  if (app_lang == "nodejs") {
  sh 'npm test'
   }
if (app_lang == "maven") {
  sh 'mvn test'  
}

if (app_lang == "python") {
  sh 'python3 -m unittest'  
}
}

def email(email_notes){

  println email_notes
}