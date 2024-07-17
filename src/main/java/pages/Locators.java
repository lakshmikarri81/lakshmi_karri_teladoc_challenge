package pages;

import org.openqa.selenium.By;

public class Locators {
    public static final By ADD_USER_BUTTON = By.xpath("//thead/tr[2]/td[1]/button[1]");
    public static final By USER_TABLE_BODY = By.xpath(".//tbody");
    public static final By FIRST_NAME_FIELD = By.xpath("//tbody/tr[1]/td[2]/input[1]");
    public static final By LAST_NAME_FIELD = By.xpath("//tbody/tr[2]/td[2]/input[1]");
    public static final By USERNAME_FIELD = By.xpath("//tbody/tr[3]/td[2]/input[1]");
    public static final By PASSWORD_FIELD = By.xpath("//tbody/tr[4]/td[2]/input[1]");
    public static final By COMPANY_A = By.xpath("//tbody/tr[5]/td[2]/label[1]");
    public static final By ROLE_DROPDOWN = By.xpath("//tbody/tr[6]/td[2]/select[1]");
    public static final By EMAIL_FIELD = By.xpath("//tbody/tr[7]/td[2]/input[1]");
    public static final By PHONE_FIELD = By.xpath("//tbody/tr[8]/td[2]/input[1]");
    public static final By SAVE_BUTTON = By.xpath("//button[contains(text(),'Save')]");
    public static final By DELETE_BUTTON = By.xpath(".//button[@class='btn btn-link' and @ng-click='delUser()']");
    public static final By MODAL_DIALOG = By.xpath("//div[contains(@class, 'modal')]");
    public static final By OK_BUTTON = By.xpath(".//button[contains(@class, 'btn-primary') and text()='OK']");
    public static final By TABLE_ROWS = By.xpath("//table/tbody/tr");
}
