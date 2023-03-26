package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_01_setup_Enviroment {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
		@BeforeClass
		public void beforeClass() {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("https://www.facebook.com/");
		}
		@Test
		public void TC_01_ValidateCurrentUrl() {
			String LoginPageUrl = driver.getCurrentUrl();
			Assert.assertEquals(LoginPageUrl, "https://www.facebook.com/");
		}
		
		@Test
		public void TC_02_ValidatePageTitle() {
			String loginPageTitle = driver.getTitle();
			Assert.assertEquals(loginPageTitle, "Facebook – log in or sign up");
		}
		
		@Test
		public void TC_03_LoginFormDisplayed() {
			Assert.assertTrue(driver.findElement(By.xpath("//form[@data-testid='royal_login_form']")).isDisplayed());
			
		}
		
		@AfterClass
		public void afterClass() {
			driver.quit();
		}
}
