package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class FaceBookAccountCreation {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("//a[contains(text(),'Create new account')]")).click();
		driver.findElement(By.xpath("//form[@id='reg']//input[@name='firstname']")).sendKeys("Gomathy");
		driver.findElement(By.xpath("//form[@id='reg']//input[@name='lastname']")).sendKeys("Vasudevan");
		driver.findElement(By.xpath("//form[@id='reg']//input[@name='reg_email__']")).sendKeys("6472838634");
		driver.findElement(By.xpath("//form[@id='reg']//input[@id='password_step_input']")).sendKeys("Dummy123");

		WebElement day = driver.findElement(By.id("day"));
		Select dropone = new Select(day);
		dropone.selectByIndex(8);

		WebElement month = driver.findElement(By.id("month"));
		Select droptwo = new Select(month);
		droptwo.selectByVisibleText("Nov");

		WebElement year = driver.findElement(By.id("year"));
		Select dropthree = new Select(year);
		dropthree.selectByValue("1985");

		
		driver.findElement(By.xpath("//input[@type = 'radio']//preceding::label")).click();
		
		driver.findElement(By.xpath("//div[@id='reg_form_box']//button[@name='websubmit']")).click();
		
		driver.close();



	}



}
