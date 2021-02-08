Exercises
============

# Exercise 1. Maven Dependencies

#### You will need to add 2 dependencies.
* TestNG (Latest version)
* Selenium-java (Latest v3 version [3.x])


Try to use properties for their versions!

# Exercise 2. Maven Build

#### We need to make sure the code compiles with java 11

Add a build section to your POM. This executes every time you build your code.
This should contain maven-compiler-plugin.

# Exercise 3. Packages

#### Create a correctly name package root

Create a package root with correct naming conventions.
Once you have your base package setup. Create a tests package within this.
You can also create your first class within this tests package.

# Exercise 4. First test

#### Create your first test.

The goal of this step is to create your first test. First step should be
to open a chrome browser and navigate to [this url](http://automationpractice.com/index.php)

# Exercise 4 Finding Elements.

#### Find your first WebElement

Try to find the search field and a list of the results displayed on the
front page. We'll be interacting with these elements in the next exercise.
Challenge yourself to limit css selectors to have a max of 1 children.

Do not use xpath selectors. These do not scale well to different browsers,
css selectors work on almost every browser.

# Exercise 5 Interacting with Elements.

#### Small exercise

Search for `dress` and `click second result` and validate that you get
transferred to the detail page of the product.

# Exercise 6 Multiple test cases.

#### Small exercise

Create some more test.

* Add something from the front-page to your cart
* Add something from the result page to your cart

We will tackle duplicate code in a later exercise, so don't be scared to
have duplicate code.

# Exercise 7 remove duplicate code.

#### Refactor

Take all your duplicate code and extract them to methods in the same class.

# Exercise 8 Page Object Model.

#### Use pages

Steps for this exercise:
* Create a `pages` package in your root package
* Create a `{pageName}Page` class for each url you interact with
* Move your extracted methods to the correct page

# Exercise 9 Driver Provider

#### Creating the driver provider

You'll see in the solution there is a lot of duplicate code for the driver.
We're going to resolve this with a driver provider.

Driver Provider:
* Create package `support`
* Move Driver creating to this class
* Move driver navigation to this page
* Create a getter -> use this getter on the pages

# Exercise 10 Advanced Page Object Model

#### Removing duplicate code

You'll notice you now have duplicate code over your pages

To do:
* Remove duplicate driver code with an AbstractPage (All pages will extend this)
* Remove duplicate methods by extracting these to new Pages
    * e.g. ProductPage containing the product functions which are present
      on the home page and search page can be extracted

# Exercise 11 Fluent interfacing

#### Fluent interfacing

Fluent interfacing or method chaining is a way to cleanup code.

This is done by returning the page your method would redirect to,
for example searching something will return the SearchResultPage (name
in the solution repo).

Your goal for this exercise is to make all your tests method chained.

# Exercise 12 Page Factory

#### Page factory

Add page factory logic to your project.

# Exercise 13 Abstract Page

#### Improving abstract page

Move duplicate code, and create methods for commonly used interactions.

For example, make a method for waiting and clicking on an element.

# Exercise 14 Cucumber dependencies

#### Exercise

You will need to add 2 new dependencies. TestNG and Java from cucumber.

# Exercise 15 Feature file

#### Exercise

Create a Feature file. Create scenarios for the tests you've already
written in your TestNG Tests. Creating the Steps and executing them
is for a later exercise.

Create a resources folder with a folder for your feature files.

# Exercise 16 Steps

#### Exercise

Create a new package called steps.

Define all your steps in classes in this package. Try to divide them over
multiple classes in a logic divide.

# Exercise 17 Cucumber executor

Create a new cucumber executor. See useful link for help.
To see what options are available in the @CucumberOptions, do CMD + P
when between the brackets. This will displays which options can be given.
Enter the options you'd like to add with comma dividers.

You can also delete the TestNG dependency and old tests.

# Exercise 18 Reporting

Start with some basic reporting. Try to add the fancy report plugin.
Once you have this HTML reporting working. Try to generate a json report.

All reporting should be located in `target/cucumber`.

# Exercise 19 Screenshots

Steps
* Create a ScenarioManager which saves the Scenario (from @Before hook)
* Create an EventHandler and adjust your DriverProvider accordingly
* Create a method to take a screenshot. (Advanced add scaling of the screenshot)

# Exercise 20 Maven profile

Steps
* Add a maven profile to run your tests
* Run your tests with maven in the terminal (This is how you will run your tests in the CI/CD)

# Exercise 21 State (World Picocontainer)

Steps
* Add a World Object
* Initiate it on every steps page
* Create a test case that use the state object

# Exercise 22 Multiple Browsers

Think of your packages, try to keep your code clean!

Steps
* Create an abstract DriverManager
* Create an enum for the browser/driver types
* Create a DriverManagerFactory that has a static method that returns the correct driver.
* (Optional) Create a System property to swap browsers

# Exercise 23 Cloud Browsers

Create a trial account on browser stack and saucelabs. This will give
you 60+ minutes to automate on each.

Steps
* Create a new enum that is executionMode
    * local
    * saucelabs
    * browserstack
* Change the factory to check on executionMode
    * local uses the code from previous exercise
    * others use a new RemoteDriverManager
* Create the RemoteDriverManager
    * You will need an url to target
    * You will need the browser type

# Exercise 24 Custom Parameters

Steps
* Make a Simple Parameter Type
    * Accept shirt, dress or pants
    * Return the option

# Exercise 25 Java Models

Steps
* Create a new package
* Create a model for:
    * The login form
    * The registration form

# Exercise 26 DataTable Transformers

Steps
* Add a new scenario for failing a login
* Use your created model for this scenario
    * Create a data table tranformer for this.

# Exercise 27 More Tests

Nice job on completing the exercises! Now experiment a bit with what
you've learned and try to have as much test coverage of the test site!