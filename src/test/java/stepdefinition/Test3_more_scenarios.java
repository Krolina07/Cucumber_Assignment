package stepdefinition;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

public class Test3_more_scenarios {
	WebDriver driver;
	Date d = new Date();
	
@Before("@TestSuite1")
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

@Given("^on home page of application \"([^\"]*)\"$")
public void on_home_page_of_application(String arg1) throws Throwable {
    driver.get(arg1);
}

@When("^I enter credentials \"([^\"]*)\" and \"([^\"]*)\"$")
public void i_enter_credentials_and(String arg1, String arg2) throws Throwable {
	driver.findElement(By.id("txtUsername")).sendKeys(arg1);
	driver.findElement(By.id("txtPassword")).sendKeys(arg2);
}

@Then("^I should be successfully log in$")
public void i_should_be_successfully_log_in() throws Throwable {
	driver.findElement(By.id("btnLogin")).click();
}
@When("^I click on Directory tab$")
public void i_click_on_Directory_tab() throws Throwable {
	driver.findElement(By.xpath("//*[@id=\"menu_directory_viewDirectory\"]/b")).click();
}
@When("^Search By Name$")
public void search_By_Name() throws Throwable {
	driver.findElement(By.id("searchDirectory_emp_name_empName")).sendKeys("Linda");
	driver.findElement(By.id("searchBtn")).click();
}
@Then("^I should be able to read employee details$")
public void i_should_be_able_to_read_employee_details() throws Throwable {
	WebDriverWait wait = new WebDriverWait(driver, 3);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[2]")));	
}
@When("^I move to JOb Grade under Admin Tab$")
public void i_move_to_JOb_Grade_under_Admin_Tab() throws Throwable {
	Actions act = new Actions(driver);		
	act.moveToElement(driver.findElement(By.id("menu_admin_viewAdminModule"))).moveToElement(driver.findElement(By.id("menu_admin_Job")))
	.moveToElement(driver.findElement(By.id("menu_admin_viewPayGrades")))
	.build().perform();
	act.click().perform();
}
@Then("^I should be able to read Grade info$")
public void i_should_be_able_to_read_Grade_info() throws Throwable {
	WebDriverWait wait = new WebDriverWait(driver, 3);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"search-results\"]/div[1]/h1")));
}
@When("^I move to My Info$")
public void i_move_to_My_Info() throws Throwable {
	driver.findElement(By.id("menu_pim_viewMyDetails")).click();
}
@Then("^I should be able to read your info$")
public void i_should_be_able_to_read_your_info() throws Throwable {
	WebDriverWait wait = new WebDriverWait(driver, 3);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pdMainContainer\"]/div[1]/h1")));
}
@When("^I move to Buzz$")
public void i_move_to_Buzz() throws Throwable {
	driver.findElement(By.id("menu_buzz_viewBuzz")).click();
}
@Then("^I should be able to tipe on Update Status$")
public void i_should_be_able_to_tipe_on_Update_Status() throws Throwable {
	driver.findElement(By.id("createPost_content")).sendKeys("This is a test");
	
}

@After("@Directory,@JobGrades, @MyInfo,@Buzz")
public void tear() throws IOException {
	String FileName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
	File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(screenshot, new File("screenshots\\cucumber_" + FileName));
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
@After("@TestSuite1")
public void browser() throws IOException {
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.close();
}
}
