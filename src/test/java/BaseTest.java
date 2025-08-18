import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	public static final String USERNAME = "saurabhraut7028";
	public static final String ACCESS_KEY = "LT_BrrDEVZNUXsLHFvORIj3DFYZJKtvONwHEm7K5elFGE6DdeY";
	public static final String GRID_URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@hub.lambdatest.com/wd/hub";

	@Parameters({ "browser", "version", "platform" })
	@BeforeMethod
	public void setUp(String browser, String version, String platform) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", browser);
		capabilities.setCapability("browserVersion", version);

		Map<String, Object> ltOptions = new HashMap<>();
		ltOptions.put("platformName", platform);
		ltOptions.put("project", "Selenium TestNG Demo");
		ltOptions.put("build", "Ecoomerce LambdaTest Integration");
		ltOptions.put("name", "Test on " + browser + "-" + version);

		capabilities.setCapability("LT:Options", ltOptions);

		driver.set(new RemoteWebDriver(URI.create(GRID_URL).toURL(), capabilities));
		getDriver().get("https://demowebshop.tricentis.com/login");
	}

	public static WebDriver getDriver() {
		return driver.get();

	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
		driver.remove();
	}
}
