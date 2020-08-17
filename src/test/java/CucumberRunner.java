import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/"},
        glue = {"my.company.steps"},
        plugin = {
                "my.company.util.AllureReporter",
        },
        tags = {"~@ignore"}
)
public class CucumberRunner {

}