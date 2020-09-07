import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day03_Dropdown {
   static  WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        // driver nesnesi oluşturduk.
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

     @Test
    public  void dropDown(){
        driver.get("http://amazon.com");
         WebElement dropDown =driver.findElement(By.id("searchDropdownBox"));
         Select select =new Select(dropDown);
         //select.getFirstSelectedOption();

        // select.selectByIndex(5);

         select.selectByVisibleText("Computers");

         select.selectByValue("search-alias=aps");
         List<WebElement>tumsecenekler = select.getOptions() ;
         for (WebElement w:tumsecenekler
              ) {
             System.out.println(w.getText());

         }
         System.out.println(tumsecenekler.size());



    }

}
