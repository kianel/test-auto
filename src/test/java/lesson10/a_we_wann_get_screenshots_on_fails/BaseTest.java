package lesson10.a_we_wann_get_screenshots_on_fails;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest extends SimpleAPI {

    protected static WebDriver driver;


    @Rule
    public TestWatcher watcher = new TestWatcher(){

        @Override
        protected void failed(Throwable e, Description description) {
            captureScreenshot(description.getMethodName());
        }

        private void captureScreenshot(String methodName) {
            File screenshot = ((TakesScreenshot)driver)
                    .getScreenshotAs(OutputType.FILE);
            String path = System.getProperty("report.path")
                    + "/screenshots/" + screenshot.getName();

            try {
                FileUtils.copyFile(screenshot,new File(path))
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Override
    WebDriver getWebDriver() {
        return driver;
    }

    static {
        if(System.getProperty("report.path") == null){
            Date dateNow = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            System.setProperty("report.path", "./reports/IDE-test-build-" + format.format(dateNow));
        }
    }
}