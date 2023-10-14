# QTest

This project is a UI automation framework designed to test the functionalities of the DemoBlaze website (https://www.demoblaze.com/). The framework is built using Selenium WebDriver with Java, and it uses TestNG as the testing framework. It automates the following use cases:

Register and login.
Verify that the listed categories have items.
Add a random item to the cart.
Remove an item from the cart.
Complete a successful checkout with a random item.
This README provides information on how to set up and run the automation tests.

Prerequisites
Before running the tests, ensure you have the following prerequisites:

Java Development Kit (JDK): You need to have Java installed on your system. You can download it from Oracle's website or use a package manager.

WebDriver: This framework uses the Chrome WebDriver. Make sure to download and configure it. You can download it from the official ChromeDriver website.

Maven: You need to have Maven installed. You can download it from the official Maven website or use a package manager.

IDE: You can use any Java-compatible Integrated Development Environment (IDE) like Eclipse, IntelliJ IDEA, or Visual Studio Code.

Project Structure
The project structure is organized as follows:

src/main/java: Contains the main application code and utility functions.
src/test/java: Contains the test classes for the automation use cases.
testng.xml: TestNG XML file to configure test suites and test cases.
pom.xml: Maven project configuration file.
Running the Tests
Follow these steps to run the automation tests:

Clone the repository to your local machine.

Open the project in your preferred IDE.

Configure the Chrome WebDriver in the setUp method of each test class, as needed. Modify the path to the ChromeDriver executable file.

Run the tests using TestNG:

Right-click on the testng.xml file in your IDE.
Select "Run As" or "Run" to execute the tests.
