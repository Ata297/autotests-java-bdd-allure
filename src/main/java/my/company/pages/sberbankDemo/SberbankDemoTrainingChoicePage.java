package my.company.pages.sberbankDemo;

import my.company.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/***
 * Страница выбора обучения в Сбербанк (демо).
 */
public class SberbankDemoTrainingChoicePage extends BasePage {

    @FindBy(xpath = "//h3[text() = 'Какому действию Вы хотите научиться?']")
    public WebElement textTrainingChoice;
}
