# TradeMe_WebUITest:
  Using the TradeMe Sandbox web site, the following Web UI automation scenarios are automated using a maven cucumber project. 
  The test cases are implemented using BDD approach and using Page Object model. 
  The POM file contains all the required dependecies.

## Test Scenario:
  Query any existing Used Car listing and confirm that Number plate, Kilometres, Body, Seats details are shown.
  
  The data to the test cases is passed through the config.properties file. This file is present under the /src/test/resources directory.

## Resources:
  The /src/test/resources directory contains the required resources. The config.properties file contains the driver path, and the URLs used in the tests.  
  The /src/test/resources/drivers directory contains the browser specific driver.exe files.
  The /src/test/resources/featurefiles directory contains the feature files.
    
## Code Structure:
    The step definition files are present in the /src/test/java/stepdefinitions directory
    The page object model files are present in the /src/test/java/pages directory
    The test runner binding the feature file and the step definition files is present in the /src/test/java/runner directory

## Execution Command:
    The tests are triggered using the following command on the project directory prompt:
      > mvn test

## Test Results:
  The execution results are stores in the ./target directory under the project root directory. The execution reports are generated in the JSON, JUnit, and HTML formats.  
