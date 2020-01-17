package com.testng.javasample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {
	
	@Test()
	public void test() throws InterruptedException
	{
		/*String path="C:\\Users\\Naveen Nani\\Downloads\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		*/
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		Thread.sleep(1000);
		System.out.print("driver.getTitle()"+driver.getTitle());
	}

}
