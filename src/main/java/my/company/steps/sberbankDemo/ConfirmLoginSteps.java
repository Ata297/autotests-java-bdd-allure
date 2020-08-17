package my.company.steps.sberbankDemo;

import my.company.pages.sberbankDemo.ConfirmLoginPage;
import org.junit.Assert;
import ru.yandex.qatools.allure.annotations.Step;


/***
 * Шаги для страницы подтверждения входа в Сбербанк (демо).
 */
public class ConfirmLoginSteps {

    private final ConfirmLoginPage confirmLoginPage = new ConfirmLoginPage();

    @Step("нажал кнопку \"Скрыть подсказки\"")
    public void hideTooltips() {
        confirmLoginPage.buttonHideTooltips.click();
    }

    @Step("получил заголовок окна")
    private String getTextTitle() {
        String textTitle = confirmLoginPage.textConfirmLogin.getText();

        System.out.println("textTitle:");
        System.out.println(textTitle);

        return textTitle;
    }

    @Step("проверил название окна \"{0}\"")
    public void checkTitle(String windowName) {
        Assert.assertEquals("Название окна не верное", windowName, this.getTextTitle());
    }

    @Step("поле \"{0}\" заполнил значением \"{1}\"")
    public void fillField(String field, String value){
        switch (field){
            case  "СМС-пароль":
                confirmLoginPage.fillField(confirmLoginPage.fieldSmsPassword, value);
                break;
            default:  throw new AssertionError("Поле '" + field + "' не объявлено на странице");
        }
    }

    @Step("нажал на кнопку \"Подтвердить\"")
    public void confirm() {
        confirmLoginPage.buttonConfirm.click();
    }
}
