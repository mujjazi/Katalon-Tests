package Appium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.javascript.host.Console;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;


public class Helper extends AppiumDriverBase {
	
	/*===============================================================================*/
	/**Utility/Helper Classes Objects*/
	/*================================================================================*/
	
	Delays delays = new Delays();
	
	/**------------------------------------------------------------------------------------------------------------------**/
	/* Method used to click on the element based on the locator passed and this ensures only elements loaded are clicked
	/**-------------------------------------------------------------------------------------------------------------------**/
	

	public WebElement find(By locator) {
		Delays.waitForObject(locator);		
		WebElement element = driver.findElement(locator);
		return element;
	}
	

	
	/*public void sendtext(String text) {
	
		try {
		    // textElement.click();  
		     new ProcessBuilder(new String[]{"adb", "-s", "ce03171393a1262201", "shell", "input", "text", text})
		       .redirectErrorStream(true)
		       .start();
		} catch (IOException e) {
		   e.printStackTrace();
		}
	}*/
	
	
	
	
	/**------------------------------------------------------------------------------------------------------------------**/
	/* Method used to return the element based on resource ID and text string which can be used to click on them
	/**-------------------------------------------------------------------------------------------------------------------**/
	
	
	public WebElement GetElementWithText(String id, String text) {
		
		String text1 = text;
		String locator1 = id;
		List <MobileElement> products;
		MobileElement temp= null;
		
	   products =  driver.findElements(By.id(locator1));
	   try{
		   if(products.size()<=0) {
			  
		   } 
	     }
	    
	     catch(Exception e){
	        System.out.println("Warning: Some Other exception");
	     }
	   
	   	for(MobileElement element : products) {
	   		if(element.getAttribute("text").equals(text1)) {
	   			temp=element;
	   			System.out.println(element.getText()); 
	   			break;
		}
	}
	   	return temp;
	}
	
	/**-------------------------------------------------------------------------------------------------------------**/
	/* Method used to check the presence of elements and returns true if element is present otherwise returns false
	/**------------------------------------------------------------------------------------------------------------**/
	
	
	public static boolean elementIsPresent(WebElement element) {
	    try {
	        element.isDisplayed();
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	        System.out.println("Exception thrown: " + e);
	    	return false;
	        
	    }

	    return true;
	}
	
	
	/**---------------------------------------------------------------------------------------------------------------------------------------------------**/
	/* Method used to click on certain elements where there is a need to traverse through lists - Clicks on the element whose xpath and text is provided */
	/**----------------------------------------------------------------------------------------------------------------------------------------------------**/
	public static void clickLists(String xpath, String text) {
		
		List<MobileElement> list; //Creating a list which will store the elements found using the search criteria
		
		list = driver.findElements(By.xpath(xpath)); //Getting all the elements for the given xpath
		

		//Iterating using a For-each loop over the elements in list and click on element with text passed through function
		//There is a flaw in this method which I will implement later that this fails for text with white-spaces
		for (WebElement el : list) {
		try {
			if (el.getText().equalsIgnoreCase(text)) {
		     el.click();
		     break;
		   }
		}
		catch (StaleElementReferenceException elementHasDisappeared) { //This is required since an element may become stale due an AJAX call rendering the element stale
	       System.out.println("Stale element reference" + el);
	       list.clear(); //Clearing the list to remove that element from the list
	      }
		
		}
		
		return;
		
	}
	
	public boolean isOnline() {
	    try {
	        int timeoutMs = 1500;
	        Socket sock = new Socket();
	        SocketAddress sockaddr = new InetSocketAddress("8.8.8.8", 53);

	        sock.connect(sockaddr, timeoutMs);
	        sock.close();

	        return true;
	    } catch (IOException e) { return false; }
	}
	
	public void InternetTest() {
		if (isOnline()==false){
	    	
	    	System.out.println("Application can not launch because of no internet, quitting application in 10 seconds");
	    	delays.staticDelay(10);
	    	driver.quit();
	    	
	    }
	}
	
	public static void AdbRun() throws IOException {
		
		String currentUsersHomeDir = System.getProperty("user.home");
		String cmd = "adb devices";
		final Process exec = Runtime.getRuntime().exec("cd " + currentUsersHomeDir  + "Desktop/android/platform-tools/" + cmd);
		//final Process exec1 = Runtime.getRuntime().exec("adb devices");

        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));

        String s;
        while((s = bufferedReader.readLine()) != null) {
            System.out.println(s);
        }
		
	}

	
	//assertTrue(driver.isAppInstalled("com.sssports.sssports"));
	

}
