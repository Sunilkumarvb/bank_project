package autoprojectguru99;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Day4 {

	WebDriver driver;

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
	public void CompareTwoProducts() throws InterruptedException {

		driver.findElement(By.xpath("//a[normalize-space()='Mobile']")).click();
		driver.findElement(By.xpath("//li[2]//div[1]//div[3]//ul[1]//li[2]//a[1]")).click();
		String mainMobile1 = driver.findElement(By.xpath("//h2/a[@title='IPhone']")).getText();
		System.out.println("mainMobile1 = " + mainMobile1);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[2]//div[1]//div[3]//ul[1]//li[2]//a[1]")).click();
		String mainMobile2 = driver.findElement(By.xpath("//h2/a[@title='Sony Xperia']")).getText();
		System.out.println("mainMobile2 = " + mainMobile2);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@title='Compare']//span//span[contains(text(),'Compare')]"));

		// switching to new window
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		// 5. Verify the pop-up window and check that the products are reflected in it
		// Heading "COMPARE PRODUCTS" with selected products in it.
		String strHead = ("COMPARE PRODUCTS");
		String compHead = driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div[1]/h1")).getText();
		System.out.println("compHead = " + compHead);
		String popupMobile1 = driver.findElement(By.xpath("//h2/a[@title='IPhone']")).getText(); // text captured is
																									// "IPHONE" in
																									// uppercase
		String popupMobile2 = driver.findElement(By.xpath("//h2/a[@title='Sony Xperia']")).getText(); // text captured
																										// "SONY XPERIA"
																										// in uppercase
		System.out.println("popupMobile1 = " + popupMobile1);
		System.out.println("popupMobile2 = " + popupMobile2);
		Thread.sleep(1000);
		// to check the popup heading/title
		try {
			assertEquals(strHead, compHead);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// to check the 2 mobiles selected are the two in the popup - this is tp check
		// the IPhone
		try {
			assertEquals(mainMobile1, popupMobile1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// to check the 2 mobiles selected are the two in the popup - this is to check
		// Sony X
		try {
			assertEquals(mainMobile2, popupMobile2);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 6. Close the Popup Windows
		driver.findElement(By.xpath("//button[@title='Close Window']")).click();

		// switching to new window
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
