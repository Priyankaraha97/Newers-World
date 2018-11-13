package com.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestCasesforAssignment {
    WebDriver driver=null;
    @BeforeSuite
    void suitemethod (){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Shivani\\Downloads\\chromedriver_win32\\chromedriver.exe");
driver=new ChromeDriver();

    }
    @Test
    void suitemethod1() throws InterruptedException{
        driver.get("https://www.google.com/url?q=http://newers-world.qa2.tothenew.net");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("http://newers-world.qa2.tothenew.net")).click();
        driver.findElement(By.name("username")).sendKeys("sunil.tripathy@tothenew.com");
        driver.findElement(By.name("password")).sendKeys("newer@123\n");
        driver.findElement(By.xpath("//*[@title='Org Chart']")).click();
        driver.findElement(By.id("org-search")).sendKeys("shanky.kalra");
        Thread.sleep(2000 );
        driver.findElement(By.xpath("//*[@id='searchElement']/ul/li/a")).click();



       //Thread.sleep(2000);
        driver.findElement(By.id("org-search")).sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        driver.findElement(By.id("zoomInBtn")).click();
        driver.findElement(By.id("zoomInBtn")).click();
        driver.findElement(By.id("zoomInBtn")).click();
        Thread.sleep(4000);
        driver.findElement(By.id("zoomOutBtn")).click();
        driver.findElement(By.id("zoomOutBtn")).click();
        driver.findElement(By.id("zoomOutBtn")).click();
        driver.findElement(By.xpath("//*[@id='page-wrapper']/div[1]/nav/div/a/i")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id='page-wrapper']/div[1]/nav/div/a/i")).click();
        // driver.findElement(By.xpath("//*[@href='/logout']")).click(); */
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@href='/logout']")).click();
       // driver.quit();


    }

}
