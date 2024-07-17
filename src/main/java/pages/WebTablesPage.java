package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

public class WebTablesPage {
    WebDriver driver;
    WebDriverWait wait;
    Logger logger = Logger.getLogger(WebTablesPage.class.getName());

    public WebTablesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // initialize wait here
    }

    public void addUser(String firstName, String lastName, String username,
                        String password, String email, String phone) {

        WebElement addButton = driver.findElement(Locators.ADD_USER_BUTTON);
        addButton.click();

        // Wait for the form to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.FIRST_NAME_FIELD));

        // Locate the form fields and enter the values
        WebElement firstNameField = driver.findElement(Locators.FIRST_NAME_FIELD);
        WebElement lastNameField = driver.findElement(Locators.LAST_NAME_FIELD);
        WebElement usernameField = driver.findElement(Locators.USERNAME_FIELD);
        WebElement passwordField = driver.findElement(Locators.PASSWORD_FIELD);

        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        WebElement companyA = driver.findElement(Locators.COMPANY_A);
        companyA.click();

        WebElement role = driver.findElement(Locators.ROLE_DROPDOWN);
        role.click();
        role.click();

        Select select = new Select(role);
        select.selectByVisibleText("Customer");

        WebElement emailField = driver.findElement(Locators.EMAIL_FIELD);
        WebElement phoneField = driver.findElement(Locators.PHONE_FIELD);
        emailField.sendKeys(email);
        phoneField.sendKeys(phone);

        // Locate and click the save button
        WebElement saveButton = driver.findElement(Locators.SAVE_BUTTON);
        saveButton.click();
    }

    public boolean isUserPresent(String username) {
        WebElement userTableEle = driver.findElement(Locators.USER_TABLE_BODY);
        List<WebElement> rows = userTableEle.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            if (row.getText().contains(username)) {
                logger.info("User " + username + " added successfully.");
                return true;
            }
        }
        return false;
    }

    public void deleteUser(String userName) {
        List<WebElement> rows = driver.findElements(Locators.TABLE_ROWS);
        for (WebElement row : rows) {
            if (row.getText().contains(userName)) {
                // Click the delete button
                row.findElement(Locators.DELETE_BUTTON).click();
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                try {
                    WebElement modalDialog = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.MODAL_DIALOG));
                    WebElement okButton = modalDialog.findElement(Locators.OK_BUTTON);

                    logger.info("OK button found: " + (okButton != null));

                    okButton.click();

                } catch (TimeoutException e) {
                    logger.info("Modal dialog not found within the timeout period.");
                } catch (NoSuchElementException e) {
                    logger.info("OK button not found within the modal dialog.");
                }
                break;
            }
        }
    }

    public boolean isUserNotPresent(String username) {
        boolean isUserNotPresent = true;
        WebElement userTableEle = driver.findElement(Locators.USER_TABLE_BODY);
        List<WebElement> rows = userTableEle.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            if (row.getText().contains(username)) {
                logger.info("User " + username + " deleted successfully.");
                isUserNotPresent = false;
            }
        }
        return isUserNotPresent;
    }
}
