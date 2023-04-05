package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DuplicateLead {

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
		driver.findElement(By.xpath("//ul[@class='x-tab-strip x-tab-strip-top']/li[3]")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("goms91186@gmail.com");
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(4000);
		
		
		WebElement nam = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a"));
		String name = nam.getText();
		System.out.println("Name of first record in search result is : "+name);
		
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a")).click();
		
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		
		WebElement Ctitle = driver.findElement(By.xpath("//div[@id='sectionHeaderTitle_leads']"));
		String title = Ctitle.getText();
		
		if(title.contains("Duplicate Lead")) {
			System.out.println("Title of the page is correct and is : "+title);
		}
		
		
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		
		
		WebElement DLN = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']"));
		String DupL = DLN.getText();
		
		if (DupL.equals(name)) {
			
			System.out.println("Duplicated lead name is same as captured name");
			
		}
		else
			System.out.println("Duplicated lead name is not same as captured name");
		
		
		driver.quit();
		
	}

}
