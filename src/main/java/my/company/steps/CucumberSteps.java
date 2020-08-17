package my.company.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import my.company.steps.sberbankDemo.ConfirmLoginSteps;
import my.company.steps.sberbankDemo.LoginSteps;
import my.company.steps.sberbankDemo.TrainingChoiceSteps;


public class CucumberSteps {

    BaseSteps baseSteps = new BaseSteps();
    LoginSteps loginSteps = new LoginSteps();
    ConfirmLoginSteps confirmLoginSteps = new ConfirmLoginSteps();
    TrainingChoiceSteps trainingChoiceSteps = new TrainingChoiceSteps();

    @When("^перешли на начальную страницу Сбербанк демо")
    public void stepGoToStartPage() {
        baseSteps.goToSberbankDemo();
    }

    @Then("^скрыли подсказки")
    public void stepHideTooltips() {
        loginSteps.hideTooltips();;
    }

    @When("^заполнили поля в окне \"(.+)\":$")
    public void fillForm(String windowName, DataTable fields){

        switch (windowName){
            case  "Вход":
                fields.asMap(String.class, String.class)
                        .forEach((field, value) -> loginSteps.fillField(field, value));
                break;
            case  "Подтверждение входа":
                fields.asMap(String.class, String.class)
                        .forEach((field, value) -> confirmLoginSteps.fillField(field, value));
                break;
            default:  throw new AssertionError("Окно '" + windowName + "' не объявлено в реестре");
        }
    }

    @When("^нажали на кнопку \"(.+)\"$")
    public void stepLogin(String buttonName) {
        switch (buttonName){
            case  "Войти":
                loginSteps.login();
                break;
            case  "Подтвердить":
                confirmLoginSteps.confirm();
                break;
            default:  throw new AssertionError("Действие '" + buttonName + "' не объявлено в реестре");
        }
    }

    @Then("^появилась ошибка")
    public void stepCheckErrorDisplay() {
        loginSteps.checkErrorDisplay();
    }

    @Then("^появилось окно \"(.+)\"$")
    public void stepCheckWindow(String windowName) {
        switch (windowName){
            case  "Подтверждение входа":
                confirmLoginSteps.checkTitle(windowName);
                break;
            case  "Какому действию Вы хотите научиться?":
                trainingChoiceSteps.checkTitle(windowName);
                break;
            default:  throw new AssertionError("Окно '" + windowName + "' не объявлено в реестре");
        }
    }
}
