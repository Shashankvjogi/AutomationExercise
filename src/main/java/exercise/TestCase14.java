package exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class TestCase14 {
    public static void main(String[] args) throws InterruptedException {
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
//        driver.findElement(By.xpath("//a[@data-product-id='1']")).click();
//        driver.findElement(By.xpath("//a[@data-product-id='2']")).click();
//
//

        Actions actions =new Actions(driver);
        WebElement element1 = driver.findElement(By.xpath("//a[@data-product-id='1']/ancestor::div[@class='productinfo text-center']"));
        actions.moveToElement(element1).build().perform();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='overlay-content']/child::a[@data-product-id='1']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();


        WebElement element2 = driver.findElement(By.xpath("//a[@data-product-id='2']/ancestor::div[@class='productinfo text-center']"));
        actions.moveToElement(element2).build().perform();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='overlay-content']/child::a[@data-product-id='2']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();

        driver.findElement(By.xpath("//a[text()=' Cart']")).click();

        String cartTitle ="Automation Exercise - Checkout";
        if(cartTitle.equalsIgnoreCase(driver.getTitle())){
            System.out.println("Successfully landed in cart page");
        }
        else {
            System.out.println("Unfortunately not landed in cart page");
        }
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        driver.findElement(By.xpath("//u[text()='Register / Login']")).click();

        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("testing99");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("testing99@gmail.com");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        driver.findElement(By.cssSelector("input#id_gender1")).click();
        driver.findElement(By.cssSelector("input[data-qa='password']")).sendKeys("testing");
        Select select = new Select(driver.findElement(By.xpath("//select[@data-qa='days']")));
        select.selectByVisibleText("12");
        select = new Select(driver.findElement(By.xpath("//select[@data-qa='months']")));
        select.selectByVisibleText("May");
        select = new Select(driver.findElement(By.xpath("//select[@data-qa='years']")));
        select.selectByVisibleText("2000");

        driver.findElement(By.xpath("//input[@name='newsletter']")).click();

        driver.findElement(By.xpath("//input[@data-qa='first_name']")).sendKeys("Testing99");
        driver.findElement(By.xpath("//input[@data-qa='last_name']")).sendKeys("Testing99");
        driver.findElement(By.xpath("//input[@data-qa='address']")).sendKeys("Testing99");
        Select select2 = new Select(driver.findElement(By.xpath("//select[@name='country']")));
        select2.selectByVisibleText("India");
        driver.findElement(By.xpath("//input[@data-qa='state']")).sendKeys("Testing99");
        driver.findElement(By.xpath("//input[@data-qa='city']")).sendKeys("Testing99");
        driver.findElement(By.xpath("//input[@data-qa='zipcode']")).sendKeys("11111");
        driver.findElement(By.xpath("//input[@data-qa='mobile_number']")).sendKeys("1111111111");

        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();

        if(driver.findElement(By.xpath("//b[text()='Account Created!']")).isDisplayed()){
            System.out.println("Account Created");
        }
        else{
            System.out.println("Unfortunately Account not created");
        }
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

        boolean verify3 = driver.findElement(By.xpath("//a[text()=' Logged in as ']//child::b[text()='testing99']")).isDisplayed();
        if(verify3){
            System.out.println("Logged in as username is Displayed");
        }
        else {
            System.out.println("Logged in as username is not Displayed");
        }

        driver.findElement(By.xpath("//a[text()=' Cart']")).click();
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();

        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("testing");
        driver.findElement(By.xpath("//a[text()='Place Order']")).click();

        driver.findElement(By.xpath("//input[@data-qa='name-on-card']")).sendKeys("testing");
        driver.findElement(By.xpath("//input[@data-qa='card-number']")).sendKeys("11111");
        driver.findElement(By.xpath("//input[@data-qa='cvc']")).sendKeys("111");
        driver.findElement(By.xpath("//input[@data-qa='expiry-month']")).sendKeys("05");
        driver.findElement(By.xpath("//input[@data-qa='expiry-year']")).sendKeys("2000");

        driver.findElement(By.xpath("//button[@data-qa='pay-button']")).click();



        if(driver.findElement(By.xpath("//div[@class='alert-success alert']")).getText().equalsIgnoreCase("\n" +
                "\t\t\t\t\t\t\t\t\t\tYour order has been placed successfully!\n" +
                "\t\t\t\t\t\t\t\t\t")){
            System.out.println("Your order has been placed successfully! message displayed");
        }
        else{
            System.out.println("Your order has been placed successfully! message not displayed");
        }
        driver.findElement(By.xpath(" //a[text()=' Delete Account']")).click();

        if(driver.findElement(By.xpath("//b[text()='Account Deleted!']")).getText().equalsIgnoreCase("Account Deleted!")){
            System.out.println("Account Deleted!");
        }
        else{
            System.out.println("Account did not delete!");
        }
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();































    }
}
