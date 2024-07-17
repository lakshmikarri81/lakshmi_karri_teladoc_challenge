package stepDefinitions;

import config.WebDriverConfig;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.WebTablesPage;
import utils.JsonUtils;

import java.time.Duration;
import java.util.logging.Logger;

public class WebTablesSteps {
    WebDriver driver;
    WebTablesPage webTablesPage;
    Logger logger = Logger.getLogger(WebTablesSteps.class.getName());

    @Given("I am on the web tables page")
    public void i_am_on_the_web_tables_page() {
        logger.info("Setting up ChromeDriver path");
        System.setProperty("webdriver.chrome.driver", WebDriverConfig.CHROME_DRIVER_PATH);

        logger.info("Setting Chrome options");
        ChromeOptions options = WebDriverConfig.getChromeOptions();

        logger.info("Initializing ChromeDriver");
        driver = new ChromeDriver(options);
        // Maximize the browser window
        driver.manage().window().maximize();

        webTablesPage = new WebTablesPage(driver);

        logger.info("Navigating to the web tables page");
        driver.get(WebDriverConfig.WEB_TABLES_URL);

        // Wait for the page to load and the table to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        logger.info("Web tables page loaded successfully");
    }

    @When("I add a new user with the details")
    public void i_add_a_new_user_with_the_details() {
        var addUserDetails = JsonUtils.getDataNode("addUser");
        webTablesPage.addUser(
                addUserDetails.path("firstName").asText(),
                addUserDetails.path("lastName").asText(),
                addUserDetails.path("username").asText(),
                addUserDetails.path("password").asText(),
                addUserDetails.path("email").asText(),
                addUserDetails.path("phone").asText()
        );
    }

    @Then("the user should be added to the table")
    public void the_user_should_be_added_to_the_table() {
        var addUserDetails = JsonUtils.getDataNode("addUser");
        assert webTablesPage.isUserPresent(addUserDetails.path("username").asText());
        driver.close();
    }

    @When("I identify the user")
    public void i_identify_user(){
        var identifyUserDetails = JsonUtils.getDataNode("identifyUser");
        assert webTablesPage.isUserPresent(identifyUserDetails.path("username").asText());
    }

    @And("I delete the user")
    public void i_delete_user() {
        var identifyUserDetails = JsonUtils.getDataNode("identifyUser");
        webTablesPage.deleteUser(identifyUserDetails.path("username").asText());
    }

    @Then("I verify the user is deleted")
    public void i_verify_the_user_is_deleted() {
        var identifyUserDetails = JsonUtils.getDataNode("identifyUser");
        assert webTablesPage.isUserNotPresent(identifyUserDetails.path("username").asText());
        driver.close();
    }
}
