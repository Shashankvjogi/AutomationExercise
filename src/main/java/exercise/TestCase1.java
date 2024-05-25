package exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import java.time.Duration;

public class TestCase1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
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
        boolean verify = driver.findElement(By.xpath("//h2[text()='New User Signup!']")).isDisplayed();
        if(verify){
            System.out.println("New User Signup! is Displayed");
        }
        else {
            System.out.println("New User Signup! is not Displayed");
        }
        String username ="testing11234";
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("testing11234@gmail.com");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        boolean verify1 = driver.findElement(By.xpath("//b[text()='Enter Account Information']")).isDisplayed();
        if(verify1){
            System.out.println("Enter Account Information is Displayed");
        }
        else {
            System.out.println("Enter Account Information is not Displayed");
        }

        driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("testing");

        Select selectDays = new Select(driver.findElement(By.xpath("//select[@id='days']")));
        selectDays.selectByVisibleText("12");
        Select selectMonth = new Select(driver.findElement(By.xpath("//select[@id='months']")));
        selectMonth.selectByVisibleText("May");
        Select selectYear = new Select(driver.findElement(By.xpath("//select[@id='years']")));
        selectYear.selectByVisibleText("2000");

        driver.findElement(By.xpath("//input[@name='newsletter']")).click();
        driver.findElement(By.xpath("//input[@name='optin']")).click();

        driver.findElement(By.xpath("//input[@data-qa='first_name']")).sendKeys("testing");
        driver.findElement(By.xpath("//input[@data-qa='last_name']")).sendKeys("testing");
        driver.findElement(By.xpath("//input[@data-qa='company']")).sendKeys("testing");
        driver.findElement(By.xpath("//input[@data-qa='address']")).sendKeys("testing");
        driver.findElement(By.xpath("//input[@data-qa='address2']")).sendKeys("testing");

        Select selectCountry = new Select(driver.findElement(By.xpath("//select[@data-qa='country']")));
        selectCountry.selectByVisibleText("Singapore");

        driver.findElement(By.xpath("//input[@data-qa='state']")).sendKeys("test");
        driver.findElement(By.xpath("//input[@data-qa='city']")).sendKeys("test");
        driver.findElement(By.xpath("//input[@data-qa='zipcode']")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@data-qa='mobile_number']")).sendKeys("1234567890");

        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
        boolean verify2 = driver.findElement(By.xpath("//b[text()='Account Created!']")).isDisplayed();
        if(verify2){
            System.out.println("Account Created! is Displayed");
        }
        else {
            System.out.println("Account Created! is not Displayed");
        }

        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

        boolean verify3 = driver.findElement(By.xpath("//a[text()=' Logged in as ']//child::b[text()='"+username+"']")).isDisplayed();
        if(verify3){
            System.out.println("Logged in as username is Displayed");
        }
        else {
            System.out.println("Logged in as username is not Displayed");
        }
        driver.findElement(By.xpath("//a[text()=' Delete Account']")).click();

        boolean verify4 = driver.findElement(By.xpath("//b[text()='Account Deleted!']")).isDisplayed();
        if(verify3){
            System.out.println("Account Deleted! is Displayed");
        }
        else {
            System.out.println("Account Deleted! is not Displayed");
        }
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();



    }
}
