package lesson06.c_implicitly_waits_helps_for_first_appearance;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;


public class FirstTest {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();}

    @Test
    public void firstResultShouldContainExpectedText() {
        String query = "Dress";
        driver.findElement(By.id("search_query_top")).click();
        driver.findElement(By.id("search_query_top")).sendKeys(query);
   //     driver.findElement(By.id("search_query_top")).submit();
        assertThat(driver.findElement(By.xpath("//*[@id='index']/div[2]/ul/li[1]")).getText(),containsString(query));
        driver.findElement(By.id("search_query_top")).clear();

        String query2 = "T-shirt";
        driver.findElement(By.id("search_query_top")).click();
        driver.findElement(By.id("search_query_top")).sendKeys(query2);
        assertThat(driver.findElement(By.xpath("//*[@id='index']/div[2]/ul/li[contains(text(),'" + query2 + "') and position()=1]")).getText(),containsString(query2));
    }
}


