package my.company.pages.yandex;

import my.company.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/***
 * Страница поиска в Яндекс.
 */
public class SearchFormPage extends BasePage {

    @FindBy(xpath = "//input[@aria-label = 'Запрос']")
    public WebElement fieldSearch;

    @FindBy(xpath = "//span[text() = 'Найти']/../../button")
    public WebElement buttonSearch;
}
