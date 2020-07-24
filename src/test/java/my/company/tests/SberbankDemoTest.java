package my.company.tests;

import my.company.steps.BaseSteps;
import my.company.steps.LoginSteps;
import org.junit.Test;

import org.junit.Assert;
import ru.yandex.qatools.allure.annotations.Title;

/***
 * Тесты для демонстрационной странице Сбербанка.
 */
public class SberbankDemoTest extends BaseSteps {

    @Title("Открытие страницы демо-версии Сбербанк онлайн")
    @Test
    public void OpenSberbankDemoTest() {
        LoginSteps loginSteps = new LoginSteps();
        driver.get(baseUrl);

        loginSteps.hideTooltips();
        loginSteps.login();

        String textError = loginSteps.getTestError();
        System.out.println("textError:");
        System.out.println(textError);

        Assert.assertNotNull("Ошибка не появилась", textError);
    }

}
