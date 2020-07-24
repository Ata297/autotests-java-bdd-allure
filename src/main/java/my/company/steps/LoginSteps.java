package my.company.steps;

import my.company.pages.LoginPage;
import org.junit.Assert;
import ru.yandex.qatools.allure.annotations.Step;

/***
 * Шаги для страницы входа в Сбербанк (демо).
 */
public class LoginSteps {

    @Step("нажал кнопку \"Скрыть подсказки\"")
    public void hideTooltips() {
        new LoginPage(BaseSteps.getDriver()).buttonHideTooltips.click();
    }

    @Step("нажал на кнопку \"Войти\"")
    public void login() {
        new LoginPage(BaseSteps.getDriver()).buttonLogin.click();
    }

    @Step("получил формулировку ошибки")
    private String getTextError() {
        String textError = new LoginPage(BaseSteps.getDriver()).testError.getText();

        System.out.println("textError:");
        System.out.println(textError);

        return textError;
    }

    @Step("проверил наличие ошибки")
    public void checkErrorDisplay() {
        Assert.assertNotNull("Ошибка не появилась", this.getTextError());
    }
}
