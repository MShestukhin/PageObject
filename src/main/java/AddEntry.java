import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddEntry {

    private final WebDriver driver;
    By title = By.id("id_title");
    By slug = By.id("id_slug");
    By text_markdown = By.id("id_text_markdown");
    By text = By.id("id_text");
    By submit = By.name("_save");
    public String pageTitle;

    public AddEntry(WebDriver driver) {
        this.driver = driver;
        pageTitle=driver.getTitle();
        if (!"Добавить entry | Панель управления".equals(pageTitle)) {
            throw new IllegalStateException("This is not the login page");
        }
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

    public String entryTitleEmptyError() {
        String errStr=driver.findElement(By.cssSelector("#entry_form > div > fieldset > div.form-row.errors.field-title > ul > li")).getText();
        return errStr;
    }

    public String entrySlugEmptyError() {
        String errStr=driver.findElement(By.cssSelector("#entry_form > div > fieldset > div.form-row.errors.field-slug > ul > li")).getText();
        return errStr;
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
}
