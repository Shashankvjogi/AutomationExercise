package exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase5 {
    public static void main(String[] args) {
        String username = "testing11234";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://automationexercise.com");

        String ExpectedTitle = "Automation Exercise";
        String ActualTitle = driver.getTitle();
        if (ExpectedTitle.equalsIgnoreCase(ActualTitle)) {
            System.out.println("Home Page is Visible");
        } else {
            System.out.println("Home Page is Not Visible");
        }

        driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();

        boolean verify = driver.findElement(By.xpath("//h2[text()='New User Signup!']")).isDisplayed();
        if (verify) {
            System.out.println("New User Signup! is Displayed");
        } else {
            System.out.println("New User Signup! is not Displayed");
        }

        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("testing11234");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("testing11234@gmail.com");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        boolean verify1 = driver.findElement(By.xpath("//p[text()='Email Address already exist!']")).isDisplayed();
        if (verify1) {
            System.out.println("Email Address already exist! is Displayed");
        } else {
            System.out.println("Email Address already exist! is not Displayed");
        }

        driver.close();
    }
}
