package TargetExcel.Data;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Targethomepage {
	WebDriver d;

	@FindBy(xpath = "//a[@id='account' and @href='#accountMenu']")
	public WebElement signin;

	@FindBy(xpath = "//a[@id='account' and @href='#accountMenu']/following::li[contains(@id,'accountNav-createAccount')]")
	public WebElement creataccount;
	
	@FindBy(xpath="//input[@type='email']")
	public WebElement email;
	
	
	public void launchApp(WebDriver driver) {

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.target.com/");
	}

	public void openpage() {
		Actions action = new Actions(d);
		action.moveToElement(creataccount).build().perform();
		creataccount.click();

	}

	public Targethomepage(WebDriver driver) {
		d = driver;
		PageFactory.initElements(driver, this);

	}

}
