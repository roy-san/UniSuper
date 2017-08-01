package todotest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FillteringVisibleToDosByCompletedState {

	private WebDriver driver;
	private String baseUrl; 
	
	@Before
	public void setUp() throws Exception {
		
		
	/*NOTE : This following line is machine dependent where the code will run 
	and it needs to be set the property as per that machine, otherwise the test will NOT RUN currently it is in my local set up*/
		
		System.setProperty("webdriver.gecko.driver", "/Users//Deb-San//workspace2//geckodriver.exe");
		
		driver = new FirefoxDriver();
		baseUrl = "http://todomvc.com/";
		
		//Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@Test				
	public void FillteringVisibleToDosByCompletedStateTest() throws Exception {
		
		driver.get(baseUrl);
		driver.findElement(By.xpath("//a[@href='examples/angularjs']")).click();
		Thread.sleep(1500);
		
		//Adding one to do items
		driver.findElement(By.id("new-todo")).sendKeys("I have to do Shopping");
		driver.findElement(By.id("new-todo")).sendKeys(Keys.ENTER);
		Thread.sleep(1500);
		
		driver.findElement(By.id("new-todo")).sendKeys("I have to go for swimming");
		driver.findElement(By.id("new-todo")).sendKeys(Keys.ENTER);
		Thread.sleep(1500);
		
		driver.findElement(By.id("new-todo")).sendKeys("I have to do UniSuper Test");
		driver.findElement(By.id("new-todo")).sendKeys(Keys.ENTER);
		Thread.sleep(1500);
		
		driver.findElement(By.id("new-todo")).sendKeys("I have to sleep 8 hours");
		driver.findElement(By.id("new-todo")).sendKeys(Keys.ENTER);
		Thread.sleep(1500);
		
		//clicking checkboxes that are completed todo tasks
		driver.findElement(By.xpath("//ul[@id='todo-list']/li[1]/div/input")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//ul[@id='todo-list']/li[3]/div/input")).click();
		Thread.sleep(1500);
		
		//Filtering
		driver.findElement(By.xpath("//a[@href='#/completed']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//a[@href='#/active']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//a[@href='#/']")).click();
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}

