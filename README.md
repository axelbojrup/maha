This is a Spring Boot application in Java 11 with supported functionality as is described in the Maha's backend coding challenge.

To run the tests and build the project one can simply execute the following command

``./gradlew clean build``

To start the application run

``./gradlew bootRun``

An example request can be found below  

````curl -X POST -H "Accept: application/json" -H "Content-Type: application/json" -d '{"watches": ["001","001", "001", "001"]}' localhost:8080/checkout````

Which should return 

```{"price":300}```

This is something that easily could be integrated to a jenkins pipeline, preferably by wrapping above commands into a makefile, which then would be invoked in the jenkinsfile.


I started with making sure that this application could accept just a HTTP get request given the specification. 
When that was in place I worked on and tested a domain object that the request would be mapped to. 
I decided to just go with a Enum given the scope of this challenge. 
When I could read the request to that domain object I worked/tested the calculation of the price. Finally, the logic for discount was added. 

If more logic were to be added in this application likely the limiting factor would be the enum. If I were to spend more time on this project I would start with configuring this project to use groovy and spock as the test suite.  