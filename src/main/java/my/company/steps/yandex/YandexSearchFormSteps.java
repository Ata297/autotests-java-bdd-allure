package my.company.steps.yandex;

import my.company.pages.yandex.YandexSearchFormPage;
import org.junit.Assert;
import ru.yandex.qatools.allure.annotations.Step;


/***
 * Шаги для страницы поиска в Яндексе.
 */
public class YandexSearchFormSteps {

    private final YandexSearchFormPage yandexSearchFormPage = new YandexSearchFormPage();

    @Step("поле {0} заполнил значением {1}")
    public void fillField(String field, String value){
        switch (field){
            case  "Поиск":
                yandexSearchFormPage.fillField(yandexSearchFormPage.fieldSearch, value);
                break;
            default:  throw new AssertionError("Поле '" + field + "' не объявлено на странице");
        }
    }

    @Step("нажал на кнопку \"Найти\"")
    public void search() {
        yandexSearchFormPage.buttonSearch.click();
    }

    @Step("проверил наличие поля и кнопки для поиска")
    public void checkSearchForm() {
        Assert.assertTrue("Поле ввода для поиска не отобразилось", yandexSearchFormPage.fieldSearch.isDisplayed());
        Assert.assertTrue("Кнопка для поиска не отобразилась", yandexSearchFormPage.buttonSearch.isDisplayed());
    }
}
