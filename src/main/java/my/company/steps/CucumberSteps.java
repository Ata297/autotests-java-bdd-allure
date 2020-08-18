package my.company.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import my.company.steps.sberbankDemo.ConfirmLoginSteps;
import my.company.steps.sberbankDemo.LoginSteps;
import my.company.steps.sberbankDemo.TrainingChoiceSteps;
import my.company.steps.yandex.SearchFormSteps;
import my.company.steps.yandex.SearchResultSteps;

import java.util.List;


public class CucumberSteps {

    BaseSteps baseSteps = new BaseSteps();
    LoginSteps loginSteps = new LoginSteps();
    ConfirmLoginSteps confirmLoginSteps = new ConfirmLoginSteps();
    TrainingChoiceSteps trainingChoiceSteps = new TrainingChoiceSteps();

    SearchFormSteps searchFormSteps = new SearchFormSteps();
    SearchResultSteps searchResultSteps = new SearchResultSteps();

    @When("^перешли на начальную страницу Сбербанк демо")
    public void stepGoToSberbankDemo() {
        baseSteps.goToSberbankDemo();
    }

    @Then("^скрыли подсказки")
    public void stepHideTooltips() {
        loginSteps.hideTooltips();;
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

    @When("^перешли на страницу поиска Яндекса")
    public void stepGoToYandex() {
        baseSteps.goToYandex();
    }

    @Then("^отобразилась форма поиска")
    public void stepCheckSearchForm() {
        searchFormSteps.checkSearchForm();
    }

    @Then("^отобразился список результатов с записью:$")
    public void stepCheckSearchResult(DataTable fields){
        String link = "";
        String title = "";

        for (List<String> field : fields.asLists(String.class)) {
            switch (String.valueOf(field.toArray()[0])){
                case  "Ссылка":
                    link = String.valueOf(field.toArray()[1]);
                    break;
                case  "Заголовок":
                    title = String.valueOf(field.toArray()[1]);
                    break;
                default:  throw new AssertionError("Поле '" + String.valueOf(field.toArray()[0]) + "' не объявлено в реестре");
            }
        }

        searchResultSteps.checkSearchRecord(link, title);
    }

    @Then("^перешли по ссылке \"(.+)\" с заголовком \"(.+)\" из результата поиска")
    public void stepLinkTo(String link, String title){
        searchResultSteps.linkTo(link, title);
    }

    @Then("^отобразилась форма авторизации в Сбербанк онлайн")
    public void stepCheckLoginForm() {
        // loginSteps.checkLoginForm(); // уже не Сбербанк демо
    }

    @When("^заполнили поля в окне \"(.+)\":$")
    public void stepFillForm(String windowName, DataTable fields){

        switch (windowName){
            case  "Вход":
                fields.asMap(String.class, String.class)
                        .forEach((field, value) -> loginSteps.fillField(field, value));
                break;
            case  "Подтверждение входа":
                fields.asMap(String.class, String.class)
                        .forEach((field, value) -> confirmLoginSteps.fillField(field, value));
                break;
            case  "Яндекс":
                fields.asMap(String.class, String.class)
                        .forEach((field, value) -> searchFormSteps.fillField(field, value));
                break;
            default:  throw new AssertionError("Окно '" + windowName + "' не объявлено в реестре");
        }
    }

    @When("^нажали на кнопку \"(.+)\"$")
    public void stepClickToButton(String buttonName) {
        switch (buttonName){
            case  "Войти":
                loginSteps.login();
                break;
            case  "Подтвердить":
                confirmLoginSteps.confirm();
                break;
            case  "Найти":
                searchFormSteps.search();
                break;
            default:  throw new AssertionError("Действие '" + buttonName + "' не объявлено в реестре");
        }
    }
}
