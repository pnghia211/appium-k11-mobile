# Command to build
```
mvn clean package -DskipTests
```

# Command to run
* git ignore : allure-re*
```
call java -Dplatform=%platform% -Dremote=%true% -Dhub=%hub% -jar .\target\appium-k11-mobile-1.0-SNAPSHOT-fat-tests.jar
java -Dplatform=android -jar .\target\appium-k11-mobile-1.0-SNAPSHOT-fat-tests.jar

```
