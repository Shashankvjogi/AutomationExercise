package exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase13 {
    public static void main(String[] args) {
        String quantity="4";
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
        driver.findElement(By.xpath("//a[text()='View Product']")).click();

        boolean verifyPD = driver.findElement(By.xpath("//div[@class='product-details']")).isDisplayed();
        if(verifyPD){
            System.out.println("Product details is visible");
        }else {
            System.out.println("Product details is Not Visible");
        }
        String product = driver.findElement(By.xpath("//div[@class='product-information']/h2")).getText();
        WebElement element = driver.findElement(By.xpath("//input[@name='quantity']"));
        element.clear();
        element.sendKeys(quantity);
        driver.findElement(By.xpath("//button[@class='btn btn-default cart']")).click();
        driver.findElement(By.xpath("//u[text()='View Cart']")).click();

        String product_name = driver.findElement(By.xpath("//tr[@id='product-1']//child::h4")).getText();
        if(product.equalsIgnoreCase(product_name)){
            System.out.println("Product is displayed in cart");
        }else {
            System.out.println("Product is Not displayed in cart");
        }
        String verifyQuantity = driver.findElement(By.xpath("//td[@class='cart_quantity']//child::button")).getText();
        if(verifyQuantity.equalsIgnoreCase(quantity)){
            System.out.println("Exact product quantity is displayed in cart");
        }else {
            System.out.println("Exact product quantity is Not displayed in cart");
        }

//        driver.close();
    }
}
