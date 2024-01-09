# Selenium TestNG Maven Project 🚀

Welcome to our awesome Selenium TestNG Maven project! This project is designed to automate web testing using Selenium WebDriver and TestNG.

## Project Structure 📂
```
selenium-testNG-framework/
│
├── src/
│   ├── test/
│   │   └── java/
│   │       └── cucumberOption/
│   │           └── CucumberRunner.java
│   ├── resources/
│   │   ├── features/
│   │   ├── pageObjects/
│   │   └── utils/
│   └── java/
│       ├── features/
│       ├── pageObjects/
│       ├── stepDefinitions/
│       └── utils/
├── target/
├── pom.xml
└── README.md
```

# Selenium TestNG Cucumber Framework 🛠️

This is a Selenium TestNG Cucumber framework for automated testing. It utilizes Cucumber for behavior-driven development (BDD) and TestNG for test execution and reporting.

## Project Structure

- `src/test/java`: Contains test scripts, page objects, and step definitions.
- `src/test/resources`: Holds feature files, TestNG XML suite, and configuration files.

## Execution Workflow

1. **Clone the Repository**

    ```bash
    git clone https://github.com/edu-tech-opensource/selenium-testNG-framework.git
    cd selenium-testNG-framework
    ```

2. **Run Tests Using TestNG XML Suite (Recommended for Parallel Execution)**

    - Open the `testng.xml` file in the `src/test/resources` directory.
    - Adjust the suite configurations as needed.
    - Right-click on `testng.xml` and select "Run".

3. **Run Tests Using Maven**

    - Run all tests:

        ```bash
        mvn clean test
        ```

    - Run specific test suites:

        ```bash
        mvn clean test -DsuiteXmlFile=path/to/your/testng.xml
        ```

    - Run specific tags:

        ```bash
        mvn clean test -Dcucumber.filter.tags="@yourTag"
        ```

    - Run specific feature files:

        ```bash
        mvn clean test -Dcucumber.features=path/to/your/featureFile.feature
        ```

    **Note:** Ensure Maven and Java are installed on your machine. Dependencies will be downloaded during the first run.

## Cucumber Workflow

1. **Feature File:** Write feature files using Gherkin syntax. Define scenarios and steps.

2. **Step Definitions:** Implement step definitions in Java. Map steps to code.

3. **Runner Class:** Create a TestNG runner class. Specify the glue code (step definitions) and feature file locations.

4. **Test Execution:** Execute the runner class. Cucumber reads feature files, matches steps with step definitions, and executes tests.

5. **Reporting:** View Cucumber HTML reports generated in the `target/cucumber-reports` directory.

# TestNGTestRunner

The `TestNGTestRunner` class serves as the TestNG runner for executing Cucumber tests. It is configured with the `@CucumberOptions` annotation to define test options and settings.

## Configuration Options

- **Features:** Specifies the location of feature files.
- **Glue:** Defines the package for step definitions.
- **Monochrome:** Enhances console output readability.
- **Dry Run:** Verifies that all steps have corresponding step definitions.
- **Tags:** Executes scenarios with specified tags.
- **Plugin:** Configures reporting plugins (HTML, JSON, Extent Reports, Rerun).

## Parallel Execution

The `@DataProvider` annotation enables parallel execution of scenarios, enhancing test execution speed.

## How to Run

- Execute the runner class to trigger Cucumber tests.
- View generated reports in the `target` directory.


