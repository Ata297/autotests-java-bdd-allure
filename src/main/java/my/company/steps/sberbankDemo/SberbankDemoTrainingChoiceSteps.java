package my.company.steps.sberbankDemo;

import my.company.pages.sberbankDemo.SberbankDemoTrainingChoicePage;
import org.junit.Assert;
import ru.yandex.qatools.allure.annotations.Step;


/***
 * Шаги для страницы выбора обучения в Сбербанк (демо).
 */
public class SberbankDemoTrainingChoiceSteps {

    private final SberbankDemoTrainingChoicePage sberbankDemoTrainingChoicePage = new SberbankDemoTrainingChoicePage();

    @Step("получил заголовок окна")
    private String getTextTitle() {
        String textTitle = sberbankDemoTrainingChoicePage.textTrainingChoice.getText();

        System.out.println("textTitle:");
        System.out.println(textTitle);

        return textTitle;
    }

    @Step("проверил название окна \"{0}\"")
    public void checkTitle(String windowName) {
        Assert.assertEquals("Название окна не верное", windowName, this.getTextTitle());
    }
}
