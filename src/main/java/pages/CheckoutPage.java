package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

	
	private WebDriver driver;

	public CheckoutPage (WebDriver driver) {

		this.driver = driver;
	}
	
	By terms=By.name("termsofservice");
	By checkout=By.id("checkout");
	
	public void checkout() throws InterruptedException {
		Thread.sleep(5000);
		// driver.findElement(terms).click();
		Thread.sleep(5000);
		driver.findElement(checkout).click();
	}
}
