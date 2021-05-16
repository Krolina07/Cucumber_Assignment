package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test2_Job {
	WebDriver driver;
	
	@Before("@OrangeHRM")
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Given("^I am in application \"([^\"]*)\"$")
	public void i_am_in_OrangeHRP_Application(String arg1) throws Throwable {
		driver.get(arg1);
	}

	@When("^I add \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enters_and(String arg1, String arg2) throws Throwable {
		driver.findElement(By.id("txtUsername")).sendKeys(arg1);
		driver.findElement(By.id("txtPassword")).sendKeys(arg2);
	}

	@When("^select on Login Button$")
	public void select_on_Login_Button() throws Throwable {
		driver.findElement(By.id("btnLogin")).click();
	}
	@Given("^when I click on Admin Link$")
	public void when_I_click_on_Admin_Link() throws Throwable {
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
	}

	@Then("^Click on Job$")
	public void click_on_Job() throws Throwable {
		Actions act = new Actions(driver);		
		act.moveToElement(driver.findElement(By.id("menu_admin_Job"))).moveToElement(driver.findElement(By.id("menu_admin_viewJobTitleList")))
		.build().perform();
		act.click().perform();
	}
	@Then("^validate text of Job Title$")
	public void validate_text_of_Job_Title() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"search-results\"]/div[1]/h1")));	
		String Ds = driver.findElement(By.xpath("//*[@id=\"search-results\"]/div[1]/h1")).getText();
		Assert.assertEquals(Ds,"Job Titles");
	}
	@After("@OrangeHRM")
	public void tear() {
		driver.close();
	}
}
