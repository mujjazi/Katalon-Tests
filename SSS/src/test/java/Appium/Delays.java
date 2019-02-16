package Appium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Delays extends AppiumDriverBase {
	
	public static void waitForObject(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		try {
      wait.until(ExpectedConditions.presenceOfElementLocated(locator));
     }
		catch(TimeoutException e){
      throw new NoSuchElementException(locator.toString());
		}
		
	}
	
	
	public void staticDelay(int delay){
		try {
			TimeUnit.SECONDS.sleep(delay);
		}
		catch(Exception e) {
			System.out.println("exception: " + e);
		}
	}

}
