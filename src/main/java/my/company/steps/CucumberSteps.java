package my.company.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import my.company.steps.sberbank.SberbankLoginSteps;
import my.company.steps.sberbankDemo.SberbankDemoConfirmLoginSteps;
import my.company.steps.sberbankDemo.SberbankDemoLoginSteps;
import my.company.steps.sberbankDemo.SberbankDemoTrainingChoiceSteps;
import my.company.steps.yandex.YandexSearchFormSteps;
import my.company.steps.yandex.YandexSearchResultSteps;

import java.util.List;


public class CucumberSteps {

    BaseSteps baseSteps = new BaseSteps();
    SberbankDemoLoginSteps sberbankDemoLoginSteps = new SberbankDemoLoginSteps();
    SberbankDemoConfirmLoginSteps sberbankDemoConfirmLoginSteps = new SberbankDemoConfirmLoginSteps();
    SberbankDemoTrainingChoiceSteps sberbankDemoTrainingChoiceSteps = new SberbankDemoTrainingChoiceSteps();

    YandexSearchFormSteps yandexSearchFormSteps = new YandexSearchFormSteps();
    YandexSearchResultSteps yandexSearchResultSteps = new YandexSearchResultSteps();

    SberbankLoginSteps sberbankLoginSteps = new SberbankLoginSteps();

    @When("^перешли на начальную страницу Сбербанк демо")
    public void stepGoToSberbankDemo() {
        baseSteps.goToSberbankDemo();
    }

    @Then("^скрыли подсказки")
    public void stepHideTooltips() {
        sberbankDemoLoginSteps.hideTooltips();;
    }

    @Then("^появилась ошибка \"(.+)\"$")
    public void stepCheckError(String testError) {
        sberbankDemoLoginSteps.checkError(testError);
    }

    @Then("^появилось окно \"(.+)\"$")
    public void stepCheckWindow(String windowName) {
        switch (windowName){
            case  "Подтверждение входа":
                sberbankDemoConfirmLoginSteps.checkTitle(windowName);
                break;
            case  "Какому действию Вы хотите научиться?":
                sberbankDemoTrainingChoiceSteps.checkTitle(windowName);
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
        yandexSearchFormSteps.checkSearchForm();
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

        yandexSearchResultSteps.checkSearchRecord(link, title);
    }

    @Then("^нажали по ссылке \"(.+)\" с заголовком \"(.+)\" из результата поиска")
    public void stepLinkTo(String link, String title){
        yandexSearchResultSteps.linkTo(link, title);
    }

    @Then("^переключились на новую вкладку")
    public void stepSwitchToNewTab() {
        baseSteps.switchTo2Tab();
    }

    @Then("^отобразилась форма авторизации в Сбербанк онлайн")
    public void stepCheckLoginForm() {
        sberbankLoginSteps.checkFieldLogin();
        sberbankLoginSteps.checkFieldPassword();
        sberbankLoginSteps.checkButtonLogin();
    }

    @When("^заполнили поля в окне \"(.+)\":$")
    public void stepFillForm(String windowName, DataTable fields){

        switch (windowName){
            case  "Вход":
                fields.asMap(String.class, String.class)
                        .forEach((field, value) -> sberbankDemoLoginSteps.fillField(field, value));
                break;
            case  "Подтверждение входа":
                fields.asMap(String.class, String.class)
                        .forEach((field, value) -> sberbankDemoConfirmLoginSteps.fillField(field, value));
                break;
            case  "Яндекс":
                fields.asMap(String.class, String.class)
                        .forEach((field, value) -> yandexSearchFormSteps.fillField(field, value));
                break;
            default:  throw new AssertionError("Окно '" + windowName + "' не объявлено в реестре");
        }
    }

    @When("^нажали на кнопку \"(.+)\"$")
    public void stepClickToButton(String buttonName) {
        switch (buttonName){
            case  "Войти":
                sberbankDemoLoginSteps.login();
                break;
            case  "Подтвердить":
                sberbankDemoConfirmLoginSteps.confirm();
                break;
            case  "Найти":
                yandexSearchFormSteps.search();
                break;
            default:  throw new AssertionError("Действие '" + buttonName + "' не объявлено в реестре");
        }
    }
}
