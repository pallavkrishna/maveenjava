package sample.testng.examples;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {

	
	
	public WebDriver getWebDriver() {
		
		WebDriverManager.chromedriver().setup();
		
		return new ChromeDriver();
		
	}



	@Test(dataProvider = "dataProvider")
	public void test(String url, String arg1, String arg2) throws InterruptedException {
		WebDriver driver=getWebDriver();
		
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		System.out.println("driver.getTitle()" + driver.getTitle() + " arg1 :" + arg1 + " arg2 :" + arg2);
		SessionId sessionid = ((RemoteWebDriver) driver).getSessionId();
		System.out.println(sessionid.toString());
		closeDriver(driver);


		
	}
	
	public void closeDriver(WebDriver driver1) {
		SessionId sessionid = ((RemoteWebDriver) driver1).getSessionId();
		System.out.println(sessionid.toString());
		driver1.close();
		driver1.quit();
		
	}
	
	@DataProvider(parallel = true)
	public String[][] dataProvider() {

		return new String[][] { { "https://github.com/", "alex", "India" },
				{ "https://jenkins.io/download/", "Krishna", "UK" },
				{ "https://www.facebook.com/", "Bhupesh", "USA" } };
	}
}
