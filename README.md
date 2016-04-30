* Started with a Spring Starter Project, no dependencies selected
* Deleted classes from src/test/java
* Removed the spring-boot-starter-test dependency from the pom.xml
* Replaced spring-boot-starter with spring-boot-starter-web
* Run the Application.java As Spring Boot App
* Navigating to http://localhost:8080/ yields Whitelabel Error Page
* To change the embedded server's port, add server.port=${port:9090} to \src\main\resources\application.properties file
* Add Model class with Attributes, getters, setters & default no arg constructor
* Add Dao class to add, edit, del, get model objects
* @RestController 
* @RequestMapping (value="/rest/entities" method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity&lt;Collection&lt;T&gt;&gt; methodForGETtingAllObjects() {
	return new ResponseEntity&lt;Collection&lt;T&gt;&gt;(..., HttpStatus.OK) 	}
* Navigate to http://localhost:9090/users
* @RequestMapping(value="/rest/entities/{entityId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity&lt;T&gt; getUserById(@PathVariable("entityId") int id) {
  //If found
    return new ResponseEntity&lt;T&gt;(..., HttpStatus.OK);
  //else
	return new ResponseEntity&lt;T&gt;(HttpStatus.NOT_FOUND);
* Navigate to http://localhost:9090/users/1 & http://localhost:9090/users/2
* @RequestMapping(value = "/rest/entities", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity&lt;T&gt; createEntity(@RequestBody User user) {	
	// If creation succeeded 	
		return new ResponseEntity&lt;T&gt;(..., HttpStatus.CREATED);
* Send POST to http://localhost:9090/rest/users/ with Body raw {...} & Content-Type application/json
* Then * Navigate to http://localhost:9090/users & http://localhost:9090/users/2
* @RequestMapping(value = "/rest/entities/{entityId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity&lt;T&gt; updateEntity(@PathVariable("entityId") int id, @RequestBody T t) {
  //If found, then edit & 
    return new ResponseEntity&lt;T&gt;(..., HttpStatus.OK);
  //else
	return new ResponseEntity&lt;T&gt;(HttpStatus.NOT_FOUND);
* Send PUT to http://localhost:9090/rest/users/2 & http://localhost:9090/rest/users/3  with Body raw {...} & Content-Type application/json
* Then Navigate to http://localhost:9090/users & http://localhost:9090/users/2
* @RequestMapping(value = "/rest/entities/{entityId}", method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity&lt;T&gt; updateEntity(@PathVariable("entityId") int id) {
  //If found, then delete & 
    return new ResponseEntity&lt;T&gt;(..., HttpStatus.NO_CONTENT);
  //else
	return new ResponseEntity&lt;T&gt;(HttpStatus.NOT_FOUND);
* Send DELETE to http://localhost:9090/rest/users/2 with Content-Type application/json
* Then Navigate to http://localhost:9090/users & http://localhost:9090/users/2
* Create an interface with all business methods. Implement it. Annotate the subclass with @Service. In controller declare a variable of type of the interface and annotate it with @Autowired. use this variable instead of the dao instance
