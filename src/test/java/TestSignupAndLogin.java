import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSignupAndLogin {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
        driver = new ChromeDriver();
    }

    @Test(priority = 1)
    public void successfullSignUp() {
        driver.get("https://www.demoblaze.com");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement signUpButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("signin2")));
        signUpButton.click();


        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-username")));
        usernameField.sendKeys("Mohamed ezzeldin21");

        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-password")));
        passwordField.sendKeys("123456");


        WebElement signUpModalButton = driver.findElement(By.xpath("//button[text()='Sign up']"));
        signUpModalButton.click();

        wait.until(ExpectedConditions.alertIsPresent());

        Alert successAlert = driver.switchTo().alert();
        String alertText = successAlert.getText();
        successAlert.accept();
        Assert.assertTrue(alertText.contains("Sign up successful."));
    }

    @Test(priority = 2)
    public void successfulLogin() {
        driver.get("https://www.demoblaze.com");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login2")));
        loginButton.click();

        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginusername")));
        usernameField.sendKeys("Mohamed ezzeldin21");

        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginpassword")));
        passwordField.sendKeys("123456");

        WebElement loginModalButton = driver.findElement(By.xpath("//button[text()='Log in']"));
        loginModalButton.click();

        WebElement itemsTable = driver.findElement(By.xpath("//*[@id='tbodyid']"));
        Assert.assertTrue(itemsTable.isDisplayed());
    }



    @AfterClass
    public void tearDown() {
        if (driver != null) {
            try {
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
        }
    }
}
