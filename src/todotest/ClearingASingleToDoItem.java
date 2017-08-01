package todotest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class ClearingASingleToDoItem {

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
	public void ClearingASingleToDoItemTest() throws Exception {
		
		driver.get(baseUrl);
		driver.findElement(By.xpath("//a[@href='examples/angularjs']")).click();
		Thread.sleep(1500);
		
		//Adding to do item
		driver.findElement(By.id("new-todo")).sendKeys("I have to do Shopping");
		driver.findElement(By.id("new-todo")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
			
		WebElement mouseHoverelement = driver.findElement(By.xpath("//ul[@id='todo-list']/li[1]/div/label"));
		WebElement removeItemElement = driver.findElement(By.className("destroy"));
		
		// Mouse Hovering start
		Actions action = new Actions(driver);
		
		//System.out.println("Mouse hover starting");
		action.moveToElement(mouseHoverelement).perform();
		
		//System.out.println("Mouse hover done");
		Thread.sleep(1500);
		
		//Removing item
		removeItemElement.click();
		Thread.sleep(2000);
	}	
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
		
	}		
}

