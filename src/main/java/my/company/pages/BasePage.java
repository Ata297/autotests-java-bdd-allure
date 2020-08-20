package my.company.pages;

import my.company.steps.BaseSteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class BasePage {

    public BasePage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    /***
     * Заполнение поля ввода.
     *
     * @param field Поле ввода.
     * @param value Значение.
     */
    public void fillField(WebElement field, String value){
        field.clear();
        field.sendKeys(value);
    }
}
