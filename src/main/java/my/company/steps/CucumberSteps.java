package my.company.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberSteps {

    BaseSteps baseSteps = new BaseSteps();
    LoginSteps loginSteps = new LoginSteps();

    @When("^перешли на начальную страницу Сбербанк демо")
    public void stepGoToStartPage() {
        baseSteps.goToStartPage();
    }

    @Then("^скрыли подсказки")
    public void stepHideTooltips() {
        loginSteps.hideTooltips();;
    }

    @When("^нажали на кнопку \"Войти\"")
    public void stepLogin() {
        loginSteps.login();
    }

    @Then("^появилась ошибка")
    public void stepCheckErrorDisplay() {
        loginSteps.checkErrorDisplay();
    }
}
