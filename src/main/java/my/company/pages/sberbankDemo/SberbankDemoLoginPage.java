package my.company.pages.sberbankDemo;

import my.company.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/***
 * Страница входа в Сбербанк (демо).
 */
public class SberbankDemoLoginPage extends BasePage {

    @FindBy(xpath = "//div[text() = 'Скрыть подсказки']")
    public WebElement buttonHideTooltips;

    @FindBy(xpath = "//input[@id = 'login']")
    public WebElement fieldLogin;

    @FindBy(xpath = "//input[@id = 'password']")
    public WebElement fieldPassword;

    @FindBy(xpath = "//div[@id='buttonSubmit']//button")
    public WebElement buttonLogin;

    @FindBy(xpath = "//div[@class='field_error']")
    public WebElement testError;
}
