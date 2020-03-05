import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class HomePageTest {
    private WebDriver driver;
    private HomePage homePage;


    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver");
        driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://igorakintev.ru/admin/");
        LoginPage log=new LoginPage(driver);
        log.loginAs("selenium","super_password");
        homePage=log.submitLogin();
    }

    @Test
    public void addEntyPage(){
        AddEntry addEntryPage=homePage.addEntry();
        Assert.assertEquals(addEntryPage.pageTitle,"Добавить entry | Панель управления");
    }

    @Test
    public void deleteEntyPage(){
        DeleteEntry addEntryPage=homePage.deleteEntry();
        Assert.assertEquals(addEntryPage.pageTitle,"Выберите entry для изменения | Панель управления");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
