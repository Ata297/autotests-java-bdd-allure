package my.company.pages.sberbankDemo;

import my.company.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/***
 * Страница подтверждения входа в Сбербанк (демо).
 */
public class SberbankDemoConfirmLoginPage extends BasePage {

    @FindBy(xpath = "//h2[contains(text(), 'Подтверждение входа')]")
    public WebElement textConfirmLogin;

    @FindBy(xpath = "//div[text() = 'Скрыть подсказки']")
    public WebElement buttonHideTooltips;

    @FindBy(xpath = "//input[@name = '$$confirmSmsPassword']")
    public WebElement fieldSmsPassword;

    @FindBy(xpath = "//a[@onclick=\"enter()\"]")
    public WebElement buttonConfirm;
}
