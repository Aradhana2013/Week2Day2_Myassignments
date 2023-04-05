package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HomeAssigment3 {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://acme-test.uipath.com/login");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("email")).sendKeys("kumar.testleaf@gmail.com");
		driver.findElement(By.id("password")).sendKeys("leaf@12");
		driver.findElement(By.xpath("//form[@method='POST']//button[@type='submit']")).click();
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//form[@id='logout-form']/following-sibling::li")).click();
		
		driver.close();
	}

}
