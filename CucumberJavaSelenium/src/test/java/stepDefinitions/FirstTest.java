package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.*;

public class FirstTest {
	
	WebDriver driver = null;
	
	@Given("browser is open")
	public void browser_is_open() {
		
		System.out.println("Inside Step-browser is open");
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is :: "+projectPath);
		System.setProperty("webdriver.gecko.drive",projectPath+"/src/test/resources/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(35,TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Given("user is on google search page")
	public void user_is_on_google_search_page() {
		
	driver.get("https://www.google.com/");

	}

	@When("user enters a text in google search box")
	public void user_enters_a_text_in_google_search_box() {
	driver.findElement(By.name("q")).sendKeys("India VIX Index");

	}

	@When("hits Enter")
	public void hits_enter() {
	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	@Then("user is navigated to the search results page")
	public void user_is_navigated_to_the_search_results_page() throws InterruptedException {
//		driver.quit();
		driver.getPageSource().contains("Nifty VIX");
		Thread.sleep(3000);
		driver.close();

	}

}
