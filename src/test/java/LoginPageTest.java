import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {
    private WebDriver driver;
    private LoginPage log;


    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver");
        driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://igorakintev.ru/admin/");
        log=new LoginPage(driver);
    }

    @Test
    public void testLoginValidationTrue(){
        Assert.assertTrue(log.loginAs("selenium","super_password"));
    }

    @Test
    public void testLoginValidationLoginEmpty(){
        Assert.assertFalse(log.loginAs("","super_password"));
    }

    @Test
    public void testLoginValidationPswdEmpty(){
        Assert.assertFalse(log.loginAs("selenium",""));
    }

    @Test
    public void testLoginValidationInputErrText(){
        log.loginAs("","super_password");
        log.submitLogin();
        Assert.assertEquals("Обязательное поле.",log.errLoginInputText());
    }

    @Test
    public void testLoginValidationPswdErrText(){
        log.loginAs("selenium","");
        log.submitLogin();
        Assert.assertEquals("Обязательное поле.",log.errPswdInputText());
    }

    @Test
    public void testFalseLoginPswd(){
        log.loginAs("tt","tt");
        log.submitLogin();
        Assert.assertEquals("Пожалуйста, введите корректные имя пользователя и пароль для аккаунта. Оба поля могут быть чувствительны к регистру.",log.errLoginPswd());
    }

    @Test
    public void testSuccessLogin(){
        log.loginAs("selenium","super_password");
        HomePage home=log.submitLogin();
        Assert.assertEquals("Войти | Панель управления",home.pageTitle);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
