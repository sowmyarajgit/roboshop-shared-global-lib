def compile {
  if (app_lang == "nodejs") {
  sh 'npm install'  
}
}