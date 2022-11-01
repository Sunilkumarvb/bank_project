package autoprojectguru99;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Day8 {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\UNIVERSAL\\Desktop\\SOFTWARE\\ChromeDriver_LateestV106\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://live.techpanda.org/index.php/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void ReOrder() throws InterruptedException {
		// step 1 login
		driver.findElement(By.xpath("//span[@class='label'][normalize-space()='Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Log In']")).click();
		driver.findElement(By.id("email")).sendKeys("Ravi1@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Bhuvi@123");
		driver.findElement(By.xpath("//button[@id='send2']")).click();
		Thread.sleep(2000);
		// step 2 select my order
		driver.findElement(By.xpath("//a[normalize-space()='My Orders']")).click();
		System.out.println("###Beefore Reorder###");

		// step 3 click on reorder link & update qty
		driver.findElement(By.xpath("//tr[@class='first odd']//a[@class='link-reorder'][normalize-space()='Reorder']"))
				.click();
		System.out.println("##After Reorder##");

		String Vprice = driver.findElement(By.xpath(".//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span"))
				.getText();      //".//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span"

		driver.findElement(By.xpath("//input[@title='Qty']")).clear();
		driver.findElement(By.xpath("//input[@title='Qty']")).sendKeys("10");
		driver.findElement(By.xpath("//button[@title='Update']//span//span[contains(text(),'Update')]")).click();
		System.out.println("##cart is updated##");

		// step 4 verify grand total is changed
		String GrandTotal = driver
				.findElement(By.xpath(".//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span")).getText();
		System.out.println("GrandTotal=" + GrandTotal);

		//Step 5 verify the before and after Grand Total price, to confirm it has changed
		if (Vprice == GrandTotal) {
			System.out.println("*** Grand Total price has not changed. ***");
		} else {
			System.out.println("*** Grand Total price has changed. ***");
		}

		// step 6 complete the billing shipping information
		driver.findElement(By.xpath(
				"//li[@class='method-checkout-cart-methods-onepage-bottom']//button[@title='Proceed to Checkout']"))
				.click();
		driver.findElement(By.xpath("//button[@onclick='billing.save()']//span//span[contains(text(),'Continue')]"))
				.click();
		driver.findElement(By.xpath("//button[@onclick='shippingMethod.save()']")).click();
		driver.findElement(By.xpath("//input[@id='p_method_checkmo']")).click();
		driver.findElement(By.xpath("//button[@onclick='payment.save()']//span//span[contains(text(),'Continue')]"))
				.click();
		driver.findElement(By.xpath("//button[@title='Place Order']")).click();

		// Step 7 verify order generated and order no generated
		String OrderNum = driver.findElement(By.xpath("//div[@class='main-container col1-layout']//p[1]")).getText();
		System.out.println("###Your New order number for Reorder is=" + OrderNum);

	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
