package Excel.TestData;

import org.testng.annotations.Test;

import Utility.ExcelUtils;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class DataProviderWithExcel {
	
	private static WebDriver driver;
  
  @BeforeMethod
  public void beforeMethod() {
//	  System.setProperty("webdriver.chrome.driver", "Resources//chromedriver.exe");
//		driver = new ChromeDriver();

//	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//		driver.get("http://shop.demoqa.com/wp-login.php");
  }
  
  @Test(dataProvider = "Authentication")
  public void f(String tcName, String sUserName, String sPassword) {
//	  driver.findElement(By.xpath(".//*[@id='account']/a")).click();

      // Argument passed will be used here as String Variable

//	driver.findElement(By.id("log")).sendKeys(sUserName);
	  System.out.println(tcName);
	System.out.println(sUserName);
//	driver.findElement(By.id("pwd")).sendKeys(sPassword);
	System.out.println(sPassword);
	
//	driver.findElement(By.id("login")).click();
	
//	driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();
	
  }
  
  @DataProvider

  public static Object[][] Authentication() {
	  ExcelUtils excelUtl;
	try {
		excelUtl = new ExcelUtils("TestData\\Testdata.xlsx");	
	  //Object[][] testObjArray = new Object[][] { { "testuser_1", "Test@123" }, { "testuser_1", "Test@123" }};
	  Object[][] testObjArray = excelUtl.getDataArray("Sheet1");
	  return testObjArray;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
  }

  /*@DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }*/
  
  @AfterMethod
  public void afterMethod() {
	  //driver.quit();
//	  driver.close();
  }
}
