import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyRequest {
    @Test
    public void suite() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/java/Files/chromedriver.exe");
        WebDriver driver1 = new ChromeDriver();
        driver1.manage().window().maximize();
        driver1.get("http://newers-world.qa2.tothenew.net/");
        driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver1.findElement(By.name("username")).sendKeys("sunil.tripathy@tothenew.com");
        driver1.findElement(By.name("password")).sendKeys("newer@123");
        driver1.findElement(By.xpath("//*[text()='Login']")).click();
        driver1.findElement(By.linkText("Attendance")).click();
        JavascriptExecutor jse = (JavascriptExecutor) driver1;
        jse.executeScript("window.scrollBy(0,1400)");
        Thread.sleep(5000);
        WebElement data = driver1.findElement(By.name("myRequestTable_length"));
        Select select1 = new Select(data);
        select1.selectByVisibleText("50");
        //for sorting data
        List<WebElement> sorting = driver1.findElements(By.xpath("//*[@id=\"myRequestTable\"]/thead/tr/th"));
        for (int j = 0; j < sorting.size(); j++) {
            System.out.println("Sorting is done Using: " +sorting.get(j).getText());
            sorting.get(j).click();
        }
        driver1.findElement(By.xpath("//*[@type='search']")).click();
        driver1.findElement(By.xpath("//*[@type='search']")).sendKeys("Extra Working");
        driver1.findElement(By.xpath("//*[@id=\"myRequestTable_next\"]/a")).click();
        //For Navigating through pages using previous,next buttons
        List<WebElement> elements = driver1.findElements(By.xpath("//*[@id=\"myRequestTable_paginate\"]//a"));
        for (int i = 0; i < elements.size(); i++) {
            jse.executeScript("window.scrollBy(0,200)");
            System.out.println("Element clicked: " +elements.get(i).getText());
            elements.get(i).click();
        }
        jse.executeScript("window.scrollBy(0,-200)");
        driver1.findElement(By.xpath("//*[@id=\"requestTab\"]//div//i")).click();
    }
}