import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class HomePage {

    private final WebDriver driver;
    By title = By.id("id_title");
    By slug = By.id("id_slug");
    By text_markdown = By.id("id_text_markdown");
    By text = By.id("id_text");
    By submit = By.xpath("//input[@type='submit']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
//        if (!"Панельуправления".equals(driver.getTitle())) {
//            throw new IllegalStateException("This is not the login page");
//        }
    }

    public AddEntry add(){//        driver.navigate().to("https://igorakintev.ru/admin/blog/entry/add/");

        driver.findElement(By.cssSelector("#module_2 > div:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)")).click();
//        System.out.println("sdfa");
        return new AddEntry(driver);
    }
}
