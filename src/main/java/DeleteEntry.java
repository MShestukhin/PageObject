import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class DeleteEntry {
    private final WebDriver driver;
    public String pageTitle;
    public DeleteEntry(WebDriver driver) {
        this.driver = driver;
        pageTitle=driver.getTitle();
        System.out.println(pageTitle);
        if (!"Выберите entry для изменения | Панель управления".equals(pageTitle)) {
            throw new IllegalStateException("This is not the login page");
        }
    }

    public DeleteEntry confirm(){
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        return this;
    }

    public DeleteEntry delete(){
        driver.findElement(By.cssSelector(".deletelink")).click();
        return confirm();
    }

    public DeleteEntry findTitle(String str){
        try {
            driver.findElement(By.xpath("//a[text()='"+str+"']")).click();
        } catch (NoSuchElementException e) {
            return this;
        }
        return delete();
    }
}
