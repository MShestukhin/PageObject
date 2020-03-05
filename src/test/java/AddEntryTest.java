import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class AddEntryTest {
    private WebDriver driver;
    private AddEntry entry;
    HomePage homePage;
    private final String title="Title43565463456";

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver");
        driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://igorakintev.ru/admin/");
        LoginPage log=new LoginPage(driver);
        log.loginAs("selenium","super_password");
        homePage=log.submitLogin();
        entry=homePage.addEntry();
    }

    @Test
    public void emptyTitleTest(){
        AddEntry entry_new=entry.sendEntry("","Title43565463456","Title43565463456","Title43565463456");
        Assert.assertEquals("Обязательное поле.",entry_new.entryTitleEmptyError());
    }

    @Test
    public void entryAddTest(){
        entry.sendEntry(title,"Title43565463456","Title43565463456t","Title43565463456");
        driver.navigate().to("http://igorakintev.ru/blog/");
        CheckEntry check=new CheckEntry(driver);
        Assert.assertTrue(check.findEntry(title));
    }


    @After
    public void tearDown(){
        driver.navigate().to("https://igorakintev.ru/admin/");
        DeleteEntry deleteEntry=homePage.deleteEntry();
        deleteEntry.findTitle(title);
        driver.quit();
    }
}
