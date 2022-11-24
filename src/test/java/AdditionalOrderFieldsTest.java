/* Не очень понятно сформулирован текст задания

 * Я проверяю, что если ввести некорректные данные (на ощупь, потому что требований у меня нет ¯\_(ツ)_/¯),
 * то высвечивается ошибка.
 *
 * Надеюсь, что я правильно поняла задание
 *
 * Метро я не трогала, потому что там страшная пустая страница высвечивается
 * \*/

import PageObjects.FrontPage;
import PageObjects.OrderScooterPage;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.xpath;


@RunWith(Parameterized.class)
public class AdditionalOrderFieldsTest {
    private final By orderButton;
    private final String name;
    private final String lastName;
    private final String address;
    private final String metro;
    private final String phoneNumber;

    public AdditionalOrderFieldsTest(By orderButton, String name, String lastName, String address, String metro, String phoneNumber) {
        this.orderButton = orderButton;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.metro = metro;
        this.phoneNumber = phoneNumber;
    }

    @Parameterized.Parameters
    public static Object[][] getFieldInfo() {
        return new Object[][]{
                {className("Button_Button__ra12g"), "asdf", "asdf", "asdf", "Черкизовская", "1234"}, // Проверяем, что высвечивается ошибка, когда вводим латиницу
                {xpath(".//div[@class='Home_FinishButton__1_cWm']/button"), "", "", "", "Курская", ""}, // Проверяем, что высвечивается ошибка, когда поля оставлены пустыми
        };
    }

    private WebDriver driver;

    @Test
    public void checkIncorrectMessages() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru");

        FrontPage objFrontPage = new FrontPage(driver);

        objFrontPage.clickOrderScooterButton(orderButton);
        objFrontPage.waitForNextPageToLoad();

        OrderScooterPage objOrder = new OrderScooterPage(driver);

        objOrder.fillPersonalInfo(name, lastName, address, metro, phoneNumber);
        assertTrue("Should have message below 'Name' field", objOrder.checkIncorrectNameTrue());
        assertTrue("Should have message below 'Last Name' field", objOrder.checkIncorrectLastNameTrue());
        assertTrue("Should have message below 'Address' field", objOrder.checkIncorrectAddressTrue());
        assertTrue("Should have message below 'Phone Number' field", objOrder.checkIncorrectPhoneNumberTrue());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

