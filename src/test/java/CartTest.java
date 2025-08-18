
import org.testng.annotations.Test;
import org.testng.Assert;


import pages.CartPage;

public class CartTest extends BaseTest {

	@Test

	public static void CartTest1() throws InterruptedException {

		/*
		 * WebDriver driver = new ChromeDriver(); driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 * 
		 * driver.get("https://demowebshop.tricentis.com/login");
		 */

		Thread.sleep(5000);

		CartPage cp = new CartPage(getDriver());
		cp.addcart("fiction");
		Thread.sleep(4000);

	}
}
