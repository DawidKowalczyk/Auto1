import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertEquals;


public class search {

    private FirefoxDriver driver;

    @Before
    public void SetUp() {
        driver = new FirefoxDriver();
        driver.get("https://www.autohero.com/de/search/");
        // need geckodriver and latest firefox



    }


    @Test
    public void Search() throws InterruptedException {

        WebElement elementToClick = driver.findElementByCssSelector("div.root___1ZGR8:nth-child(3) > div:nth-child(1)");
        elementToClick.click();
        //  instantiating first element to click (Erstzulassung)​
        WebElement elementToClick2 = driver.findElementByCssSelector("div.root___1ZGR8:nth-child(3) " + "> div:nth-child(2) > div:nth-child(1) > select:nth-child(4)");
        elementToClick2.click();
        // instantiating second element opening combo box
        Thread.sleep(2000);
        WebElement combo2015 = driver.findElementByCssSelector("#app > div > main > div.root___3C6lR.container > div " + "> div.col-md-3 > div > div > div > div:nth-child(3) > div.body___1Wz2l.clearfix > div > select > option:nth-child(5)");
        combo2015.click();
        // searching 2015
        Thread.sleep(2000);
        WebElement comboSort = driver.findElementByCssSelector("#app > div > main > div.root___3C6lR.container " + "> div > div.col-md-9 > div > div.root___26IzG > div.sort___MeITR > div > div > select > option:nth-child(3)");
        comboSort.click();
        // opening sort combo box
        WebElement hochster_preis = driver.findElementByCssSelector("div.form-control:nth-child(3) > select:nth-child(4)");
        hochster_preis.click();
        // instantiating (Höchster Preis​) element
        assertEquals("Erstzulassung von: 2015", driver.findElementByXPath("/html/body/div[1]/div/main/div[4]/div/div[2]/div/div[1]/ul/li[1]/button").getText());
        // Verify all cars are filtered by first registration (2015+​) by checking the filter applied
        assertEquals("Höchster Preis", driver.findElementByXPath("/html/body/div[1]/div/main/div[4]/div/div[2]/div/div[2]/div[3]/div/div/select/option[3]").getText());
        // Verify all cars are sorted by price descending checking "Höchster Preis" filter is applied to the page


    }

    @After
    public void close() {
        driver.close();
    }
}