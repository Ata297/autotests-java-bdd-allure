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

        this.goToStartPage();
        loginSteps.hideTooltips();
        loginSteps.login();
        loginSteps.checkErrorDisplay();
    }
}
