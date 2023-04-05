package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		ChromeDriver driver = new ChromeDriver(options);

		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.id("username")).sendKeys("demoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//ul[@class='x-tab-strip x-tab-strip-top']/li[2]")).click();
		driver.findElement(By.xpath("//input[@name='phoneAreaCode']")).sendKeys("647");
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9642013");
		driver.findElement(By.xpath("//div[@id='findLeads']//button")).click();
		
		Thread.sleep(4000);		
		
		
		WebElement record = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		String num = record.getText();
		System.out.println("The first record in search result is : "+ num);
		
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//div[@class='x-form-element']/input)[13]")).sendKeys(num);
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		WebElement msg = driver.findElement(By.xpath("//div[text()='No records to display']"));
		String message = msg.getText();
		System.out.println(message);
		
		if (message.contains("No records")) {
			
			System.out.println("Deletion was successful");
			
		}
		else
			System.out.println("Deletion was not successful");
	
		
		driver.quit();
		

	}

}
