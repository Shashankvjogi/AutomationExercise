package exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase3 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://automationexercise.com");

        String ExpectedTitle = "Automation Exercise";
        String ActualTitle = driver.getTitle();
        if(ExpectedTitle.equalsIgnoreCase(ActualTitle)){
            System.out.println("Home Page is Visible succesffuly");
        }
        else {
            System.out.println("Home Page is Not Visible");
        }

        driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();

        boolean verify = driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed();
        if(verify){
            System.out.println("Login to your account is Displayed");
        }
        else {
            System.out.println("Login to your account is not Displayed");
        }

        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("incorrect@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("incorrect");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        boolean verify3 = driver.findElement(By.xpath("//p[text()='Your email or password is incorrect!']")).isDisplayed();
        if(verify3){
            System.out.println("Your email or password is incorrect! is Displayed");
        }
        else {
            System.out.println("Your email or password is incorrect! is not Displayed");
        }

        driver.close();
    }
}
