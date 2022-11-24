import PageObjects.FrontPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AdditionalLogoTest {

    WebDriver driver = new ChromeDriver();

    @Before
    public void getPage(){
        driver.get("https://qa-scooter.praktikum-services.ru");
    }



    @Test
    public void checkScooterLogo() {
        FrontPage front = new FrontPage(driver);
        front.clickScooterLogo();
        assertEquals("https://qa-scooter.praktikum-services.ru/", driver.getCurrentUrl());
    }

    @Test
    public void checkYandexLogo() {
        FrontPage front = new FrontPage(driver);

        front.clickYandexLogo(); // При клике открывается новая вкладка
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1)); // Переключаемся на новую вкладку
        assertEquals("ya.ru", driver.getCurrentUrl());

    }

    @After
    public void teardown(){
        driver.quit();
    }
}
