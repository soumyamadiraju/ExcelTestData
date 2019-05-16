package TargetExcel.Data;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.ExcelUtils;

public class TargerDataproviderutilpage {
	private static WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "Resources//chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.target.com/");
	}

	@Test(dataProvider = "UserRegistration")
	public void test(String email, String firstname, String lastname, String password)
			throws InterruptedException {
//		System.setProperty("webdriver.chrome.driver", "Resources//chromedriver.exe");
//		driver = new ChromeDriver();
//
//		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		//System.out.println(email + firstname + lastname + phonenum + password);
//
//		driver.get("https://www.target.com/");
        
		driver.findElement(By.xpath("//a[@id='account' and @href='#accountMenu']"))
				.click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(
				"//a[@id='account' and @href='#accountMenu']/following::li[contains(@id,'accountNav-createAccount')]"))
				.click();
                          Thread.sleep(2000);
		// Argument passed will be used here as String Variable
/*
		driver.findElement(By.xpath("//input[@type='email'])")).sendKeys(email);
		
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='firstname'])")).sendKeys(firstname);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='lastname'])")).sendKeys(lastname);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='password'])")).sendKeys(password);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@id='alertMessage']")).click();

		Thread.sleep(2000);


*/	}

	@DataProvider(name = "UserRegistration")
	public static Object[][] UserRegistration() {
		ExcelUtils excelUtl;
		try {
			excelUtl = new ExcelUtils("TestData\\sheet2.xlsx");
			Object[][] testObjArray = excelUtl.getDataArray("Sheet1");

			return testObjArray;
		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;
	}
	
	 @AfterMethod
	  public void afterMethod()   {
		 
		 
		  driver.quit();
	  }

}
