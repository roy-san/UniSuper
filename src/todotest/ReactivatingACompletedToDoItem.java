package todotest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ReactivatingACompletedToDoItem {

	private WebDriver driver;
	private String baseUrl; 
	
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "/Users//Deb-San//workspace2//geckodriver.exe");
		
		driver = new FirefoxDriver();
		baseUrl = "http://todomvc.com/";
		
		//Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test				
	public void ReactivatingACompletedToDoItemTest() throws Exception {
		
		driver.get(baseUrl);
		driver.findElement(By.xpath("//a[@href='examples/angularjs']")).click();
		Thread.sleep(1500);
		
		//Adding one to do item
		driver.findElement(By.id("new-todo")).sendKeys("I have to do Shopping");
		Thread.sleep(1500);
		driver.findElement(By.id("new-todo")).sendKeys(Keys.ENTER);
		Thread.sleep(1500);
		
		//Completing the todo item
		driver.findElement(By.id("toggle-all")).click();
		Thread.sleep(2000);
		
		//Re-activating the todo item
		driver.findElement(By.id("toggle-all")).click();
		
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}

