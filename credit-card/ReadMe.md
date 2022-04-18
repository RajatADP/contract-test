**Below are steps I have taken to implement SCC in TDD fashion**

_**consumer side**_

* Create a new Spring Boot repository
* Write failing test with **404** - CreditCardApplicationTests.shouldGrantCreditCardWhenScoreIsHigh()
* Implement consumer feature code. Now test will give a different error - connection refused error because there is no provider

**_producer side_**
* Create a new Spring Boot repository. Do add spring verifier to pom.xml
* Create a new contract file under {test/resource} which is also **default path** - this will serve as stub producer
* Run `mvn clean install --DskipTests` which will 
    - stub is created
    - stub packages to jar and save in local maven repo
      
* These stub will be run by wire mock on consumer side to replicate real producer

_**consumer side**_
* Add spring stub runner in pom.xml
* Run CreditCardApplicationTests.shouldGrantCreditCardWhenScoreIsHigh() again. Will notice its green now.


**_producer side_**
* Run `mvn clean install`. Contract tests will fail which are automatically added by spring verifier
* Create _base test_ and add in pom which will do initial setup for all contract tests
* Run `mvn clean install`. There are few annotations added to _Base test_ to make contract pass
* 



**_SCC purpose_**

* Producer side
  - Generates stubs
  - Create tests from contract file

* Consumer side
  - Download stubs from repo
  - Extract stub mappings from jar
  - Starts wiremock







