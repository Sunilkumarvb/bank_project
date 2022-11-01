package autoprojectguru99;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class verifyMobile {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\UNIVERSAL\\Desktop\\SOFTWARE\\ChromedriverLatest  v105\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://clicks.aweber.com/y/ct/?l=GgPQY&m=mcNYuYFeLUQLjy9&b=h5T4l2fu1DOGeQSqXkdkzQ");
		String act_text = driver.findElement(By.cssSelector("h2:nth-child(1)")).getText();
        String exp_text="THIS IS DEMO SITE FOR";
        Assert.assertEquals(act_text, exp_text);
		System.out.println(act_text);

	}

}
