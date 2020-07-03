package week4.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/table.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement eleTable = driver.findElement(By.id("table_id"));
		List<WebElement> allrows= eleTable.findElements(By.tagName("tr"));
		System.out.println(" No of Rows size  " +allrows.size());
		WebElement eachrow=allrows.get(1);
		 List<WebElement> allColl=eachrow.findElements(By.tagName("td"));
		 System.out.println("Column SIze " +allColl.size());
		 List<Integer> list1  = new ArrayList<Integer>();
		 for (int k =1;k<allrows.size();k++)
		 	{
			 WebElement eachRow= allrows.get(k);
			 List<WebElement> allCols=eachRow.findElements(By.tagName("td"));
			 String test = allCols.get(0).getText();
			 	if (test.equalsIgnoreCase("Learn to interact with Elements"))
			 	{
			 		System.out.println("progress  "+allCols.get(1).getText());
			 	}
			 	String s1= allCols.get(1).getText();
			 	//System.out.println(s1);
			 	String s2 = s1.substring(0, s1.length()-1);
			 	//  System.out.println(s2);
			 	int num = Integer.parseInt(s2);
			 	list1.add(num);
   
		 	}
	    Collections.sort(list1);
		Integer min=Collections.min(list1);
		//System.out.println(min);
		for (int j =1;j<allrows.size();j++)
		 {
		 	WebElement eachR= allrows.get(j);
	        List<WebElement> allCLm=eachR.findElements(By.tagName("td"));
		    // System.out.println(allCols.get(0).getText());
		     String test = allCLm.get(1).getText();
		    // System.out.println(test);
		     int test2 =Integer.parseInt(test.substring(0, test.length()-1));
		     //System.out.println(test2);
		     // System.out.println(min);
		     if (test2==min)
		     {
		      driver.findElementByXPath("//td[contains(text(),'"+min+"')]/following-sibling::td/input").click();
			}
	
	    }
   }
}