package my.company.steps;

import my.company.pages.LoginPage;
import org.junit.Assert;
import ru.yandex.qatools.allure.annotations.Step;

/***
 * Шаги для страницы входа в Сбербанк (демо).
 */
public class LoginSteps extends BaseSteps {

    @Step("скрыть кнопку \"Скрыть подсказки\"")
    public void hideTooltips() {
        new LoginPage(driver).buttonHideTooltips.click();
    }

    @Step("нажать на кнопку \"Войти\"")
    public void login() {
        new LoginPage(driver).buttonLogin.click();
    }

    @Step("получить формулировку ошибки")
    public String getTextError() {
        String textError = new LoginPage(driver).testError.getText();

        System.out.println("textError:");
        System.out.println(textError);

        return textError;
    }

    @Step("проверить наличие ошибки")
    public void checkErrorDisplay() {
        Assert.assertNotNull("Ошибка не появилась", this.getTextError());
    }
}
