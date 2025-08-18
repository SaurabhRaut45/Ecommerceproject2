package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;

public class CartPage {

	private WebDriver driver;

	public CartPage(WebDriver driver) {

		this.driver = driver;
	}

	By books = By.linkText("Books");
	By searchstore = By.id("small-searchterms");
	By searchbtn = By.cssSelector("input[class='button-1 search-box-button']");
	By addtocart = By.cssSelector("input[value='Add to cart']");
	By shoppingcart = By.linkText("Shopping cart");
	By productname = By.className("product-name");

	public void addcart(String search) {

		driver.findElement(books).click();
		driver.findElement(searchstore).sendKeys(search);
		driver.findElement(searchbtn).click();
		driver.findElement(addtocart).click();
		driver.findElement(shoppingcart).click();
		String product= driver.findElement(productname).getText();
		System.out.println("Product name: "+ product);
		//Assert.assertTrue(product.equalsIgnoreCase(search), "Product does not contain the search keyword");
		//System.out.println("Test Passed");

	}

}
