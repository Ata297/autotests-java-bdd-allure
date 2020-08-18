package my.company.steps.yandex;

import my.company.pages.yandex.SearchFormPage;
import org.junit.Assert;
import ru.yandex.qatools.allure.annotations.Step;


/***
 * Шаги для страницы поиска в Яндексе.
 */
public class SearchFormSteps {

    private final SearchFormPage searchFormPage = new SearchFormPage();

    @Step("поле {0} заполнил значением {1}")
    public void fillField(String field, String value){
        switch (field){
            case  "Поиск":
                searchFormPage.fillField(searchFormPage.fieldSearch, value);
                break;
            default:  throw new AssertionError("Поле '" + field + "' не объявлено на странице");
        }
    }

    @Step("нажал на кнопку \"Найти\"")
    public void search() {
        searchFormPage.buttonSearch.click();
    }

    @Step("проверил наличие поля и кнопки для поиска")
    public void checkSearchForm() {
        Assert.assertTrue("Поле ввода для поиска не отобразилось", searchFormPage.fieldSearch.isDisplayed());
        Assert.assertTrue("Кнопка для поиска не отобразилась", searchFormPage.buttonSearch.isDisplayed());
    }
}
