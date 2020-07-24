package my.company.steps;

import my.company.pages.LoginPage;
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
    public String getTestError() {
        return new LoginPage(driver).testError.getText();
    }
}
