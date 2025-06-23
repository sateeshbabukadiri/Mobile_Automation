# Mobile Automation Testing Framework

This mobile automation testing framework is designed for automating test cases for Android(Not limited to) applications using Appium, Cucumber, TestNG, and Log4j for logging. The framework supports dynamic execution and detailed reporting using ExtentReports including screenshots.


## Prerequisites

### System Requirements
- Install Homebrew
- Java Development Kit (JDK) 11 or higher
- Android SDK
- Xcode (for iOS testing)
- Node.js and npm (for Appium server)
- Appium installed globally (`npm install -g appium`)
- Appium Desktop (optional, for manual inspection and debugging)
- Gradle build tool

### Tools and Libraries
- Appium
- Selenium
- Cucumber
- TestNG
- Log4j
- ExtentReports/ Allure reports
-

### Setup Instructions
1. **Install HomeBrew - Open your Mac terminal and enter the below command**
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"

2**Install Java**
- Download and install JDK 11
Command - brew install openjdk@11

3. Set up the `JAVA_HOME` environment variable.
- open zshrc file Command - nano ~/.zshrc
- Add the below lines to file
     export JAVA_HOME=/opt/homebrew/opt/openjdk@11
     export PATH=$JAVA_HOME/bin:$PATH
- Reload the terminal - source ~/.zshrc  # or source ~/.bash_profile
- Verify Installation - java -version

4. Install maven
Command - brew install maven
Verify - mvn -version

5. **Install Node.js and npm**
Command - brew install node
verify - node -v
         npm -v

6. **Install Appium Server**
Command - npm install -g appium


**Install Android SDK**
-Download from https://developer.android.com/studio
-Install SDK & SDK Platform Tools
-Set environment variables in ~/.zshrc:
- Add `platform-tools` and `tools` to your PATH.
- open zshrc file 
     Command - nano ~/.zshrc
-Add the below lines in the file
  export ANDROID_HOME=**(Add the path from your machine)** - Example: $HOME/Library/Android/sdk   
  export PATH=$ANDROID_HOME/emulator:$ANDROID_HOME/tools:$ANDROID_HOME/tools/bin:$ANDROID_HOME/platform-tools:$PATH


### Changes Required to Run the Test
- In CapablitiesFile.json located as mentioned below update "**deviceName**", "**deviceVerison**" capability based on your device
    ```bash
   src/test/resources/CapabilitiesFile.Json
   ```
- Alternatively if you are running on a real device and/or have the app installed add these capabilities in addition to the above step
    ```bash
  "appPackage": "ca.bell.selfserve.mybellmobile",
  "appActivity": "ca.bell.selfserve.mybellmobile/.ui.splash.view.SplashActivity"

## To get the appPackage and appActivity information, Install the app in the Android device first
 - On your Android device:
  Go to Settings > About phone > Tap "Build number" 7 times to enable developer mode.
  Go to Settings > Developer options > Enable "USB debugging".
   - connect your android device to MAC machine. 
     - Open Terminal and use command - "adb devices"
     you will see the connected android device information. 
     Use the command - "adb shell pm list packages -3" to get all user installed Apps information
     copy your app information 
     - Use the command "adb shell cmd package resolve-activity --brief com.example.myapp | tail -n 1"
     replace the com.example.myapp with your app package.

     
    
- Configure testNg by providing suite path navigating to the location below
   ```bash
      src/test/resources/TestNg.xml
   ``` 

### Testing Approach
- Page Object Model (POM): Utilized Page Factory to initialize elements, ensuring a modular and maintainable structure for page objects.
- Cucumber TestNG Annotations: Employed Cucumber and TestNG annotations for setup and teardown processes, streamlining the execution flow.
- Base Objects Class: Reduced code duplication by extending the BaseObjects class. Created a public constructor and used the super() method to initialize objects from the BaseObjects class.
- Logging with Log4j: Implemented Log4j for logging. Configured appenders to log both to the console and ExtentReports, providing comprehensive logging.
- Comprehensive Reporting: Captured console logs, Appium server logs, and detailed step-by-step test execution logs, including screenshots, all stored in the TestOutput folder in the project root.
- Singleton Pattern for Driver Management: Applied the Singleton pattern to instantiate the driver, ensuring a single instance is used throughout the framework, enhancing efficiency and consistency.
### Further potential Enhancements
- Jira and TestRail/Zephyr Integration: Integrate with Jira and TestRail/Zephyr to log test execution status automatically, improving traceability and test management.
- Jenkins Integration: Set up Jenkins to run scripts on remote devices, enabling continuous integration and delivery (CI/CD) and ensuring tests are run in a controlled and scalable environment.

Repo URL: `` and  
Repo Directory `` 

