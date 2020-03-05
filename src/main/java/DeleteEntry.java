import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteEntry {
    private final WebDriver driver;
    public DeleteEntry(WebDriver driver) {
        this.driver = driver;
//        if (!"Панельуправления".equals(driver.getTitle())) {
//            throw new IllegalStateException("This is not the login page");
//        }
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
        driver.findElement(By.xpath("//a[text()='"+str+"']")).click();
        return delete();
    }
}
