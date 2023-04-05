package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EditLead {

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
		
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Gomathy");
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		
		
		String Ctitle = driver.getTitle();
		
		if(Ctitle.contains("View Lead")) {
			
			System.out.println("The title of the page is correct and is : "+Ctitle);
		}

		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("CTS");
		
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		
		WebElement comp = driver.findElement(By.id("viewLead_companyName_sp"));
		String company = comp.getText();
		
		if (company.contains("CTS")) {
			
			System.out.println("The company name is changed correctly and is : "+company);
			
		}
		else
			System.out.println("The company name is not changed correctly");
		
		driver.quit();
		
	}

}
