package my.company.steps.sberbankDemo;

import my.company.pages.sberbankDemo.SberbankDemoConfirmLoginPage;
import org.junit.Assert;
import ru.yandex.qatools.allure.annotations.Step;


/***
 * Шаги для страницы подтверждения входа в Сбербанк (демо).
 */
public class SberbankDemoConfirmLoginSteps {

    private final SberbankDemoConfirmLoginPage sberbankDemoConfirmLoginPage = new SberbankDemoConfirmLoginPage();

    @Step("нажал кнопку \"Скрыть подсказки\"")
    public void hideTooltips() {
        sberbankDemoConfirmLoginPage.buttonHideTooltips.click();
    }

    @Step("получил заголовок окна")
    private String getTextTitle() {
        String textTitle = sberbankDemoConfirmLoginPage.textConfirmLogin.getText();

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
                sberbankDemoConfirmLoginPage.fillField(sberbankDemoConfirmLoginPage.fieldSmsPassword, value);
                break;
            default:  throw new AssertionError("Поле '" + field + "' не объявлено на странице");
        }
    }

    @Step("нажал на кнопку \"Подтвердить\"")
    public void confirm() {
        sberbankDemoConfirmLoginPage.buttonConfirm.click();
    }
}
