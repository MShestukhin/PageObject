import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddEntry {

    private final WebDriver driver;
    By title = By.id("id_title");
    By slug = By.id("id_slug");
    By text_markdown = By.id("id_text_markdown");
    By text = By.id("id_text");
    By submit = By.name("_save");

    public AddEntry(WebDriver driver) {
        this.driver = driver;
//        if (!"Панельуправления".equals(driver.getTitle())) {
//            throw new IllegalStateException("This is not the login page");
//        }
    }

    public AddEntry typeTitle(String title_str) {
        driver.findElement(title).sendKeys(title_str);
        return this;
    }

    public AddEntry typeSlug(String slug_str) {
        driver.findElement(slug).sendKeys(slug_str);
        return this;
    }

    public AddEntry typeTextMarkdown(String text_markdown_str) {
        driver.findElement(text_markdown).sendKeys(text_markdown_str);
        return this;
    }

    public AddEntry typeText(String text_str) {
        driver.findElement(text).sendKeys(text_str);
        return this;
    }

    public AddEntry submit() {
        driver.findElement(submit).submit();
        return new AddEntry(driver);
    }

    public AddEntry sendEntry(String title_str, String slug_str,String text_markdown_str, String text_str) {
        typeTitle(title_str);
        typeSlug(slug_str);
        typeTextMarkdown(text_markdown_str);
        typeText(text_str);
        return submit();
    }

    public AddEntry add(){
//        System.out.println(driver.findElement(By.xpath("//*[@id='module_2']/div/ul[1]/li[1]/ul/li[1]/a")).getAttribute("href"));
//        driver.navigate().to("https://igorakintev.ru/admin/blog/entry/add/");
        System.out.println("1");

//        driver.findElement(By.cssSelector("#module_2 > div:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)")).click();
//        System.out.println("sdfa");
        return new AddEntry(driver);
    }
}
