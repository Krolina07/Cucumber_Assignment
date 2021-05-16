package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test1_Dashboard {
	WebDriver driver;
	@Before("@OrangeHRM")
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Given("^I am in OrangeHRP Application \"([^\"]*)\"$")
	public void i_am_in_OrangeHRP_Application(String arg1) throws Throwable {
		driver.get(arg1);
	}

	@When("^I enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enters_and(String arg1, String arg2) throws Throwable {
		driver.findElement(By.id("txtUsername")).sendKeys(arg1);
		driver.findElement(By.id("txtPassword")).sendKeys(arg2);
	}

	@When("^clicked on Login Button$")
	public void clicked_on_Login_Button() throws Throwable {
		driver.findElement(By.id("btnLogin")).click();
	}

	@Then("^Dashboard page is available$")
	public void dashboard_page_is_available() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div/div[1]/h1")));	
		
	}

	@Then("^click on Admin menu$")
	public void click_on_Admin_menu() throws Throwable {
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		
	}

}
