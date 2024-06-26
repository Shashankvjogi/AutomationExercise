package exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase4 {
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

        boolean verify = driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed();
        if (verify) {
            System.out.println("Login to your account is Displayed");
        } else {
            System.out.println("Login to your account is not Displayed");
        }

        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("testing11234@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("testing");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        boolean verify3 = driver.findElement(By.xpath("//a[text()=' Logged in as ']//child::b[text()='" + username + "']")).isDisplayed();
        if (verify3) {
            System.out.println("Logged in as username is Displayed");
        } else {
            System.out.println("Logged in as username is not Displayed");

        }
        driver.findElement(By.xpath("//a[text()=' Logout']")).click();

        boolean verify1 = driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed();
        if(verify1){
            System.out.println("Login to your account is Displayed");
        }
        else {
            System.out.println("Login to your account is not Displayed");
        }
        driver.close();
    }
}
