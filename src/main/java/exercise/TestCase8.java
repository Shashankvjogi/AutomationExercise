package exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase8 {
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
        driver.findElement(By.xpath("//a[text()='View Product']")).click();

        String ExpectedTitle2 = "Automation Exercise - Product Details";
        String ActualTitle2 = driver.getTitle();

        if(ExpectedTitle2.equalsIgnoreCase(ActualTitle2)){
            System.out.println("Page is landed in Product Details page");
        }
        else {
            System.out.println("Page is not landed in Product Details page");
        }

        boolean verifyProduct = driver.findElement(By.xpath("//div[@class='product-information']//child::h2[starts-with(text(),'')]")).isDisplayed();
        if(verifyProduct){
            System.out.println("Name of the product is displayed");
        }
        else {
            System.out.println("Name of the product is not displayed");
        }
        boolean verifyPrice = driver.findElement(By.xpath("//div[@class='product-information']//child::span[starts-with(text(),'Rs.')]")).isDisplayed();
        if(verifyPrice){
            System.out.println("Price of the product is displayed");
        }
        else {
            System.out.println("Price of the product is not displayed");
        }

        boolean verifyCategory = driver.findElement(By.xpath("//div[@class='product-information']//child::p[starts-with(text(),'Category:')]")).isDisplayed();
        if(verifyCategory){
            System.out.println("Category of the product is displayed");
        }
        else {
            System.out.println("Category of the product is not displayed");
        }

        boolean verifyAvailability = driver.findElement(By.xpath("//div[@class='product-information']//child::p[starts-with(text(),' ')]//child::b[text()='Availability:']")).isDisplayed();
        if(verifyAvailability){
            System.out.println("Availability of the product is displayed");
        }
        else {
            System.out.println("Availability of the product is not displayed");
        }

        boolean verifyCondition = driver.findElement(By.xpath("//div[@class='product-information']//child::p[starts-with(text(),' ')]//child::b[text()='Condition:']")).isDisplayed();
        if(verifyCondition){
            System.out.println("Condition of the product is displayed");
        }
        else {
            System.out.println("Condition of the product is not displayed");
        }

        boolean verifyBrand = driver.findElement(By.xpath(" //div[@class='product-information']//child::p[starts-with(text(),' ')]//child::b[text()='Brand:']")).isDisplayed();
        if(verifyBrand){
            System.out.println("Brand of the product is displayed");
        }
        else {
            System.out.println("Brand of the product is not displayed");
        }

        driver.close();


    }
}
