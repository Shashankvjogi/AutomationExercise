package exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase7 {
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

        driver.findElement(By.xpath("//a[text()=' Test Cases']")).click();

        String ExpectedTitle1 = "Automation Practice Website for UI Testing - Test Cases";
        String ActualTitle1 = driver.getTitle();

        if(ExpectedTitle1.equalsIgnoreCase(ActualTitle1)){
            System.out.println("Page is landed in test case page");
        }
        else {
            System.out.println("Page is not landed in test case page");
        }

     driver.close();
    }
}
