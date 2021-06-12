# Design Patterns
![](media/4th_lab_Assignment.png)
[![Build Status](https://travis-ci.com/DimitrisMazarakis/lab_assignment.svg?token=vA99SPhkUkdzsEZp7i3d&branch=development)](https://travis-ci.com/DimitrisMazarakis/lab_assignment)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
## Overview
This is a Java project that reads a Java source
code file that is stored locally or on the web, calculates the Lines of Code
(LOC), Number of Classes (NOC) and Number of Methods (NOM) metrics,
and finally, exports these metrics to an output file. It is the fourth lab assignment for the course Software Engineering in Practise.
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
## Run the program
To simply run the unit tests of the project, execute the following command: 
```
$> java –jar “jar-with-dependencies” arg0 arg1 arg2 arg3 arg4
arg0 = “JavaSourceCodeInputFile” (e.g., src/test/resources/TestClass.java)
arg1 = “sourceCodeAnalyzerType” [regex|strcomp]
arg2 = “SourceCodeLocationType” [local|web]
arg3 = “OutputFilePath” (e.g., ../output_metrics_file)
arg4 = “OutputFileType” [csv|json]

```

## Class Diagram
Here you can see the class diagram of the progrma which has been made with the tool [Visual Paradigm](https://www.visual-paradigm.com/)
Every color represents a different Strategy Pattern. Each factory should have been connected with the classes of each interface they represent but I have added more arrows it will have been a mess.

![](/media/4th_lab_Assignment.png)

# Report
In order to redisign this program I used the Facade Pattern,  the Factory Pattern and the Strategy Pattern.
# Facade Patter
## Update DemoClient class
### DemoClient Role
+ Reads the command line arguments.
+ Communicate with the Facade class.
### Benefits
+ It is now independant from the other classes. If a change occurs to other classes then this class will not be affected.
## Creation of Facade class
### Role
+ The main role is to make all the necessary operations by calling all the methods needed for the program.
+ Creates a communication between DemoClient, the SourceCodeAnalyzerF, the MetricsExporterFactory and the SourceFileReaderFactory classes.
+ Calls the Factories methods.
### Facade Benefits
+ Simplier interface.
+ The Democlient class is independant from the other classes.
+ De-couples the subsystem for DemoClient.
# Factory Pattern
## Creation of SourceCodeAnalyzerFactory class
### SourceCodeAnalyzerFactory Role
+ Creates the right SourceCodeAnalyzer object.
### Benefits
+ The Facade class does not need to know how the object is returned.
+ It is now more flexible because we can extend SourceCodeAnalyzer hierarchy without affecting.
the Facade class.
## Creation of SourceFileReaderFactory class
### SourceFileReaderFactory Role
+ Creates the right SourceFileReader object.
### Benefits
+ The Facade class does not need to know how the object is returned
+ It is now more flexible because we can extend SourceFileReader hierarchy without affecting.
the Facade class.
## Creation of MetricsExporterFactory class.
### MetricsExporterFactory Role
+ Creates the right MetricsExporter object.
### Benefits
+ The Facade class does not need to know how the object is returned.
+ It is now more flexible because we can extend MetricsExporter hierarchy without affecting.
the Facade class.
# Strategy Pattern
## Creation of MetricsExporter interface
### MetricsExporter Role
+ Is to specify how the method write should be.
### Benefits
+ Multiple inheritance
## Creation of CsvWriter and JsonWriter classes
### CsvWriter Role
+ Writes as an output a csv file.
+ ### JsonWriter Role
+ Writes as an output a json file.
### Benefits
+ There is less complecity than before because there are less if-else statements.
+ There is less complecity in writer classes and better cohesion because each class does a specific thing now.
+ If we want to extend by adding more output formats like .txt then it will be easier to implement the change and we will no need to change something in the facade class but only a small change to the MetricsExporterFactory and add a new writer class.  

## Creation of SourceFileReader interface
### SourceFileReader Role
+ Is to specify how the methodsreadFileIntoList and readFileIntoString should be.
### Benefits
+ Multiple inheritance
## Creation of readLocalFile and readWebFile classes
### readLocalFile Role
+ Reads a local file either into list or into String.
### readWebFile Role
+ Reads a web file either into list or into String.
### Benefits
+ There is less complecity than before because there are less if-else statements.
+ There is less complecity in writer classes and better cohesion because each class does a specific thing now.
+ If we want to extend by adding more file locations then it will be easier to implement the change and we will no need to change something in the facade class but only a small change to the SourceFileReaderFactory and add a new reader class.  

## Creation of SourceCodeAnalyzer interface
### SourceCodeAnalyzer Role
+ Is to specify how the calculateLOC, calculateNOM and calculateNOC should be.
### Benefits
+ Multiple inheritance
## Creation of RegexAnalyzer and StrcompAnalyzer classes
### RegexAnalyzer Role
+ Do calculations for files in form of a String and return the right metrics.
### StrcompAnalyzer Role
+ Do calculations for files in form of a List and return the right metrics.
### Benefits
+ There is less complecity than before because there are less if-else statements.
+ There is less complecity in writer classes and better cohesion because each class does a specific thing now.
+ If we want to extend by adding more read types then it will be easier to implement the change and we will no need to change something in the facade class but only a small change to the SourceCodeAnalyzerFactory and add a new analyzer class. 

## Contributing
You are more than welcome to contribute in this project. Just have in mind that the repository aims at providing an overview of unit testing functionality and Continuous Integration plug-ins related to testing. 
- If you have any suggestions please open an issue. 
- If you want to actively contribute, please fork this repository and create a pull request after completing your addition or modification.

## License 
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
