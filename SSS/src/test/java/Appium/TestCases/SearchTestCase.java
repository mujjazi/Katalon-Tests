package Appium.TestCases;

 
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Appium.AppiumDriverBase;
import Appium.Delays;
import Appium.Helper;
import io.appium.java_client.MobileElement;
 
public class SearchTestCase extends AppiumDriverBase{
 
    //Test Annotation is used to tell TestNG that this is not just a void function rather its a test case 
    @Test
    public void SearchTest(){
    	
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
    	By shopping_bag = By.id("com.sssports.sssports:id/iv_bag");
    	By action_btn = By.id("com.sssports.sssports:id/action_button");
    	By side_menu = By.xpath("//android.widget.ImageButton[@content-desc='‎‏‎‎‎‎‎‏‎‏‏‏‎‎‎‎‎‏‎‎‏‎‎‎‎‏‏‏‏‏‎‏‏‎‏‏‎‎‎‎‏‏‏‏‏‏‏‎‏‏‏‏‏‎‏‎‎‏‏‎‏‎‎‎‎‎‏‏‏‎‏‎‎‎‎‎‏‏‎‏‏‎‎‏‎‏‎‏‏‏‏‏‎‎Navigate up‎‏‎‎‏‎']");
    	By login = By.xpath("//android.widget.TextView[@text='Login']");
    	By products = By.id("com.sssports.sssports:id/ll_product");
    	By shop_all_btn = By.xpath("//android.widget.Button[@text='SHOP ALL']");
    	By product = By.id("com.sssports.sssports:id/image_view_product");
    	By grid_switch = By.id("com.sssports.sssports:id/iv_list_grid_switch");
    	By product1 = By.id("com.sssports.sssports:id/text_view_product_name");
    	By sort = By.id("com.sssports.sssports:id/text_sort_name");
    	
    	//String cart_btn = "com.sssports.sssports:id/iv_bag";
    	//String menu_nvg = "android.widget.ImageButton";
    	//String men_btn = "com.sssports.sssports:id/image_view_category";
    	
    	int delay = 10;
    	
    System.out.println("Inside Search Test");	
   
    //delays.staticDelay(delay);
 
  //  System.out.println("Waited"+ delay+"Seconds ");	

    	
    //Click on search button
  //  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.sssports.sssports:id/action_search")));
 //   helper.find(search_btn).click();
 
    
  //  WebElement srch = helper.find(search_field);
//    srch.sendKeys("Nike Grippers");

    helper.find(shop_all_btn).click();
    
    delays.staticDelay(delay);
    
 //   helper.find(sort).click();
   // helper.find(sort).click();
    //helper.find(grid_switch).click();
    //helper.find(product1).click();
    
   List <WebElement> product_list = driver.findElements(By.className("com.sssports.sssports:id/image_view_product"));
   
 //  for (int i=0;i<=product_list.size();i++) {
	   
   String val = ((MobileElement) product_list.get(0)).getText();
	System.out.println(val);  

    
    }
 
}
