
import PageObjects.FrontPage;
import PageObjects.OrderScooterPage;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.xpath;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class OrderScooterTest {
    private final By orderButton;
    private final String name;
    private final String lastName;
    private final String address;
    private final String metro;
    private final String phoneNumber;
    private final String date;
    private final String period;
    private final String comment;

    public OrderScooterTest(By orderButton, String name, String lastName, String address, String metro, String phoneNumber, String date, String period, String comment) {
        this.orderButton = orderButton;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.metro = metro;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.period = period;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getFieldInfo() {
        return new Object[][]{
                {className("Button_Button__ra12g"), "Кира", "Йошикаге", "Япония, северо-восточная часть Морио, 33.", "Черкизовская", "89998887766", "19.12.2022", "сутки", "Байтс зе даст"},
                {xpath(".//div[@class='Home_FinishButton__1_cWm']/button"),"Дио", "Брандо", "Великобритания, поместье Джо-Джо, 12.", "Курская", "89998887766", "01.01.2023", "семеро суток", "Коно Дио да"},
        };
    }

    private WebDriver driver;

    @Test
    public void checkOrderCompletion() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru");

        FrontPage objFrontPage = new FrontPage(driver);

        objFrontPage.clickOrderScooterButton(orderButton);
        objFrontPage.waitForNextPageToLoad();

        OrderScooterPage objOrder = new OrderScooterPage(driver);

        objOrder.fillPersonalInfo(name, lastName, address, metro, phoneNumber);
        objOrder.waitForNextPageToLoad();
        objOrder.fillDeliveryInfo(date, period, comment);
        objOrder.waitForPopUpWindow();
        objOrder.clickYesButton();
        assertEquals("The pop-up window 'The order has been placed' should have appeared",true, objOrder.checkDeliveryConfirmation());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

