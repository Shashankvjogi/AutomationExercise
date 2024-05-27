package exercise;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase6 {
    public static void main(String[] args) {
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
        driver.findElement(By.xpath("//a[text()=' Contact us']")).click();

        boolean verify = driver.findElement(By.xpath("//h2[text()='Get In Touch']")).isDisplayed();
        if (verify) {
            System.out.println("Get In Touch is Displayed");
        } else {
            System.out.println("Get In Touch is not Displayed");
        }

        driver.findElement(By.xpath("//input[@data-qa='name']")).sendKeys("test");
        driver.findElement(By.xpath("//input[@data-qa='email']")).sendKeys("test@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='subject']")).sendKeys("test");
        driver.findElement(By.xpath("//textarea[@data-qa='message']")).sendKeys("test");

        WebElement element = driver.findElement(By.xpath("//input[@name='upload_file']"));
        element.sendKeys("C:\\Users\\user-pc\\Downloads\\1.Responsibilities of scrum development team (1).png");

        driver.findElement(By.xpath("//input[@name='submit']")).click();

        Alert alert= driver.switchTo().alert();
        alert.accept();

        boolean verify2 = driver.findElement(By.xpath("//div[@class='status alert alert-success']")).isDisplayed();

        driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();

        String ExpectedTitle1 = "Automation Exercise";
        String ActualTitle1 = driver.getTitle();
        if(ExpectedTitle1.equalsIgnoreCase(ActualTitle1)){
            System.out.println("Home Page is Visible succesffuly");
        }
        else {
            System.out.println("Home Page is Not Visible");
        }








    }
}
