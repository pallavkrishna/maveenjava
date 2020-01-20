package com.testng.javasample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {
	
	WebDriver driver=null;
	
	@BeforeTest
	
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		
		
	}
	
	@Test(/*dataProvider="dataProvider"*/)
	public void test() throws InterruptedException
	{
		
		driver.get("https://www.google.com/");
		Thread.sleep(1000);
		System.out.print("driver.getTitle()"+driver.getTitle());
	}
	@AfterTest
	public void afterTest() {
		
		driver.close();
		driver.quit();
		
	}
	/*@DataProvider
	public Object [][] dataProvider(){
		Object obj =new Object();
		return (Object[][]) obj;
	}*/

}
