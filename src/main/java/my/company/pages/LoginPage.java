package my.company.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/***
 * Страница входа в Сбербанк (демо).
 */
public class LoginPage {

    @FindBy(xpath = "//div[text() = 'Скрыть подсказки']")
    public WebElement buttonHideTooltips;

    @FindBy(xpath = "//div[@id='buttonSubmit']//button")
    public WebElement buttonLogin;

    @FindBy(xpath = "//div[@class='field_error']")
    public WebElement testError;

    private static WebDriver driver;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
