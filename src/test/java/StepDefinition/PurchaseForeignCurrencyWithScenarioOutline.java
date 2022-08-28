package StepDefinition;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class PurchaseForeignCurrencyWithScenarioOutline {

    WebDriver driver;

    @Given("User Navigate To Zero Bank1")
    public void userNavigateToZeroBank() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://zero.webappsecurity.com/login.html");
    }

    @When("User enter valid username and password1")
    public void userEnterValidUsernameAndPassword() {
        WebElement userNameInput = driver.findElement(By.id("user_login"));
        userNameInput.sendKeys("username");

        WebElement passwordInput = driver.findElement(By.id("user_password"));
        passwordInput.sendKeys("password");

        WebElement signinButton = driver.findElement(By.cssSelector("input[value='Sign in']"));
        signinButton.click();

        driver.navigate().back();

    }

    @When("User click on Paybills and Purchase Foreign Currency")
    public void user_click_on_paybills_and_purchase_foreign_currency() {
        WebElement onlineBankingButton = driver.findElement(By.xpath("//strong[text()='Online Banking']"));
        onlineBankingButton.click();
        WebElement payBillsButton = driver.findElement(By.xpath("//span[text()='Pay Bills']"));
        payBillsButton.click();
        WebElement purchaseCurrencyButton = driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']"));
        purchaseCurrencyButton.click();
    }
    @When("User select for currency amount {string}")
    public void user_select_for_currency_amount(String amount) {

        WebElement currencyDropDown = driver.findElement(By.id("pc_currency"));
        Select select = new Select(currencyDropDown);
        select.selectByIndex(6);

        WebElement amountInput = driver.findElement(By.id("pc_amount"));
        amountInput.sendKeys(amount);

        WebElement dolarradioButton = driver.findElement(By.id("pc_inDollars_true"));
        dolarradioButton.click();

        WebElement purchaseButton = driver.findElement(By.id("purchase_cash"));
        purchaseButton.click();
    }
    @Then("User should see the success message")
    public void user_should_see_the_success_message() {

        WebElement successMessge = driver.findElement(By.id("alert_content"));
        Assert.assertTrue(successMessge.getText().contains("purchased"));
        driver.quit();

    }
}
