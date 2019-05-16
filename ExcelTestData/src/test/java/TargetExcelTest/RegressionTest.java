package TargetExcelTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import TargetExcel.Data.Targethomepage;

public class RegressionTest {

	WebDriver driver;

	@BeforeSuite
	public void soumya() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "Resources//chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void test12() throws Exception {
		Targethomepage homepage = new Targethomepage(driver);
		homepage.launchApp(driver);

		Thread.sleep(2000);
		Reporter.log("Target page opened ");

		homepage.signin.click();

		Thread.sleep(3000);
		homepage.creataccount.click();
		Thread.sleep(3000);

		
		driver.findElement(By.xpath("//input[@type='email' and @id = 'username'])")).sendKeys("test1");
		

		driver.findElement(By.xpath("//input[@id='firstname'])")).sendKeys("sniffy");
	
		
		driver.findElement(By.xpath("//input[@id='lastname'])")).sendKeys("potti");
	
		driver.findElement(By.xpath("//input[@id='password'])")).sendKeys("tippo");
	
		//driver.findElement(By.xpath("//div[@id='alertMessage']")).click();

	

	}

	@AfterSuite
	public void teardown() {
		driver.close();
		Reporter.log("Target Page is closed");

	}

}
