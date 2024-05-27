package exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class TestCase9 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://automationexercise.com");
        String ExpectedTitle = "Automation Exercise";
        String ActualTitle = driver.getTitle();
        if(ExpectedTitle.equalsIgnoreCase(ActualTitle)){
            System.out.println("Home Page is Visible");
        }
        else {
            System.out.println("Home Page is Not Visible");
        }

        driver.findElement(By.xpath("//a[text()=' Products']")).click();

        String ExpectedTitle1 = "Automation Exercise - All Products";
        String ActualTitle1 = driver.getTitle();

        if(ExpectedTitle1.equalsIgnoreCase(ActualTitle1)){
            System.out.println("Page is landed in All products page");
        }
        else {
            System.out.println("Page is not landed in All products page");
        }

        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("shirt");
        driver.findElement(By.xpath("//button[@id='submit_search']")).click();

        boolean verifySP = driver.findElement(By.xpath("//h2[text()='Searched Products']")).isDisplayed();
        if(verifySP){
            System.out.println("Searched Products is displayed");
        }
        else {
            System.out.println("Searched Products is not displayed");
        }

        List<WebElement> elements1 = driver.findElements(By.xpath("//div[@class='single-products']"));
        List<WebElement> elements2 = driver.findElements(By.xpath("//div[@class='productinfo text-center']//child::p[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'shirt')]"));
        int count1 = elements1.size();
        int count2 = elements2.size();
System.out.println(count1+ "and"+ count2);
        if(count1==count2){
            System.out.println("All the products related to search are visible");
        }
        else {
            System.out.println("Products related to search are not visible");
        }

        driver.close();

    }
}
