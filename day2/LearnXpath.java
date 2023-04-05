package week2.day2;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LearnXpath {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		ChromeDriver driver = new ChromeDriver(options);

		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demoSalesManager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Create Lead']")).click();
		driver.findElement(By.xpath("(//input[@name='companyName'])[2]")).sendKeys("TCS");
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Gomathy");
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("Vasudevan");
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();



		driver.close();



	}

}
