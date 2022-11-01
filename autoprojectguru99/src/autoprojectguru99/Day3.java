package autoprojectguru99;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Day3 {
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
	public void ErrorVerification() {

		driver.findElement(By.xpath("//a[normalize-space()='Mobile']")).click();
		driver.findElement(By.cssSelector(
				"body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(2) > div:nth-child(4) > button:nth-child(1)"))
				.click();
		WebElement QtyBox = driver.findElement(By.xpath("//input[@title='Qty']"));
		QtyBox.clear();
		QtyBox.sendKeys("1000");
		driver.findElement(By.xpath("//button[@title='Update']")).click();

		String act_error = driver.findElement(By.cssSelector("li[class='error-msg'] ul li span")).getText();

		String exp_error = "Some of the products cannot be ordered in requested quantity.";
		if (act_error.equals(exp_error)) {
			System.out.println("ErrorVerification Test is Passed");
		} else {
			System.out.println("ErrorVerification Test is Failed");
		}

		driver.findElement(By.cssSelector("button[id='empty_cart_button'] span span")).click();
		String act_message = driver.findElement(By.cssSelector("div[class='page-title'] h1")).getText();
		String exp_message = "SHOPPING CART IS EMPTY";
		if (act_message.equals(exp_message)) {
			System.out.println("ErrorVerification Test is Passed");
		} else {
			System.out.println("ErrorVerification Test is Failed");
		}

		System.out.println("Day3 Test Script Passed");

	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
