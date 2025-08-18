package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	By loginbtn = By.linkText("Log in");
	By email = By.id("Email");
	By pwd = By.id("Password");
	By loginclick = By.cssSelector("input.button-1.login-button");

	public void Login() {

		driver.findElement(loginbtn).click();
		driver.findElement(email).sendKeys("sr12@gmail.com");
		driver.findElement(pwd).sendKeys("pass123");
		driver.findElement(loginclick).click();
		
	}

}
