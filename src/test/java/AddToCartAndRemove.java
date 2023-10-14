import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddToCartAndRemove {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 20);
        login();
    }

    private void login() {
        driver.get("https://www.demoblaze.com");
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login2")));
        loginButton.click();

        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginusername")));
        usernameField.sendKeys("Mohamed Ezz");

        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginpassword")));
        passwordField.sendKeys("12345");

        WebElement loginModalButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Log in']")));
        loginModalButton.click();

        WebElement itemsTable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tbodyid']")));
        Assert.assertTrue(itemsTable.isDisplayed());
    }

    private void clickElement(WebElement element) {
        try {
            element.click();
        } catch (StaleElementReferenceException e) {
            // Element is stale; re-locate it
            element = wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        }
    }

    @Test
    public void addFirstItemToCartAndRemove() {
        // Find and click the first item without refreshing the page
        WebElement loginModal = driver.findElement(By.id("logInModal"));
        if (loginModal.isDisplayed()) {
            WebElement closeModalButton = driver.findElement(By.xpath("//button[@data-dismiss='modal']"));
            closeModalButton.click();
        }

        // Add a wait after clicking the first item
        WebDriverWait itemLoadWait = new WebDriverWait(driver, 10);
        itemLoadWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@onclick, 'addToCart')]")));

        WebElement cartButton = driver.findElement(By.xpath("//*[@id='cartur']"));
        clickElement(cartButton);

        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tbodyid']/tr/td[4]/a")));
        clickElement(deleteButton);
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
