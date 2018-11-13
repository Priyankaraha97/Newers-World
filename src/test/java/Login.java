import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Login {
    @Test
    public void suite() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Priyanka Raha\\Drivers\\chromedriver.exe");
        WebDriver driver1 = new ChromeDriver();
        driver1.manage().window().maximize();
        driver1.get("http://newers-world.qa2.tothenew.net/");
        driver1.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver1.findElement(By.name("username")).sendKeys("rohit.ojha@tothenew.com");
        driver1.findElement(By.name("password")).sendKeys("newer@123");
        driver1.findElement(By.xpath("//*[text()='Login']")).click();
        driver1.findElement(By.linkText("Attendance")).click();
        JavascriptExecutor jse = (JavascriptExecutor) driver1;
        jse.executeScript("window.scrollBy(0,500)");
//        WebDriverWait wait=new WebDriverWait(driver1,5000);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='form-control m-b']")));
        Thread.sleep(5000);
        WebElement drop = driver1.findElement(By.xpath("//*[@class='form-control m-b']"));
        Select select = new Select(drop);
        select.selectByVisibleText("Extra Working");
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("startDate")));
        Thread.sleep(5000);
        driver1.findElement(By.id("startDate")).click();
        driver1.findElement(By.xpath("//div[8]//tr[5]/td[7]")).click();
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='btn btn-sm btn-primary submitTimeType']")));
        Thread.sleep(5000);
        driver1.findElement(By.xpath("//*[@class='btn btn-sm btn-primary submitTimeType']")).click();
        WebDriverWait wait=new WebDriverWait(driver1,100);
        driver1.close();

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Priyanka Raha\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://newers-world.qa2.tothenew.net/");
        driver.findElement(By.name("username")).sendKeys("sunil.tripathy@tothenew.com");
        driver.findElement(By.name("password")).sendKeys("newer@123");
        driver.findElement(By.xpath("//*[text()='Login']")).click();
        driver.findElement(By.linkText("Approve")).click();
        driver.findElement(By.xpath("//*[a='Attendance']")).click();
        driver.findElement(By.xpath("//*[@class='iCheck-helper']")).click();
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='approveButton']")));
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='approveButton']")).click();
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("DataTables_Table_0_length")));
        Thread.sleep(5000);
        WebElement data = driver.findElement(By.name("DataTables_Table_0_length"));
        Select select1 = new Select(data);
        select1.selectByVisibleText("100");
        driver.findElement(By.xpath("//*[@type='search']")).click();
        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("Rahul Khurana");
        List<WebElement> elements = driver.findElements(By.xpath("//*[@aria-controls='DataTables_Table_0']//span"));
        Iterator<WebElement> itr = elements.iterator();
        while (itr.hasNext()) {
            itr.next().click();
                  }
        driver.close();
    }
}