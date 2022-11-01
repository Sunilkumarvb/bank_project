package autoprojectguru99;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Day9 {

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
	public void DiscountCoupon() throws InterruptedException {

		// step 1 gpo to mobile and add Iphone to the cart

		driver.findElement(By.xpath("//a[normalize-space()='Mobile']")).click();
		driver.findElement(By.xpath("//li[1]//div[1]//div[3]//button[1]//span[1]//span[1]")).click();
		Thread.sleep(2000);

		// step 2 enter the coupon code GURU50
		// before applying discount coupon
		String wdPrice = driver
				.findElement(By.xpath(".//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span")).getText();
		System.out.println("The Actual Price of the Iphone Before Discount is=" + wdPrice);
		// applying discpount coupon
		driver.findElement(By.id("coupon_code")).clear();
		driver.findElement(By.id("coupon_code")).sendKeys("GURU50");
		driver.findElement(By.xpath("//span[contains(text(),'Apply')]")).click();
		// after applying discount coupon
		String adPrice = driver
				.findElement(By.xpath(".//*[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span")).getText();

		if (wdPrice == adPrice) {
			System.out.println("***The Price not discounted by 5%***");

		} else {
			System.out.println("***The Price is discounted by 5%***");
		}
		System.out.println("The Grand Total After Discount is=" + adPrice);

	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
