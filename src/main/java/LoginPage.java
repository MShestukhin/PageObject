import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class LoginPage {
    By usernameLocator = By.id("id_username");
    By passwordLocator = By.id("id_password");
    By loginButtonLocator = By.xpath("//input[@type='submit']");

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage typeUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }

    public String errLoginInputText() {
        String errStr=driver.findElement(By.cssSelector("#login-form > div:nth-child(2) > ul > li")).getText();
        return errStr;
    }

    public String  errPswdInputText() {
        String errStr=driver.findElement(By.cssSelector("#login-form > div:nth-child(3) > ul > li")).getText();
        return errStr;
    }

    public String  errLoginPswd() {
        String errStr=driver.findElement(By.cssSelector(".errornote")).getText();
        return errStr;
    }

    public HomePage submitLogin() {
        driver.findElement(loginButtonLocator).submit();
        return new HomePage(driver);
    }

    public boolean loginAs(String username, String password) {
        if(username.isEmpty() || password.isEmpty()) {
            typeUsername(username);
            typePassword(password);
            return false;
        }
        else {
            typeUsername(username);
            typePassword(password);
            return true;
        }
    }
}
