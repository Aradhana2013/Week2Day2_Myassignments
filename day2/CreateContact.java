package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class CreateContact {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		ChromeDriver driver = new ChromeDriver(options);

		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();

		driver.findElement(By.id("username")).sendKeys("demoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Gomathy");
		driver.findElement(By.id("lastNameField")).sendKeys("Vasudevan");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Goma");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Vasu");
		driver.findElement(By.name("departmentName")).sendKeys("HR");
		driver.findElement(By.id("createContactForm_description")).sendKeys("NIL");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("abc@gmail.com");


		WebElement province = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select dropone = new Select(province);
		dropone.selectByVisibleText("New York");

		driver.findElement(By.className("smallSubmit")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("NOTES");
		driver.findElement(By.xpath("//form[@id = 'updateContactForm']//input[@value = 'Update']")).click();

		if(driver.getTitle().contains("View Contact")) {
			System.out.println("Test Case Passed");
		}
		else
			System.out.println("Test Case Failed");

		driver.quit();


	}

}
