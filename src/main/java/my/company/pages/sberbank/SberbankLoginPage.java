package my.company.pages.sberbank;

import my.company.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/***
 * Страница входа в Сбербанк.
 */
public class SberbankLoginPage extends BasePage {

    @FindBy(xpath = "//input[@id = 'loginByLogin']")
    public WebElement fieldLogin;

    @FindBy(xpath = "//input[@id = 'password']")
    public WebElement fieldPassword;

    @FindBy(xpath = "//form[@id='homeAuth']//button[@data-unit='button:general']")
    public WebElement buttonLogin;
}
