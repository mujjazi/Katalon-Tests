package Appium.TestCases;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Appium.AppiumDriverBase;
import Appium.Delays;
import Appium.Helper;
import io.appium.java_client.MobileElement;

public class ShopSaleTestCase extends AppiumDriverBase {
	
	@Test
    public void ShopSaleTest(){
    	
    	/*===============================================================================*/
    	/**Utility/Helper Classes Objects*/
    	/*================================================================================*/
    	
    	Helper helper = new Helper();
    	Delays delays = new Delays();
    	
    	/*===============================================================================*/
    	/**Locators*/
    	/*================================================================================*/
    	
    	//BY Strings
    	
    	By search_btn = By.id("com.sssports.sssports:id/action_search");
    	By search_field = By.id("com.sssports.sssports:id/search_src_text");
    	By shoppingbag_btn = By.id("com.sssports.sssports:id/iv_bag");
    	By action_btn = By.id("com.sssports.sssports:id/action_button");
    	By side_menu = By.xpath("//android.widget.ImageButton[@content-desc='‎‏‎‎‎‎‎‏‎‏‏‏‎‎‎‎‎‏‎‎‏‎‎‎‎‏‏‏‏‏‎‏‏‎‏‏‎‎‎‎‏‏‏‏‏‏‏‎‏‏‏‏‏‎‏‎‎‏‏‎‏‎‎‎‎‎‏‏‏‎‏‎‎‎‎‎‏‏‎‏‏‎‎‏‎‏‎‏‏‏‏‏‎‎Navigate up‎‏‎‎‏‎']");
    	By login = By.xpath("//android.widget.TextView[@text='Login']");
    	By email_field = By.id("com.sssports.sssports:id/et_email");
    	By pwd_field = By.id("com.sssports.sssports:id/et_password");
    	By signin_btn = By.id("com.sssports.sssports:id/btn_sign_in");
    	By account_title = By.xpath("//android.widget.TextView[@text='MY ACCOUNT']");
    	By language_btn = By.id("com.sssports.sssports:id/language_spinner");
    	By arabic_btn = By.className("android.widget.CheckedTextView");
    	By text_language = By.id("android:id/text1");
    	By text_class = By.className("android.widget.CheckedTextView");
    	By shop_category = By.id("com.sssports.sssports:id/tv_menu_item_label");
    	By shop_btn = By.xpath("//android.widget.TextView[@text='Shop Now']");
    	By shop_sale_btn = By.xpath("//android.widget.TextView[@text=\"SALE\"]");
    	By cross_btn = By.id("com.sssports.sssports:id/iv_close_pinch_to_zoom");
    	By apply_btn = By.id("com.sssports.sssports:id/btn_apply");
    	By filter_btn = By.id("com.sssports.sssports:id/ll_filter");
    	By filter_apply_btn = By.id("com.sssports.sssports:id/filter_name");
    	
    	
    	//ID Strings
    	
    	String filter_name_id = "com.sssports.sssports:id/filter_name";
    	String filter_color_btn_id = "com.sssports.sssports:id/filter_name";
    	
    	
    	//String cart_btn = "com.sssports.sssports:id/iv_bag";
    	//String menu_nvg = "android.widget.ImageButton";
    	//String men_btn = "com.sssports.sssports:id/image_view_category";
    	
    	/*===============================================================================*/
    	/**Local Variables*/
    	/*================================================================================*/
    	
    	int delay = 10;
    	String email = "mujtaba@werplay.com";
    	String pwd = "12345678";
    	String expected_string = "MY ACCOUNT";
    	String actual_string;
    	
    	
    	
    System.out.println("Inside Language Test");
    
   helper.InternetTest();
 
    System.out.println("Waited"+ delay+"Seconds ");	
    
    helper.find(side_menu).click();
    
   
    helper.find(shop_btn).click();
    
    helper.find(shop_sale_btn).click();
    
  
   helper.find(filter_btn).click();
   
   helper.GetElementWithText("filter_name_id", "Colour").click();
   
   helper.GetElementWithText("filter_color_id", "Black").click();
   
   helper.find(filter_apply_btn).click();

   //Find element using ClassName property
   
   WebElement cross_btn_elem = helper.find(cross_btn); 
   
   	if(Helper.elementIsPresent(cross_btn_elem)==true)
   		cross_btn_elem.click();
   // List <WebElement> shop_items = driver.findElements(shop_men_btn);
    
  
    //System.out.println(helper.find(text_language).getText());
  
   
 //   List <WebElement> links = driver.findElements(language_btn);
    
    //List <WebElement> category_items = driver.findElements(shop_category);
    
   // links.get(1).click();

  
 /*   
    for(WebElement link : links)
    {
    
    //String a=link.getAttribute("checked");
    //System.out.println("Check box is" + a);
    //link.click();
    System.out.println(link.getText());

    }*/
    
    //driver.findElements(language_btn);

    
  
    delays.staticDelay(delay);
	
    
    }
 

}
