import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PlaceOrder {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
    }

    @Test
    public void placeOrder() {
        login();

        WebElement cartButton = driver.findElement(By.id("cartur"));
        cartButton.click();

        WebElement placeOrderButton = driver.findElement(By.xpath("//*[@id='page-wrapper']/div/div[2]/button"));
        placeOrderButton.click();

        fillOrderForm();

        WebElement purchaseButton = driver.findElement(By.xpath("//button[@onclick='purchaseOrder()']"));
        purchaseButton.click();
    }

    private void login() {
        driver.get("https://www.demoblaze.com");

        WebElement loginButton = driver.findElement(By.id("login2"));
        loginButton.click();

        WebElement usernameField = driver.findElement(By.id("loginusername"));
        usernameField.sendKeys("Mohamed Ezz");

        WebElement passwordField = driver.findElement(By.id("loginpassword"));
        passwordField.sendKeys("12345");

        WebElement loginModalButton = driver.findElement(By.xpath("//button[text()='Log in']"));
        loginModalButton.click();
    }

    private void fillOrderForm() {
        WebElement nameField = driver.findElement(By.id("name"));
        nameField.sendKeys("Mo ezz");

        WebElement countryField = driver.findElement(By.id("country"));
        countryField.sendKeys("cairo");

        WebElement cityField = driver.findElement(By.id("city"));
        cityField.sendKeys("nasr city");

        WebElement cardField = driver.findElement(By.id("card"));
        cardField.sendKeys("1234 5678 9012 3456");

        WebElement monthField = driver.findElement(By.id("month"));
        monthField.sendKeys("12");

        WebElement yearField = driver.findElement(By.id("year"));
        yearField.sendKeys("2023");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
        }
    }
}
