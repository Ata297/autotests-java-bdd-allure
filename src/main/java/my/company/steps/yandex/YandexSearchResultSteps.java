package my.company.steps.yandex;

import my.company.pages.yandex.YandexSearchResultPage;
import org.junit.Assert;
import ru.yandex.qatools.allure.annotations.Step;


/***
 * Шаги для страницы результатов поиска в Яндексе.
 */
public class YandexSearchResultSteps {

    private final YandexSearchResultPage yandexSearchResultPage = new YandexSearchResultPage();

    @Step("проверил наличие записи с ссылкой {0} и заголовком {1}")
    public void checkSearchRecord(String link, String title) {
        Assert.assertNotNull("Запись не найдена", yandexSearchResultPage.selectTitleRecord(link, title));
    }

    @Step("нажал на ссылку {0} с заголовком {1}")
    public void linkTo(String link, String title) {
        yandexSearchResultPage.selectTitleRecord(link, title).click();
    }
}
