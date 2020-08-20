package my.company.steps.sberbank;

import my.company.pages.sberbank.SberbankLoginPage;
import org.junit.Assert;
import ru.yandex.qatools.allure.annotations.Step;


/***
 * Шаги для страницы входа в Сбербанк.
 */
public class SberbankLoginSteps {

    private final SberbankLoginPage sberbankLoginPage = new SberbankLoginPage();

    @Step("проверил наличие поля ввода логина")
    public void checkFieldLogin() {
        Assert.assertTrue("Поле ввода логина не отобразилось", sberbankLoginPage.fieldLogin.isDisplayed());
    }

    @Step("проверил наличие поля ввода пароля")
    public void checkFieldPassword() {
        Assert.assertTrue("Поле ввода пароля не отобразилось", sberbankLoginPage.fieldPassword.isDisplayed());
    }

    @Step("проверил наличие кнопки входа")
    public void checkButtonLogin() {
        Assert.assertTrue("Кнопка входа не отобразилось", sberbankLoginPage.buttonLogin.isDisplayed());
    }
}
