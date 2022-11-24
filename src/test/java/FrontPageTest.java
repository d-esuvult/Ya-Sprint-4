import PageObjects.FrontPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;


public class FrontPageTest {
    private WebDriver driver = new ChromeDriver();
    private final String answerOne = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private final String answerTwo = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private final String answerThree = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private final String answerFour = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private final String answerFive = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private final String answerSix = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private final String answerSeven = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private final String answerEight = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";


    @Before
    public void getPanels() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        FrontPage objFront = new FrontPage(driver);
        objFront.scrollToPanels();
        objFront.waitForPanelsToBeClickable();
    }

    @Test
    public void firstTextShouldBeEqual(){
        FrontPage objPanel = new FrontPage(driver);
        assertEquals("First FAQ panel has an incorrect text message", answerOne, objPanel.getTextPanelOne());
    }

    @Test
    public void secondTextShouldBeEqual(){
        FrontPage objPanel = new FrontPage(driver);
        assertEquals("Second FAQ panel has an incorrect text message", answerTwo, objPanel.getTextPanelTwo());
    }

    @Test
    public void thirdTextShouldBeEqual(){
        FrontPage objPanel = new FrontPage(driver);
        assertEquals("Third FAQ panel has an incorrect text message", answerThree, objPanel.getTextPanelThree());
    }

    @Test
    public void fourthTextShouldBeEqual(){
        FrontPage objPanel = new FrontPage(driver);
        assertEquals("Fourth FAQ panel has an incorrect text message", answerFour, objPanel.getTextPanelFour());
    }

    @Test
    public void fifthTextShouldBeEqual(){
        FrontPage objPanel = new FrontPage(driver);
        assertEquals("Fifth FAQ panel has an incorrect text message", answerFive, objPanel.getTextPanelFive());
    }

    @Test
    public void sixthTextShouldBeEqual(){
        FrontPage objPanel = new FrontPage(driver);
        assertEquals("Sixth FAQ panel has an incorrect text message", answerSix, objPanel.getTextPanelSix());
    }

    @Test
    public void seventhTextShouldBeEqual(){
        FrontPage objPanel = new FrontPage(driver);
        assertEquals("Seventh FAQ panel has an incorrect text message", answerSeven, objPanel.getTextPanelSeven());
    }

    @Test
    public void eighthTextShouldBeEqual(){
        FrontPage objPanel = new FrontPage(driver);
        assertEquals("Eighth FAQ panel has an incorrect text message", answerEight, objPanel.getTextPanelEight());
    }


    @After
    public void teardown(){
        driver.quit();
    }

}

