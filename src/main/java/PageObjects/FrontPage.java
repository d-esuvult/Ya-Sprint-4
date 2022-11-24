package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrontPage {
    private final WebDriver driver;


    // Локаторы для статуса заказа
    private final By orderStatus = By.className("Header_Link__1TAG7"); // Кнопка "Статус заказа"
    private final By statusField = By.xpath(".//input[@class='Input_Input__1iN_Z Header_Input__xIoUq']"); // Поле "Статус заказа", открывается по клику на кнопку
    private final By goButton = By.xpath(".//button[contains(text(),'Go')]"); // Кнопка "Go"
    private final By trackNotFound = By.xpath(".//img[@src='/assets/not-found.png']"); // Страница "Такого заказа нет"


    // Локаторы для лого
    private final By logoScooter = By.className("Header_LogoScooter__3lsAR"); // Лого "Скутер"
    private final By logoYandex = By.xpath(".//img[@src='/assets/ya.svg']"); // Лого "Яндекс"



    // Локаторы заголовков панелей
    private final By headingOne = By.id("accordion__heading-0");
    private final By headingTwo = By.id("accordion__heading-1");
    private final By headingThree = By.id("accordion__heading-2");
    private final By headingFour = By.id("accordion__heading-3");
    private final By headingFive = By.id("accordion__heading-4");
    private final By headingSix = By.id("accordion__heading-5");
    private final By headingSeven = By.id("accordion__heading-6");
    private final By headingEight = By.id("accordion__heading-7");


    // Локаторы текстов в панелях
    private final By panelOne = By.id("accordion__panel-0");
    private final By panelTwo = By.id("accordion__panel-1");
    private final By panelThree = By.id("accordion__panel-2");
    private final By panelFour = By.id("accordion__panel-3");
    private final By panelFive = By.id("accordion__panel-4");
    private final By panelSix = By.id("accordion__panel-5");
    private final By panelSeven = By.id("accordion__panel-6");
    private final By panelEight = By.id("accordion__panel-7");


    public FrontPage(WebDriver driver){
        this.driver = driver;
    }


    public void clickOrderScooterButton(By orderButton){
        WebElement element = driver.findElement(orderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(orderButton).click();
    }

    public void clickOrderStatusButton(){
        driver.findElement(orderStatus).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(statusField));
    }

    public void enterNonExistentOrderNumber(){
        driver.findElement(statusField).click();
        driver.findElement(statusField).sendKeys("0");
    }
    public void clickGoButton(){
        driver.findElement(goButton).click();
    }

    public boolean trackWasNotFound(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(trackNotFound));
        return driver.findElement(trackNotFound).isDisplayed();
    }

    public void clickScooterLogo(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(logoScooter));
        driver.findElement(logoScooter).click();
    }
    public void clickYandexLogo(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(logoYandex));
        driver.findElement(logoYandex).click();
    }


    public void waitForNextPageToLoad(){
        new WebDriverWait(driver, 3);
    }

    public void scrollToPanels(){ // Прокрутить страницу до первой панели
        WebElement element = driver.findElement(headingOne);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void waitForPanelsToBeClickable(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(headingOne));
    }

    public String getTextPanelOne(){
        driver.findElement(headingOne).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(panelOne));
        return driver.findElement(panelOne).getText();
    }

    public String getTextPanelTwo(){
        driver.findElement(headingTwo).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(panelTwo));
        return driver.findElement(panelTwo).getText();
    }

    public String getTextPanelThree(){
        driver.findElement(headingThree).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(panelThree));
        return driver.findElement(panelThree).getText();
    }

    public String getTextPanelFour(){
        driver.findElement(headingFour).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(panelFour));
        return driver.findElement(panelFour).getText();
    }

    public String getTextPanelFive(){
        driver.findElement(headingFive).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(panelFive));
        return driver.findElement(panelFive).getText();
    }

    public String getTextPanelSix(){
        driver.findElement(headingSix).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(panelSix));
        return driver.findElement(panelSix).getText();
    }

    public String getTextPanelSeven(){
        driver.findElement(headingSeven).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(panelSeven));
        return driver.findElement(panelSeven).getText();
    }

    public String getTextPanelEight(){
        driver.findElement(headingEight).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(panelEight));
        return driver.findElement(panelEight).getText();
    }
}
