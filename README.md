# FiveBakery
**Project setup**

**Prerequisites:**
1. Install IntelliJ
2. Install Java (get for e.g. JDK 11) *it was used OpenJDK-11 
3. Add Java to path - Windows (JAVA_HOME=path\to\your\jdk\jdk-11)
4. Install maven (e.g. 3.6.3)
5. Add maven to path: (MAVEN_HOME=path\to\your\maven_dir\apache-maven-3.6.3)
		    (M2_HOME=path\to\your\maven_dir\apache-maven-3.6.3)
6. Add next values to path variable: ;%M2_HOME%\bin; and ;%JAVA_HOME%\bin;
7. Use git to clone repository
8. Download ChromeDriver, unzip it and place it to FiveBakery\src\test\java\DriverConfigurations
9. Add ChromeDriver to path variable (;path\to\FiveBakery\src\test\java\DriverConfigurations;) 
10. Open project with IntelliJ 
11. Update ChromeDriver path in ..\DriverConfigurations\Initiate with path to your ChromeDriver (do not forget .exe at the end of path if you are using Win)
(example of path "path\to\project\\FiveBakery\\src\\test\\java\\DriverConfigurations\\chromedriver.exe")

**Project structure**
Navigating to  FiveBakery\src\test\java\ we can see 6 directories. 
 1. DriverConfigurations contains 3 files: chromedriver.exe, ElementActions.java and Initiate.java
	1. chromedriver is executable file needed for running tests in GoogleChrome
	2. ElementActions.java contains methods just like: elementClick, elementLocate, elementPresent, sendKeys, etc.
	3. Initiate.java contains setup method which initiates chrome driver (multiple drivers if run in parallel)
 2. Methods contains 3 files: AccountActionsMethods, DateTimeMethods and GeneralMethods
	1. AccountActionMethods contains methods just like: registerNewUser.java, loginUser.java, etc.
	2. DateTimeMethods contains metods used for setting up order date and time
	3. GeneralMethods contains scolling methods and generating new random email method
 3. Selectors contains 4 files: HomePage, LandingPage, LoginPage and RegistrationPage
	Each one of them contains selectors for named screen
 4. StaticData contains 2 files: Data and StaticText
	1. Data contains static data such as username, password, etc. that will be reused in tests
	2. StaticText contains all text needed for text verification
 5. Suites contains one xml file which contains all tests. With one click on Suites we can run whole regression in parallel
 6. Tests contains 3 files: LoginRegisterTest, OrderTest and SearchTest
	Each file contains multiple tests that are testing flows just like: login, registration, logout, search, order, etc.

Each test is standalone. By running suite TestSuite.xml, one will run all tests in parallel. Maximum number of threads (number of chrome browsers) 
is set to 4 which will be maximum number of tests that will run simultaneously.
