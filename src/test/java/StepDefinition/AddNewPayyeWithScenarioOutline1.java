package StepDefinition;

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

public class AddNewPayyeWithScenarioOutline1 {
    WebDriver driver;

    @Given("User Navigate To Zero Bank")
    public void userNavigateToZeroBank() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://zero.webappsecurity.com/login.html");
    }

    @When("User enter valid username and password")
    public void userEnterValidUsernameAndPassword() {
        WebElement userNameInput = driver.findElement(By.id("user_login"));
        userNameInput.sendKeys("username");

        WebElement passwordInput = driver.findElement(By.id("user_password"));
        passwordInput.sendKeys("password");

        WebElement signinButton = driver.findElement(By.cssSelector("input[value='Sign in']"));
        signinButton.click();

        driver.navigate().back();

    }

    @When("User click on both PayBills and then AddNewPayee")
    public void userClickOnBothPayBillsAndThenAddNewPayee() {

        WebElement onlineBankingButton = driver.findElement(By.xpath("//strong[text()='Online Banking']"));
        onlineBankingButton.click();
        WebElement payBillsButton = driver.findElement(By.xpath("//span[text()='Pay Bills']"));
        payBillsButton.click();
        WebElement addnewPayee = driver.findElement(By.xpath("//a[text()='Add New Payee']"));
        addnewPayee.click();
    }

    @Then("User should Fill {string}")
    public void userShouldFill(String name) {
        WebElement nameInput = driver.findElement(By.id("np_new_payee_name"));
        nameInput.sendKeys(name);
    }

    @Then("User should fill the {string}")
    public void userShouldFillThe(String address) {
        WebElement addressInput = driver.findElement(By.id("np_new_payee_address"));
        addressInput.sendKeys(address);

    }

    @Then("User should filll the {string}")
    public void userShouldFilllThe(String account) {
        WebElement accountInput = driver.findElement(By.id("np_new_payee_account"));
        accountInput.sendKeys(account);
    }
    @Then("User should fills the {string}")
    public void userShouldFillsThe(String payeeDetails) {
        WebElement payeeInput = driver.findElement(By.xpath("(//input[@class='span4'])[4]"));
        payeeInput.sendKeys(payeeDetails);

        WebElement addButton = driver.findElement(By.cssSelector("input[value='Add']"));
        addButton.click();

        WebElement successMessage = driver.findElement(By.id("alert_content"));

        Assert.assertTrue(successMessage.getText().contains("successfully "));

        driver.quit();
    }

}
