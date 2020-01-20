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
	
	@Test(dataProvider="dataProvider")
	public void test(String url,String arg1,String arg2) throws InterruptedException
	{
		
		driver.get(url);
		Thread.sleep(1000);
		System.out.println("driver.getTitle()"+driver.getTitle()+"arg1 :"+arg1+"arg2 :"+arg2);
	}
	@AfterTest
	public void afterTest() {
		
		driver.close();
		driver.quit();
		
	}
	@DataProvider
	public String [][] dataProvider(){
		
		return new String[][] 
    	{
            { "https://github.com/pallavkrishna/maveenjava","Guru99", "India" },
            { "https://jenkins.io/download/","Krishna", "UK" },
            { "https://www.guru99.com/","Bhupesh", "USA" }
        };
	}

}
