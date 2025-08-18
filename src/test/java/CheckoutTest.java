import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pages.CheckoutPage;

public class CheckoutTest extends BaseTest {

	@Test

	public void checkouttest() throws InterruptedException {

		/*
		 * WebDriver driver = new ChromeDriver(); driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 * 
		 * driver.get("https://demowebshop.tricentis.com/login");
		 */

		// WebDriver driver = null;

		Thread.sleep(5000);
		CheckoutPage cp = new CheckoutPage(getDriver());
		Thread.sleep(5000);

		cp.checkout();

	}

}
