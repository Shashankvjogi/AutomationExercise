package exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase11 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://automationexercise.com");
        String ExpectedTitle = "Automation Exercise";
        String ActualTitle = driver.getTitle();
        if (ExpectedTitle.equalsIgnoreCase(ActualTitle)) {
            System.out.println("Home Page is Visible succesffuly");
        } else {
            System.out.println("Home Page is Not Visible");
        }
        driver.findElement(By.xpath("//a[text()=' Cart']")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,8500)", "");

        boolean verify = driver.findElement(By.xpath("//h2[text()='Subscription']")).isDisplayed();
        if(verify){
            System.out.println("Subscription is visible");
        }
        else {
            System.out.println("Subscription is not visible");
        }

        driver.findElement(By.xpath("//input[@id='susbscribe_email']")).sendKeys("test@gmail.com");
        driver.findElement(By.xpath("//button[@id='subscribe']")).click();

        boolean verify1 = driver.findElement(By.xpath(("//div[@class='alert-success alert']"))).isDisplayed();
        if(verify1){
            System.out.println("You have been successfully subscribed! is visible");
        }
        else {
            System.out.println("You have been successfully subscribed! is not visible");
        }
        driver.close();

    }
}
