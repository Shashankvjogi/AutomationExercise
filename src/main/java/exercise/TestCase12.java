package exercise;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestCase12 {
    public static void main(String[] args) throws InterruptedException {

            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();

            driver.get("https://automationexercise.com/");
            String homepage = "https://automationexercise.com/";
            String actualurl = driver.getCurrentUrl();
            if (homepage.equalsIgnoreCase(actualurl)) {
                System.out.println("Home Page is Visible");
            } else {
                System.out.println("Home Page is Not Visible");
            }

            WebElement element = driver.findElement(By.xpath("//div[@class='productinfo text-center']"));
            String firstProduct = driver.findElement(By.xpath("//a[@data-product-id='1']/ancestor::div[@class='productinfo text-center']/child::p")).getText();
            Actions actions =new Actions(driver);
            actions.moveToElement(element).build().perform();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//div[@class='product-overlay']//child::a[@class='btn btn-default add-to-cart']")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block' ]")).click();

            String secondProduct = driver.findElement(By.xpath("//a[@data-product-id='2']/ancestor::div[@class='productinfo text-center']/child::p")).getText();
            WebElement element1 = driver.findElement(By.xpath("//a[@data-product-id='2']/ancestor::div[@class='productinfo text-center']"));
            actions.moveToElement(element1).build().perform();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//div[@class='overlay-content']/child::a[@data-product-id='2']")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//u[text()='View Cart']")).click();

            String verifyFirstProduct = driver.findElement(By.xpath("//tr[@id='product-1']/child::td[@class='cart_description']/child::h4")).getText();
            if(verifyFirstProduct.equalsIgnoreCase(firstProduct)){
                    System.out.println("First selected product added to cart succuessfully");
            }
            else{
                    System.out.println("First selected product not added to cart :<");
            }

            String verifySecondProduct = driver.findElement(By.xpath("//tr[@id='product-2']/child::td[@class='cart_description']/child::h4")).getText();
            if(verifySecondProduct.equalsIgnoreCase(secondProduct)){
                    System.out.println("Second selected product added to cart succuessfully");
            }
            else{
                    System.out.println("Second selected product not added to cart :<");
            }

            driver.close();
    }
    }

