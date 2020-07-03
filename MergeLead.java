package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeLead {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		 WebElement eleUsername = driver.findElementById("username");
		 eleUsername.sendKeys("Demosalesmanager");
		 WebElement elePassword = driver.findElementById("password");
		 elePassword.sendKeys("crmsfa");
		 driver.findElementByClassName("decorativeSubmit").click();
		 driver.findElementByLinkText("CRM/SFA").click();
		 driver.findElementByXPath("//a[text()='Contacts']").click();
		 driver.findElementByXPath("//a[text()='Merge Contacts']").click();
		 driver.findElementByXPath("(//img[@alt='Lookup'])[1]").click();
		 //(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]
			Set<String> allWindowRef=driver.getWindowHandles();
			List<String> list = new ArrayList<String>(allWindowRef);
			driver.switchTo().window(list.get(1));
			driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]").click();
			driver.switchTo().window(list.get(0));
			driver.findElementByXPath("(//img[@alt='Lookup'])[2]").click();
			Set<String> allWindowRef1=driver.getWindowHandles();
			List<String> list1 = new ArrayList<String>(allWindowRef1);
			driver.switchTo().window(list1.get(1));
			driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]").click();
			driver.switchTo().window(list.get(0));
			driver.findElementByXPath("//a[@class='buttonDangerous']").click();
			Alert alert=driver.switchTo().alert();
			//System.out.println(alert.getText());
			alert.accept();
			String currentWindow =driver.getTitle();
           System.out.println(currentWindow);


			
				


	}

}
