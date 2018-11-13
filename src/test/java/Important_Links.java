import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class Important_Links {
    @Test
    public void suite() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Priyanka Raha\\Drivers\\chromedriver.exe");
        WebDriver driver1 = new ChromeDriver();
        driver1.get("http://newers-world.qa2.tothenew.net/");
        driver1.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver1.findElement(By.name("username")).sendKeys("rohit.ojha@tothenew.com");
        driver1.findElement(By.name("password")).sendKeys("newer@123");
        driver1.findElement(By.xpath("//*[text()='Login']")).click();
        driver1.findElement(By.linkText("Important Links")).click();
        String actualTitle = driver1.findElement(By.xpath("//*[@id='page-wrapper']//h2")).getText();
        String expectedTitle = "Important Links";
        assertEquals(actualTitle, expectedTitle);
        System.out.println("Title is: " + actualTitle);
        String winHandleBefore = driver1.getWindowHandle();
        List<WebElement> elements = driver1.findElements(By.className("file-name"));
        System.out.println(elements.size());
        for (int i=0;i<elements.size();i++) {
                JavascriptExecutor jse = (JavascriptExecutor) driver1;
                jse.executeScript("window.scrollBy(0,200)");
                System.out.println(elements.get(i).getText());
                elements.get(i).click();
                for (String winHandle : driver1.getWindowHandles()) {
                    driver1.switchTo().window(winHandle);
                }
                System.out.println("URL: " + driver1.getCurrentUrl());
                System.out.println("Title is: " + driver1.getTitle());
                driver1.close();
                driver1.switchTo().window(winHandleBefore);
            }
        }
    }