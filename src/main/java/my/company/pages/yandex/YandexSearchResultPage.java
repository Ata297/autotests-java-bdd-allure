package my.company.pages.yandex;

import my.company.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/***
 * Страница результатов поиска в Яндекс.
 */
public class YandexSearchResultPage extends BasePage {

    @FindBy(xpath = "//li[@class = 'serp-item']")
    public WebElement recordResults;

    /***
     * Поиск заголовка по ссылки и тексту из поиска.
     *
     * @param link Искомая ссылка.
     * @param title Искомый текст.
     */
    public WebElement selectTitleRecord(String link, String title){
        String recordXpath = "//*[contains(text(), '" + link + "')]";

        String[] titleWords = title.split(" ");
        String titleXpath = recordXpath;
        for (int i = 0; i < titleWords.length; i++) {
            if (i == 0) {
                titleXpath = titleXpath + "/../../../../h2//*[contains(text(), '" + titleWords[i] + "')]";
            } else {
                titleXpath = titleXpath + "/following-sibling::*[contains(text(), '" + titleWords[i] + "')]";
            }
        }

        return recordResults.findElement(By.xpath(titleXpath));
    }
}
