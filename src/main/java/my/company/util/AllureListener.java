package my.company.util;

import my.company.steps.BaseSteps;
import org.junit.runner.notification.Failure;
import ru.yandex.qatools.allure.junit.AllureRunListener;

/***
 * Обработчик для отчета Allure.
 */
public class AllureListener extends AllureRunListener {

    @Override
    public void testFailure(Failure failure){
        BaseSteps.takeScreenshot();
        super.testFailure(failure);
    }
}
