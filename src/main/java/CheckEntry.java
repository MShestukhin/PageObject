import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckEntry {
    private final WebDriver driver;
    public CheckEntry(WebDriver driver) {
        this.driver = driver;
    }

    public boolean findEntry(String entry_name){
        try {
            driver.findElement(By.xpath("//a[text()='"+entry_name+"']"));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
