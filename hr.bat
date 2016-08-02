call mvn -B -s settings.xml -DskipTests=true clean install
call java -Dspring.profiles.active="heroku" -jar web/target/dependency/webapp-runner.jar web/target/*.war