/*
@Author Roy Santanu
*/

package todotest;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class EditingAnExistingToDoItem {
    private WebDriver driver;
    private String baseUrl;
     //JavascriptExecuter jse;
    
    @Before
    public void setUp() throws Exception {   
    	
    	//I have used chrome driver here as Firefox gecko driver has a bug as it it not double clicking
    	
    	System.setProperty("webdriver.gecko.driver", "/Users//Deb-San//workspace2//geckodriver.exe");
        
        driver = new ChromeDriver();
        baseUrl = "http://todomvc.com/";
         
        //Maximize the browser's window
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void EditingAnExistingToDoItemTest() throws Exception {
    
        
        driver.get(baseUrl);
        driver.findElement(By.xpath("//a[@href='examples/angularjs']")).click();
        Thread.sleep(1500);
        
        // Adding to do item
        driver.findElement(By.id("new-todo")).sendKeys("I have to do shopping");
        Thread.sleep(1500);
        driver.findElement(By.id("new-todo")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        WebElement ele = driver.findElement(By.xpath("//ul[@id='todo-list']/li[1]/div/label"));
        
        // Generating double click
        Actions action = new Actions(driver);
        //Test print msg
       // System.out.println("Double click starting");
        
        action.doubleClick(ele).perform();
        
       //Test Print msg
        //System.out.println("Double click done");
        Thread.sleep(1500);
        
        // After double click, the element changes to an <input> tag
        WebElement editElement = driver.findElement(By.xpath("//ul[@id='todo-list']/li[1]/form/input"));
        editElement.clear();
        editElement.sendKeys("I have finished shopping now I will cook");
        Thread.sleep(1500);
        editElement.sendKeys(Keys.ENTER);
    }
    @After
    public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
    	
    }
}