import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class HomePage {

    private final WebDriver driver;
    public String pageTitle;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        pageTitle=driver.getTitle();
        if (!"Войти | Панель управления".equals(driver.getTitle())) {

        }
    }

    public AddEntry addEntry(){//        driver.navigate().to("https://igorakintev.ru/admin/blog/entry/add/");
        driver.findElement(By.cssSelector("#module_2 > div:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)")).click();
        return new AddEntry(driver);
    }

    public DeleteEntry deleteEntry(){//        driver.navigate().to("https://igorakintev.ru/admin/blog/entry/add/");
        driver.findElement(By.cssSelector("#module_2 > div:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)")).click();
        return new DeleteEntry(driver);
    }
}
