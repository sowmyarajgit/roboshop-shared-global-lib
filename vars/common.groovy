def compile() {
  if (app_lang == "nodejs") {
  sh 'npm install'  
}
if (app_lang == "maven") {
  sh 'mvn package'  
}


}
