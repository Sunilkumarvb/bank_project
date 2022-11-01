package autoprojectguru99;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Day1 {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\UNIVERSAL\\Desktop\\SOFTWARE\\ChromedriverLatest  v105\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://clicks.aweber.com/y/ct/?l=GgPQY&m=mcNYuYFeLUQLjy9&b=h5T4l2fu1DOGeQSqXkdkzQ");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@Test
	public void verify() throws IOException {
		String demosite = driver.findElement(By.cssSelector("h2")).getText();
		System.out.println(demosite);
		Assert.assertEquals("THIS IS DEMO SITE FOR   ", demosite);

		driver.findElement(By.xpath("//a[normalize-space()='Mobile']")).click();
		System.out.println(driver.getTitle());
		Select dropdown = new Select(driver.findElement(By.xpath("(//select[@title='Sort By'])[1]")));
		dropdown.selectByVisibleText("Name");

		TakesScreenshot ts = (TakesScreenshot) driver;

		File srcFile = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(srcFile, new File("C:\\Users\\UNIVERSAL\\Desktop\\Gurucode\\Screenshots\\img.png"));

	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
