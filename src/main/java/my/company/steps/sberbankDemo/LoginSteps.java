package my.company.steps.sberbankDemo;

import my.company.pages.sberbankDemo.LoginPage;
import org.junit.Assert;
import ru.yandex.qatools.allure.annotations.Step;


/***
 * Шаги для страницы входа в Сбербанк (демо).
 */
public class LoginSteps {

    private final LoginPage loginPage = new LoginPage();

    @Step("нажал кнопку \"Скрыть подсказки\"")
    public void hideTooltips() {
        loginPage.buttonHideTooltips.click();
    }

    @Step("поле {0} заполнил значением {1}")
    public void fillField(String field, String value){
        switch (field){
            case  "Логин":
                loginPage.fillField(loginPage.fieldLogin, value);
                break;
            case  "Пароль":
                loginPage.fillField(loginPage.fieldPassword, value);
                break;
            default:  throw new AssertionError("Поле '" + field + "' не объявлено на странице");
        }
    }

    @Step("нажал на кнопку \"Войти\"")
    public void login() {
        loginPage.buttonLogin.click();
    }

    @Step("получил формулировку ошибки")
    private String getTextError() {
        String textError = loginPage.testError.getText();

        System.out.println("textError:");
        System.out.println(textError);

        return textError;
    }

    @Step("проверил наличие ошибки {0}")
    public void checkError(String textError) {
        Assert.assertEquals("Ошибка не появилась", textError, this.getTextError());
    }
}
