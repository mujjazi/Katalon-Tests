package Appium.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Appium.AppiumDriverBase;
import Appium.Delays;
import Appium.Helper;

public class LoginTestCase extends AppiumDriverBase {

	
	@Test
    public void LoginTestCase(){
    	
    	/*===============================================================================*/
    	/**Utility/Helper Classes Objects*/
    	/*================================================================================*/
    	
    	Helper helper = new Helper();
    	Delays delays = new Delays();
    	
    	/*===============================================================================*/
    	/**Locators*/
    	/*================================================================================*/
    	
   
    	By side_menu = By.xpath("//android.widget.ImageButton[@content-desc='‎‏‎‎‎‎‎‏‎‏‏‏‎‎‎‎‎‏‎‎‏‎‎‎‎‏‏‏‏‏‎‏‏‎‏‏‎‎‎‎‏‏‏‏‏‏‏‎‏‏‏‏‏‎‏‎‎‏‏‎‏‎‎‎‎‎‏‏‏‎‏‎‎‎‎‎‏‏‎‏‏‎‎‏‎‏‎‏‏‏‏‏‎‎Navigate up‎‏‎‎‏‎']");
    	By login = By.xpath("//android.widget.TextView[@text='Login']");
    	By email_field = By.id("com.sssports.sssports:id/et_email");
    	By pwd_field = By.id("com.sssports.sssports:id/et_password");
    	By signin_btn = By.id("com.sssports.sssports:id/btn_sign_in");
    	By account_title = By.xpath("//android.widget.TextView[@text='MY ACCOUNT']");
    	
    	
    	/*===============================================================================*/
    	/**Local Variables*/
    	/*================================================================================*/
    	
    	int delay = 10;
    	String email = "mujtaba@werplay.com";
    	String pwd = "12345678";
    	String expected_string = "MY ACCOUNT";
    	String actual_string;
    	
    	
    	
    System.out.println("Inside Login Test");	
   
    delays.staticDelay(delay);
 
    System.out.println("Waited"+ delay+"Seconds ");	
    
    helper.find(side_menu).click();
    
    helper.find(login).click();
/*    WebElement email_elem = helper.find(email_field);
    
    email_elem.click();*/
    helper.find(email_field).sendKeys(email);
  //  driver.getKeyboard().sendKeys("My Name");
   // email_elem.sendKeys(email);
    
    helper.find(pwd_field).sendKeys(pwd);
  //  helper.sendtext(pwd);
    
    driver.navigate().back();
    
    helper.find(signin_btn).click();
    
    WebElement accounttitle_elem = helper.find(account_title);
    System.out.println(accounttitle_elem.getText());
    
    if(Helper.elementIsPresent(accounttitle_elem)==true)
    	
    Assert.assertEquals(accounttitle_elem.getText(),expected_string);
    
    else {
    	System.out.println("Account page not displayed on login");
    }
    
    delays.staticDelay(delay); //Added static delay for the user to see the result 

    
    }
 
}
	

