package my.company.steps.sberbankDemo;

import my.company.pages.sberbankDemo.SberbankDemoLoginPage;
import org.junit.Assert;
import ru.yandex.qatools.allure.annotations.Step;


/***
 * Шаги для страницы входа в Сбербанк (демо).
 */
public class SberbankDemoLoginSteps {

    private final SberbankDemoLoginPage sberbankDemoLoginPage = new SberbankDemoLoginPage();

    @Step("нажал кнопку \"Скрыть подсказки\"")
    public void hideTooltips() {
        sberbankDemoLoginPage.buttonHideTooltips.click();
    }

    @Step("поле {0} заполнил значением {1}")
    public void fillField(String field, String value){
        switch (field){
            case  "Логин":
                sberbankDemoLoginPage.fillField(sberbankDemoLoginPage.fieldLogin, value);
                break;
            case  "Пароль":
                sberbankDemoLoginPage.fillField(sberbankDemoLoginPage.fieldPassword, value);
                break;
            default:  throw new AssertionError("Поле '" + field + "' не объявлено на странице");
        }
    }

    @Step("нажал на кнопку \"Войти\"")
    public void login() {
        sberbankDemoLoginPage.buttonLogin.click();
    }

    @Step("получил формулировку ошибки")
    private String getTextError() {
        String textError = sberbankDemoLoginPage.testError.getText();

        System.out.println("textError:");
        System.out.println(textError);

        return textError;
    }

    @Step("проверил наличие ошибки {0}")
    public void checkError(String textError) {
        Assert.assertEquals("Ошибка не появилась", textError, this.getTextError());
    }
}
