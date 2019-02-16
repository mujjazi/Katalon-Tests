package Appium.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Appium.AppiumDriverBase;
import Appium.Delays;
import Appium.Helper;

public class CreateAccountTestCase extends AppiumDriverBase {
	
	@Test
    public void CreateAccount(){
    	
    	/*===============================================================================*/
    	/**Utility/Helper Classes Objects*/
    	/*================================================================================*/
    	
    	Helper helper = new Helper();
    	Delays delays = new Delays();
    	
    	/*===============================================================================*/
    	/**Locators*/
    	/*================================================================================*/
    	
    	By search_btn = By.id("com.sssports.sssports:id/action_search");
    	By search_field = By.id("com.sssports.sssports:id/search_src_text");
    	By shoppingbag_btn = By.id("com.sssports.sssports:id/iv_bag");
    	By action_btn = By.id("com.sssports.sssports:id/action_button");
    	By side_menu = By.xpath("//android.widget.ImageButton[@content-desc='‎‏‎‎‎‎‎‏‎‏‏‏‎‎‎‎‎‏‎‎‏‎‎‎‎‏‏‏‏‏‎‏‏‎‏‏‎‎‎‎‏‏‏‏‏‏‏‎‏‏‏‏‏‎‏‎‎‏‏‎‏‎‎‎‎‎‏‏‏‎‏‎‎‎‎‎‏‏‎‏‏‎‎‏‎‏‎‏‏‏‏‏‎‎Navigate up‎‏‎‎‏‎']");
    	By login = By.xpath("//android.widget.TextView[@text='Login']");
    	By email_field = By.id("com.sssports.sssports:id/et_email");
    	By pwd_field = By.id("com.sssports.sssports:id/et_password");
    	By confirm_pwd_field = By.id("com.sssports.sssports:id/et_confirm_passwrd");
    	By first_name_field = By.id("com.sssports.sssports:id/et_first_name");
    	By last_name_field = By.id("com.sssports.sssports:id/et_last_name");
    	By signin_btn = By.id("com.sssports.sssports:id/btn_sign_in");
    	By account_title = By.xpath("//android.widget.TextView[@text='MY ACCOUNT']");
    	By create_account = By.id("com.sssports.sssports:id/tv_create_account");
    	By prefix_selector = By.id("com.sssports.sssports:id/prefix_spinner");
    	By create_account_btn = By.id("com.sssports.sssports:id/btn_create_account");
    	
    	
    	/*===============================================================================*/
    	/**Local Variables*/
    	/*================================================================================*/
    	
    	int delay = 10;
    	String email = "mujtaba+4@werplay.com";
    	String pwd = "12345678";
    	String expected_string = "MY ACCOUNT";
    	String actual_string;
    	
    	
    	
    System.out.println("Inside Create Account Test");	
   
    //delays.staticDelay(delay);
 
    System.out.println("Waited"+ delay+"Seconds ");	
    
    helper.find(side_menu).click();
    
    helper.find(login).click();
    
    helper.find(create_account).click();
    
    driver.hideKeyboard();
    helper.find(email_field).click();
    driver.hideKeyboard();
    helper.find(email_field).sendKeys(email);
    
    helper.find(prefix_selector).click();
    
    helper.GetElementWithText("android:id/text1", "MR").click();
    
    helper.find(first_name_field).click();
    helper.find(first_name_field).sendKeys("MM");
    driver.hideKeyboard();

    
    helper.find(last_name_field).click();
    helper.find(last_name_field).sendKeys("MMMM");
    driver.hideKeyboard();
    
    
    helper.find(pwd_field).click();
    helper.find(pwd_field).sendKeys(pwd);
    driver.hideKeyboard();
   
    
    helper.find(confirm_pwd_field).click();
    helper.find(confirm_pwd_field).sendKeys(pwd);
    driver.hideKeyboard();
    
    helper.find(create_account_btn).click();
    
   
    
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
