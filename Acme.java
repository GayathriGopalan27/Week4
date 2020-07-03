package week4.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Acme {
	public static void main(String[] args) {
		

		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://acme-test.uipath.com/account/login");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com", Keys.TAB);
		driver.findElementById("password").sendKeys("leaf@12");
        driver.findElementById("buttonLogin").click();
		 Actions builder= new Actions(driver);
		 WebElement Vendor=driver.findElementByXPath("//button[text()=' Vendors']");
		 WebElement SearchVendor=driver.findElementByXPath("//a[text()='Search for Vendor']");
		 builder.moveToElement(Vendor).moveToElement(SearchVendor).click().perform();
		 
		 WebElement VendorName=driver.findElementById("vendorName");
		 WebElement Search = driver.findElementById("buttonSearch");
		 builder.click(VendorName).sendKeys("Blue Lagoon").click(Search).perform();
		 WebElement eleTable = driver.findElementByXPath("//table");
		 List<WebElement> allrows= eleTable.findElements(By.tagName("tr"));
		 WebElement eachrow=allrows.get(1);
		 List<WebElement> allCols=eachrow.findElements(By.tagName("td"));
		 WebElement eachrowHead=allrows.get(0);
		 List<WebElement> allHead=eachrowHead.findElements(By.tagName("th"));
			 for (int j = 0; j < allCols.size(); j++) {
					WebElement cell=allCols.get(j);
					WebElement Head=allHead.get(j);
					if(Head.getText().equalsIgnoreCase("Country")) {
						System.out.println("Country Name" +cell.getText());
					}
				     }
				WebElement LogOut=driver.findElementByXPath("//a[text()='Log Out']");
				builder.click(LogOut).perform();
				
				driver.close();
            				 
			}

}

