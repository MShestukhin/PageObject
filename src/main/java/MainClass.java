
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class MainClass {


    public static void main(String[] args){


        String Title="Title43565463456";
        String Slug="Title43565463456";
        String Text_markdown="Title43565463456";
        String Text="Title43565463456";

        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver");
        WebDriver driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //add entry
        driver.get("https://igorakintev.ru/admin/");
        LoginPage log=new LoginPage(driver);
        HomePage home=log.loginAs("selenium","super_password");
        AddEntry entry=home.add();
        entry.sendEntry(Title,Slug,Text_markdown,Text);

        //check entry
        driver.navigate().to("http://igorakintev.ru/blog/");
        CheckEntry check=new CheckEntry(driver);
        boolean check_entry=check.findEntry(Text);

        //delete entry
        if(check_entry) {
            driver.navigate().to("https://igorakintev.ru/admin/blog/entry/");
            DeleteEntry deleteEntry=new DeleteEntry(driver);
            deleteEntry.findTitle(Title);
        }
        driver.quit();
    }
}
