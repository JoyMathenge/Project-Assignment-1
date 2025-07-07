#  FruitServiceEngine

A distributed system that manages fruit inventory and sales using Java Servlets, RMI, and Tomcat. It supports remote operations like adding fruits, updating prices, calculating costs, and printing receipts—all which are triggered via HTTP POST endpoints.

##  Features

-  Remote Method Invocation (RMI) architecture for task delegation
-  Java Servlets deployed in Apache Tomcat
-  Modular design using shared `Task` interface
-  Utility classes for price table management
-  Receipt generation and cost computation
-  Compatible with Postman, curl, and HTML forms



##  Technologies Used

| Layer            | Tech             |
|------------------|------------------|
| Backend Logic    | Java 19          |
| Remote Execution | Java RMI         |
| Web Layer        | Java Servlets    |
| Server           | Apache Tomcat 9  |
| Testing          | Postman, curl    |

---

##  Setup Instructions

###  1. Compile Utils and Tasks

```cmd
javac --release 19 server/src/server/utils/*.java
javac --release 19 -cp "server/src" server/src/server/tasks/*.java
```

###  2. Copy .class Files to Deployment Directory

```cmd
xcopy /Y server\src\server\utils\*.class web\WEB-INF\classes\server\utils\
xcopy /Y server\src\server\tasks\*.class web\WEB-INF\classes\server\tasks\
xcopy /Y server\src\server\*.class web\WEB-INF\classes\server\
```
###  3. Build and Deploy WAR File

```cmd
jar -cvf fruitserviceengine.war -C web .
copy fruitserviceengine.war tomcat9\webapps\
tomcat9\bin\shutdown.bat
tomcat9\bin\startup.bat
```
###  4. Test with Postman or curl
```bash
curl -X POST http://localhost:8080/fruitserviceengine/fruit/addFruit \
-H "Content-Type: application/json" \   
-d '{"name": "Apple", "price": 1.2, "quantity": 10}'
```

###  5. Access the Web Interface
Open your browser and navigate to `http://localhost:8080/fruitserviceengine/`           
to access the web interface for adding fruits, updating prices, and printing receipts.
