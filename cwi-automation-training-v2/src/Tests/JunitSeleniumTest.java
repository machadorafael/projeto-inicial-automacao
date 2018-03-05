package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class JunitSeleniumTest {

	WebDriver driver;
	private WebElement search_query_top;
	private WebElement submit_search;
	
	@Before
	public void before() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com");
		PageFactory.initElements(driver, this);
	}
	
	@Test
	public void realizarPesquisa() {
		search_query_top.sendKeys("Dress");
		submit_search.click();
	}
	
	@Test
	public void acessarMenu() {
		
	}
	
	@After
	public void after() {
		driver.quit();
	}

}