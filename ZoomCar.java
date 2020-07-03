package week4.day2;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomCar {
	public static void main(String[] args) throws InterruptedException {
			

			System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://www.zoomcar.com/chennai");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.findElementByXPath("//a[text()='Start your wonderful journey']").click();
			driver.findElementByXPath("//div[@class='component-popular-locations']//div[2]").click();
			driver.findElementByXPath("//button[text()='Next']").click();
			Thread.sleep(3000);
			driver.findElementByXPath("//div[@class='days']//div[2]").click();
			driver.findElementByXPath("//button[text()='Next']").click();
			driver.findElementByXPath("//div[@class='days']//div[2]").click();
			driver.findElementByXPath("//button[text()='Done']").click();
	          List<WebElement> elements = driver.findElementsByXPath("//div[@class='car-item']");
	      		Map<String,Integer> map = new LinkedHashMap<String,Integer>();
		          List<WebElement> CarName = driver.findElementsByXPath("//div[@class='details']//h3");
		          List<WebElement> Price = driver.findElementsByXPath("//div[@class='price']");


	          for(int i =0; i<elements.size(); i++)

	          {

	        	 String st= CarName.get(i).getText().trim();
	        	 String CarPrice =Price.get(i).getText();
	        	 CarPrice.trim();
	        	// System.out.println(price);
                   int amount = Integer.parseInt(CarPrice.replaceAll("[^\\d]", ""));
                   map.put(st, amount);
                                     
          }
	          int max =Collections.max(map.values());

	          Set<Entry<String, Integer>> entrySet = map.entrySet();
              for (Entry<String, Integer> eachentry : entrySet) {
            	  
            if (eachentry.getValue()==max)
            {
           	   	 System.out.println(" Max amount car   " +eachentry.getKey()+ " ->" +eachentry.getValue());
           	  driver.findElementByXPath("//h3[contains(text(),'" + eachentry.getKey()+ "')]/parent::div/following-sibling::div//div//button").click();
           	   	 
           			
           		}

			

              }

driver.close();
	}

}
