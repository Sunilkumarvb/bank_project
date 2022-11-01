package autoprojectguru99;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PdfFile {

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
	public void pdfFileDownload() throws InterruptedException {
		// step 1 login
		driver.findElement(By.xpath("//span[@class='label'][normalize-space()='Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Log In']")).click();
		driver.findElement(By.id("email")).sendKeys("Ravi1@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Bhuvi@123");
		driver.findElement(By.xpath("//button[@id='send2']")).click();
		Thread.sleep(2000);

		// step 2 select my order
		driver.findElement(By.xpath("//a[normalize-space()='My Orders']")).click();
		// step 3 clcik on view order
		driver.findElement(By.xpath("//tr[@class='first odd']//a[contains(text(),'View Order')]")).click();
		// step 4 verify order is pending
		String Vorder = driver.findElement(By.xpath("//h1[normalize-space()='Order #100016912 - Pending']")).getText();
		String Torder = "ORDER #100016912 - PENDING";

		Assert.assertEquals(Torder, Vorder);
		System.out.println("Torder" + Vorder);

		// step 5 click on print order and save pdf
		driver.findElement(By.xpath("//a[normalize-space()='Print Order']")).click();

	}
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
