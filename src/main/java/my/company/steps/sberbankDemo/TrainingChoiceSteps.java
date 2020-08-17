package my.company.steps.sberbankDemo;

import my.company.pages.sberbankDemo.TrainingChoicePage;
import org.junit.Assert;
import ru.yandex.qatools.allure.annotations.Step;


/***
 * Шаги для страницы выбора обучения в Сбербанк (демо).
 */
public class TrainingChoiceSteps {

    private final TrainingChoicePage trainingChoicePage = new TrainingChoicePage();

    @Step("получил заголовок окна")
    private String getTextTitle() {
        String textTitle = trainingChoicePage.textTrainingChoice.getText();

        System.out.println("textTitle:");
        System.out.println(textTitle);

        return textTitle;
    }

    @Step("проверил название окна \"{0}\"")
    public void checkTitle(String windowName) {
        Assert.assertEquals("Название окна не верное", windowName, this.getTextTitle());
    }
}
