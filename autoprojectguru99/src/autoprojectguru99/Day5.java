package autoprojectguru99;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Day5 {
	WebDriver driver;
	public String firstName = "SUNILKUMAR"; // Firstname and Lastname will be placed
	public String lastName = "BHUVIN"; // in a TestData EXCEL file at some stage
	// public String emailid ="automatione@gmail.com";
	// public String passward ="Bhuvi@7411";

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\UNIVERSAL\\Desktop\\SOFTWARE\\ChromedriverLatest  v105\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://live.techpanda.org/index.php/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void AccountCreation() throws InterruptedException {

		// click on account
		driver.findElement(By.xpath("//span[@class='label'][normalize-space()='Account']")).click();
		Thread.sleep(2000);

		// click on My Account link
		driver.findElement(By.cssSelector("div[id='header-account'] a[title='My Account']")).click();
		Thread.sleep(2000);
		// switching to new window
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		// click on create an account
		driver.findElement(By.xpath("//span[contains(text(),'Create an Account')]")).click();
		Thread.sleep(2000);
		// switching to new window
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		// fill all details
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("firstname")).sendKeys("SUNILKUMAR");
		driver.findElement(By.id("lastname")).clear();
		driver.findElement(By.id("lastname")).sendKeys("BHUVIN");
		driver.findElement(By.id("email_address")).clear();
		driver.findElement(By.id("email_address")).sendKeys("poojag74@gmail.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("Bhuvi@7411");
		driver.findElement(By.id("confirmation")).clear();
		driver.findElement(By.id("confirmation")).sendKeys("Bhuvi@7411");
		// click on register
		driver.findElement(By.xpath("//span[contains(text(),'Register')]")).click();
		System.out.println("Account Created Successfully");
		Thread.sleep(2000);
		// switching to new window
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		// verify registration done
		// 5. Verify Registration is done. Expected account registration done.
		String vWelcome = ("WELCOME, " + firstName + " " + lastName + "!");
		String tWelcome = driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[1]/div/p")).getText();
		System.out.println("tWelcome = " + tWelcome);

		try {
			assertEquals(tWelcome, vWelcome);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 6. Go to TV menu
		driver.findElement(By.xpath(".//*[@id='nav']/ol/li[2]/a")).click(); 
		Thread.sleep(2000);
		// switching to new window
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		// 7. Add product in your wish list - use product - LG LCD
		driver.findElement(By.xpath("//li/a[@class='link-wishlist']")).click();

		Thread.sleep(2000);

		// switching to new window
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		// 8. Click SHARE WISHLIST
		driver.findElement(By.xpath("//button[@title='Share Wishlist']")).click();

		Thread.sleep(2000);

		// switching to new window
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		// 9. In next page enter Email and a message and click SHARE WISHLIST
		driver.findElement(By.id("email_address")).clear();
		driver.findElement(By.id("email_address")).sendKeys("poojag74@gmail.com");
		driver.findElement(By.id("message")).clear();
		driver.findElement(By.id("message"))
				.sendKeys("Hey pooja check this tv I am sending this message from automation script.");

		driver.findElement(By.xpath("//button[@title='Share Wishlist']")).click();
		// the above click will still be in the same page as prior page, so no need take
		// another handle to another window

		Thread.sleep(2000);

		// 10. Check wishlist is shared. Expected wishlist shared successfully.
		String vWishList = "Your Wishlist has been shared.";
		String wishList = driver
				.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div/div[1]/ul/li/ul/li/span"))
				.getText();
		System.out.println("wishList = " + wishList);
		try {
			assertEquals(vWishList, wishList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Thread.sleep(2000);
		System.out.println("Day 5th completed");
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
