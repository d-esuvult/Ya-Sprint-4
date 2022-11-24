import PageObjects.FrontPage;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;


public class AdditionalOrderStatusTest {

    WebDriver driver = new ChromeDriver();

    @Test
    public void checkOrderNotFound(){
        driver.get("https://qa-scooter.praktikum-services.ru/");
        FrontPage objOrderStatus = new FrontPage(driver);

        objOrderStatus.clickOrderStatusButton();
        objOrderStatus.enterNonExistentOrderNumber();
        objOrderStatus.clickGoButton();
        assertTrue("The 'Track is not found' page hasn't appeared", objOrderStatus.trackWasNotFound());

    }

    @After
    public void teardown(){
        driver.quit();
    }

}
