# Unit Testing demonstration project
[![Build Status](https://travis-ci.com/DimitrisMazarakis/lab_assignment.svg?token=vA99SPhkUkdzsEZp7i3d&branch=development)](https://travis-ci.com/DimitrisMazarakis/lab_assignment)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
## Overview
This is a Java project that create test cases that challenge the functionality of some Math methods. It is the second lab assgnment for the course Software Engineering.
## Requirements
This project requires:
- Java JDK [version 1.7](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) (or later) and
- Maven [3.3](https://maven.apache.org/download.cgi) (or later)
## Build project
In order to build the project execute the following Maven command:
```
mvn clean install jacoco:report
```
This command will also generate a report of the code coverage produced by JaCoCo. The report will be located in the following path for each module:
```
target/site/jacoco
```

## Test project
To simply run the unit tests of the project, execute the following Maven command: 
```
mvn test
```
***Important:*** Note that only classes with a ```Test``` suffix located in the ```src/test``` will be executed and reported as Tests.

## Generate Test-coverage report
To simply run the unit tests of the project, execute the following Maven command: 
```
mvn test jacoco:report
```


## Continuous Integration service
This projects utilizes TravisCI services in other to test and build the application upon each ```git-push``` in the remote repository. 
There are multiple build environments in which the application will be tested and build. You can check these options under the ```jdk``` tag in the ```.travis.yml``` file. 

After each build, the badge is updated with the corresponding build status, ```green``` for passes and ```red``` for failures.

[Here](https://docs.travis-ci.com/user/getting-started/) is a TravisCI quick guide. It's free for public repositories! 


## Contributing
You are more than welcome to contribute in this project. Just have in mind that the repository aims at providing an overview of unit testing functionality and Continuous Integration plug-ins related to testing. 
- If you have any suggestions please open an issue. 
- If you want to actively contribute, please fork this repository and create a pull request after completing your addition/modification.

## License 
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
