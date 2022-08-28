package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class TransferFundsWithScenarioOutline {
    WebDriver driver;

    @Given("User Navigate To Zero Bank2")
    public void userNavigateToZeroBank() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://zero.webappsecurity.com/login.html");
    }

    @When("User enter valid username and password2")
    public void userEnterValidUsernameAndPassword() {
        WebElement userNameInput = driver.findElement(By.id("user_login"));
        userNameInput.sendKeys("username");

        WebElement passwordInput = driver.findElement(By.id("user_password"));
        passwordInput.sendKeys("password");

        WebElement signinButton = driver.findElement(By.cssSelector("input[value='Sign in']"));
        signinButton.click();

        driver.navigate().back();

    }

    @And("User click on Transfer Funds")
    public void userClickOnTransferFunds() {
        WebElement onlineBankingButton = driver.findElement(By.xpath("//strong[text()='Online Banking']"));
        onlineBankingButton.click();

        WebElement transferFundsButton = driver.findElement(By.xpath("//span[text()='Transfer Funds']"));
        transferFundsButton.click();

    }

    @And("User send {string} and {string}")
    public void userSendAnd(String amount2, String description) {

        WebElement amountInput = driver.findElement(By.id("tf_amount"));
        amountInput.sendKeys(amount2);

        WebElement descriptionInput = driver.findElement(By.id("tf_description"));
        descriptionInput.sendKeys(description);

        WebElement continueButton = driver.findElement(By.id("btn_submit"));
        continueButton.click();

        WebElement submitButton = driver.findElement(By.id("btn_submit"));
        submitButton.click();

    }

    @Then("User should the success message")
    public void userShouldTheSuccessMessage() {

        WebElement successMessage4 = driver.findElement(By.cssSelector("div[class='alert alert-success']"));
        Assert.assertTrue(successMessage4.getText().contains("transaction"));
    }
}
