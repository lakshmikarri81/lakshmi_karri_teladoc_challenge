package pages;

import org.openqa.selenium.By;

public class Locators {
    public static final By ADD_USER_BUTTON = By.xpath("//button[@class='btn btn-link pull-right' and @type='add']");
    public static final By USER_TABLE_BODY = By.xpath(".//tbody");
    public static final By FIRST_NAME_FIELD = By.xpath("//input[@name='FirstName']");
    public static final By LAST_NAME_FIELD = By.xpath("//input[@name='LastName']");
    public static final By USERNAME_FIELD = By.xpath("//input[@name='UserName']");
    public static final By PASSWORD_FIELD = By.xpath("//input[@name='Password']");
    public static final By COMPANY_A = By.xpath("//label[input[@type='radio' and @name='optionsRadios' and @value='15']]");
    public static final By ROLE_DROPDOWN = By.xpath("//select[@name='RoleId' and @ng-model='dataRow[column.map]']");
    public static final By EMAIL_FIELD = By.xpath("//input[@name='Email']");
    public static final By PHONE_FIELD = By.xpath("//input[@name='Mobilephone']");
    public static final By SAVE_BUTTON = By.xpath("//button[contains(text(),'Save')]");
    public static final By DELETE_BUTTON = By.xpath(".//button[@class='btn btn-link' and @ng-click='delUser()']");
    public static final By MODAL_DIALOG = By.xpath("//div[contains(@class, 'modal')]");
    public static final By OK_BUTTON = By.xpath(".//button[contains(@class, 'btn-primary') and text()='OK']");
    public static final By TABLE_ROWS = By.xpath("//table/tbody/tr");
}
