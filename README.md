
# Trust Wallet Mobile Test Automation Framework

## **Overview**
This project provides a **mobile test automation framework** for Trust Wallet using **Appium, Java, TestNG, and Maven**. It automates wallet creation, PIN entry, and navigation to ensure seamless user experience.

---

## **Prerequisites**
### **1. Install Android SDK**
- Download and install **Android SDK** from [Android Developer](https://developer.android.com/studio).
- Install **platform tools** (`adb`, `fastboot`).
- Set up environment variables:
  ```bash
  export ANDROID_HOME=$HOME/Android/sdk
  export PATH=$PATH:$ANDROID_HOME/platform-tools
2. Set Up a Mobile Device (Real or Emulator)
   Using a Real Device
   Enable Developer Options in device settings.

**Enable USB Debugging/ Wireless Debugging**

**Verify connection with:**

`bash
adb devices`

**Using an Emulator
Open Android Studio and go to AVD Manager.**

Create and start an emulator.

3. Install Java & Maven
   Java
   Install JDK 11 or later from Oracle.

**Verify installation:**

`bash
java -version`
Maven
**Install Maven from Apache Maven.**

Verify installation:

`bash
mvn -version`
`**4. Install Appium**`
   Appium Server
   Install globally:

bash
npm install -g appium


bash
appium
**Appium Java Client**
**Add the following dependency in pom.xml:**
`<dependency>
<groupId>io.appium</groupId>
<artifactId>java-client</artifactId>
<version>8.3.0</version> <!-- Check latest version -->
</dependency>`


Project Setup
Clone the Repository
bash
git clone https://github.com/your-repo/trust-wallet-test
cd trust-wallet-test

**Install Dependencies**
`bash
mvn clean install`

**copy TrustWallet.apk file under** `src/apps/android`

**Start the Appium server:**

`appium server -p 4725 -a 127.0.0.1 -pa /wd/hub`

**Run All Tests**
`bash
mvn test`

**Run Specific Test Case**

`bash
mvn test -Dtest=CreateWalletTest`

Framework Structure
* src/
* │── utils/
* │   ├── DriverUtils.java
* │── pages/
* │   ├── CreateWalletPage.java
* │── tests/
* │   ├── CreateWalletTest.java
utils/DriverUtils.java – Handles driver initialization & teardown.

pages/CreateWalletPage.java – Encapsulates wallet-related UI interactions.

tests/CreateWalletTest.java – Implements test scenarios.

**Reporting
The framework integrates Allure Reports. To generate reports:**

`$bash
mvn allure:serve`

#### **I copied screen recording of local execution under "`src/test/resources/recording`"**

