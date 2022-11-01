package autoprojectguru99;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Day10 {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\UNIVERSAL\\Desktop\\SOFTWARE\\Selenium projects jars and drivers\\chromedriver_win32 106.0.5249.61\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://live.techpanda.org/index.php/backendlogin");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void Emails() throws InterruptedException {
		// step 1 click on backend acc &login
		
		driver.findElement(By.id("username")).sendKeys("user01");
		driver.findElement(By.id("login")).sendKeys("guru99com");
		driver.findElement(By.xpath("//input[@title='Login']")).click();
		Thread.sleep(2000);
		
		//step 2 close alert
		driver.findElement(By.xpath("//span[normalize-space()='close']")).click();
		
		//step 3 select sales and orders 
		driver.findElement(By.xpath("//span[normalize-space()='Sales']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Orders']")).click();
		
		//step 4 select to cvs in export dropdown and clcick on export 
		Select dropdown=new Select(driver.findElement(By.xpath("//select[@id='sales_order_grid_export']")));
		dropdown.selectByVisibleText("CSV");
		driver.findElement(By.xpath("//span[contains(text(),'Export')]")).click();
		
		
		

	}

}
