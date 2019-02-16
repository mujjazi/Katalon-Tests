package Appium;
 
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
 
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
 
public class AppiumDriverBase {
	
	
 
    public static AndroidDriver driver;
    protected WebDriverWait wait;
 
    //before Test Annotation makes a java function to run every time before a TestNG test case
    @BeforeTest
    protected void createAppiumDriver() throws MalformedURLException, InterruptedException {
 
    //relative path to apk file
    final File classpathRoot = new File(System.getProperty("user.dir"));
    final File appDir = new File(classpathRoot, "src/test/resources/apps/");
    final File app = new File(appDir, "Sun & Sand Sports.apk");
    final double os= 7.0;
    final String package_name = "com.sssports.sssports";
    final String activity_name = "com.sssports.sssports.ui.splash.SplashScreenActivity";
 
    //Running adb commands
    try {
		Helper.AdbRun();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    //setting up desired capability
    DesiredCapabilities caps = new DesiredCapabilities();
    //caps.setCapability("browserName", "");
    caps.setCapability("platform", "ANDROID");
    caps.setCapability("platformVersion", os);
    caps.setCapability("deviceName", "ANDROID");
    caps.setCapability("app", app.getAbsolutePath());
    caps.setCapability(MobileCapabilityType.APP_PACKAGE ,package_name);
    caps.setCapability(MobileCapabilityType.APP_ACTIVITY,activity_name);

 
    //initializing driver object
    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
 
    //initializing explicit wait object
    wait = new WebDriverWait(driver, 10);
    }
    
 
    //After Test Annotation makes a java function to run every time after a TestNG test case
    @AfterTest
    public void afterTest(){
 
    //quit the driver
    driver.quit();
    }
 
}