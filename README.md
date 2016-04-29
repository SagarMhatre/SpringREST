* Started with a Spring Starter Project, no dependencies selected
* Deleted classes from src/test/java
* Removed the spring-boot-starter-test dependency from the pom.xml
* Replaced spring-boot-starter with spring-boot-starter-web
* Run the Application.java As Spring Boot App
* Navigating to http://localhost:8080/ yields Whitelabel Error Page
* To change the embedded server's port, add server.port=${port:9090} to \src\main\resources\application.properties file
* Add Model class with Attributes, getters, setters & deafult no arg constructor
* Add Dao class to add, edit, del, get model objects
* @RestController (value="/rest/entities") 
* @RequestMapping (method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity&lt;Collection&lt;T&gt;&gt; methodForGETtingAllObjects() {
	return new ResponseEntity&lt;Collection&lt;T&gt;&gt;(..., HttpStatus.OK) 	}
* Navigate to http://localhost:9090/users