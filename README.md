# SimpleTemperatureConverter

A simple AJAX-based web app that converts Fahrenheit to Celsius using a Java Servlet and XML response.

## Features

- Input a Fahrenheit value and get the Celsius conversion.
- Uses AJAX (vanilla JavaScript `XMLHttpRequest`) to communicate with the servlet.
- Servlet returns XML-formatted result.
- Styled with basic CSS.

## Technologies

- Java (Jakarta Servlet API 6)
- Maven (build tool)
- Apache Tomcat (tested on Tomcat 11)
- HTML / CSS / JavaScript (AJAX)
- XML (for servlet response)

## Project Structure

```
SimpleTemperatureConverter/
├── pom.xml
└── src
    └── main
        ├── java
        │   └── com
        │       └── nikolay
        │           └── converterdemo
        │               └── TemperatureConversionServlet.java
        └── webapp
            ├── index.html
            ├── style.css
            ├── script.js
            └── WEB-INF
                └── web.xml
```



## Building the project (Linux)

- Open the root directory of the project (where pom.xml is)
- Open a terminal in the above mentioned dir and type/paste: "mvn clean package"
- There should now be a .war file in the same directory, rename it to: "SimpleTemperatureConverter" (This step isn't strictly necessary,
   but the address in the final step must match the name of the .war file)
- Copy the now-renamed file into the webapps directory in your apache-TOMCAT main directory
- Run TOMCAT using ./startup.sh
- Fire up your browser of choice and open using: "http://localhost:8080/SimpleTemperatureConverter/"
