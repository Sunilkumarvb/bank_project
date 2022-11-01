package autoprojectguru99;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Day6 {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\UNIVERSAL\\Desktop\\SOFTWARE\\Selenium projects jars and drivers\\chromedriver_win32 106.0.5249.61\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://live.techpanda.org/index.php/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void purchaseproduct() throws InterruptedException {

		// step 1 click on my acc &login
		driver.findElement(By.xpath("//span[@class='label'][normalize-space()='Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Log In']")).click();
		driver.findElement(By.id("email")).sendKeys("Ravi1@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Bhuvi@123");
		driver.findElement(By.xpath("//button[@id='send2']")).click();
		Thread.sleep(2000);

		// Step 2 clicking on my wishlist & add to cart &click to checkout
		driver.findElement(By.xpath("//div[@class='block-content']//a[normalize-space()='My Wishlist']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Add to Cart')]")).click();
		//Thread.sleep(2000);
        driver.findElement(By.xpath("//ul[@class='checkout-types top']//li//button[@title='Proceed to Checkout']//span//span[contains(text(),'Proceed to Checkout')]")).click();
        
		// step 3 enter shiping info
		driver.findElement(By.id("billing:street1")).clear();
		driver.findElement(By.id("billing:street1")).sendKeys("ABC");
		driver.findElement(By.id("billing:city")).clear();
		driver.findElement(By.id("billing:city")).sendKeys("New York");
		Thread.sleep(2000);

		// Step 4 selecting from dropdown
		Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='billing:region_id']")));
		dropdown.selectByVisibleText("New York");
		
		driver.findElement(By.id("billing:postcode")).clear();
		driver.findElement(By.id("billing:postcode")).sendKeys("542896");

		Select dropdown1 = new Select(driver.findElement(By.xpath("//select[@id='billing:country_id']")));

		dropdown1.selectByVisibleText("United States");
		driver.findElement(By.id("billing:telephone")).clear();
		driver.findElement(By.id("billing:telephone")).sendKeys("12345678");

		driver.findElement(By.id("billing:use_for_shipping_yes")).click();
		// click on countinue
		driver.findElement(By.xpath("//button[@onclick='billing.save()']")).click();
				
		Thread.sleep(2000);
		String vflateRate = "$5.00";
		String flateRate = driver.findElement(By.xpath("//span[normalize-space()='$5.00']")).getText();
		System.out.println("flateRate" + flateRate);
		try {
			assertEquals(flateRate, vflateRate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@onclick='shippingMethod.save()']")).click();
		driver.findElement(By.xpath("//input[@id='p_method_checkmo']")).click();
		driver.findElement(By.xpath("//button[@onclick='payment.save()']//span//span[contains(text(),'Continue')]")).click(); 
	

		
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@title='Place Order']")).click();

		String vPorder = "YOUR ORDER HAS BEEN RECEIVED.";
		String Porder = driver.findElement(By.xpath("//h1[normalize-space()='Your order has been received.']"))
				.getText();
		System.out.println("Order is placed" + Porder);
		try {
			assertEquals(Porder, vPorder);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
		 // 16. Verify Oder is generated. Note the order number 
	    String orderNum = driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div/p[1]/a")).getText();	
	    System.out.println("*** Your order number for your record = " + orderNum);
	   
	  }  
////div[@class='main-container col1-layout']//p[1]
	

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
