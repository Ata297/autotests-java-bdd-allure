package my.company.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import my.company.util.TestProperties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


/***
 * Базовые шаги.
 */
public class BaseSteps {
    public static WebDriver driver;
    public static String baseUrl;
    public static Properties properties = TestProperties.getInstance().getProperties();

    public static WebDriver getDriver() {
        return driver;
    }

    @Before
    public static void setUp() throws Exception {
        if ("firefox".equals(properties.getProperty("browser"))) {
            System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
            driver = new FirefoxDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
            driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public static void tearDown() throws Exception {
        driver.quit();
    }

    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Step("открыл демонстрационную страницу Сбербанка")
    public void goToSberbankDemo() {
        baseUrl = properties.getProperty("sberbankDemoUrl");
        System.out.println(baseUrl);

        driver.get(baseUrl);
    }

    @Step("открыл главную страницу Яндекса")
    public void goToYandex() {
        baseUrl = properties.getProperty("yandexUrl");
        System.out.println(baseUrl);

        driver.get(baseUrl);
    }

    @Step("открыл вторую вкладку в браузере")
    public void switchTo2Tab() {
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }
}