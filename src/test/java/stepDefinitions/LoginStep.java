package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.LoginPage;

import java.time.Duration;


public class LoginStep {
    private WebDriver driver;
    private LoginPage loginPage;

    @Given("^user is on login page$")
    public void user_is_on_login_page() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/inventory.html");
        loginPage = new LoginPage(driver);

    }

    @When("^user enter (.*) and (.*)$")
    public void user_enter_username_and_password(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }


    @And("^user clicks on Login button$")
    public void user_click_on_login_button() {
        loginPage.clickLogin();

    }

    @Then("^user is navigate to the home page$")
    public void user_is_navigate_to_home_page() {
        loginPage.verifyHomePage();
    }

    @Then("the error message is displayed")
    public void the_error_message_is_displayed() {
       loginPage.errorMessage();
    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
