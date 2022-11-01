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

public class Day2 {
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
	public void verifymobilevalue() {
		//clcik on mobile 
		driver.findElement(By.xpath("//a[normalize-space()='Mobile']")).click();
		//Storing the price of mobile in Xperia 
		String XPeriaPrice = driver.findElement(By.xpath("//span[@id='product-price-1']//span")).getText();
        //clicking on the Xperia mobile image 
		driver.findElement(By.id("product-collection-image-1")).click();
       //storing the price of mobile from detail page
		String detailPrice = driver.findElement(By.xpath("//span[@id='product-price-1']//span")).getText();
       //comapring the price
		try {
			assertEquals(XPeriaPrice, detailPrice);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// if (MobilepriceinList.equals(Mobilepricedetailpage)) {
	// System.out.println("The Test is passed:The Mobile price in List and detail
	// page is $100");

	// } else {
	// System.out.println("The Test is failed:The Mobile price in the List and
	// detail page is not $100");
	// }

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
