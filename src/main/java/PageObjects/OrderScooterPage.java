package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderScooterPage {
    private WebDriver driver;


    // Локаторы для полей страницы заказа
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");
    private final By lastNameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroField = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By metroDropDown = By.className("select-search__select");
    private final By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextPageButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button");
    private final By dateSelectionField = By.xpath(".//div[@class='react-datepicker__input-container']/input");
    private final By rentalDropDown = By.className("Dropdown-placeholder");
    private final By rentalOption = By.className("Dropdown-menu");
    private final By blackColourCheckbox = By.id("black");
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private final By yesButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");
    private final By checkStatusButton = By.xpath(".//div[(@class='Order_NextButton__1_rCA')]/button");


    public OrderScooterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void setLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void setMetro(String metro) {
        driver.findElement(metroField).sendKeys(metro);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(metroDropDown));
        driver.findElement(metroField).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(metroField).sendKeys(Keys.RETURN);

    }

    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void clickNextPageButton() {
        driver.findElement(nextPageButton).click();
    }

    public void fillPersonalInfo(String name, String lastName, String address, String metro, String phoneNumber) {
        setName(name);
        setLastName(lastName);
        setAddress(address);
        setMetro(metro);
        setPhoneNumber(phoneNumber);
        clickNextPageButton();
    }

    public void waitForNextPageToLoad() {
        new WebDriverWait(driver, 3);
    }


    public void setDeliveryDate(String date) {
        driver.findElement(dateSelectionField).click();
        driver.findElement(dateSelectionField).sendKeys(date);
        driver.findElement(By.className("App_App__15LM-")).click();
    }


    public void setRentalPeriod(String day) {
        driver.findElement(rentalDropDown).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(rentalOption));
        WebElement element = driver.findElement(By.xpath(".//div[(@class='Dropdown-option') and contains(text(),'" + day + "')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.xpath(".//div[(@class='Dropdown-option') and contains(text(),'" + day + "')]")).click();

    }

    public void clickBlackCheckbox() {
        driver.findElement(blackColourCheckbox).click();
    }

    public void setComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    public void clickDeliveryButton() {
        driver.findElement(orderButton).click();
    }

    public void fillDeliveryInfo(String date, String period, String comment) {
        setDeliveryDate(date);
        setRentalPeriod(period);
        clickBlackCheckbox();
        setComment(comment);
        clickDeliveryButton();
    }

    public void waitForPopUpWindow() {
        new WebDriverWait(driver, 3);
    }

    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }

    public boolean checkDeliveryConfirmation() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(checkStatusButton));
        return driver.findElement(checkStatusButton).isDisplayed();
    }

    // Локаторы для ошибок полей
    private final By incorrectInputName = By.xpath(".//div[contains(text(),'Введите корректное имя')]");
    private final By incorrectInputLastName = By.xpath(".//div[contains(text(),'Введите корректную фамилию')]");
    private final By incorrectInputAddress = By.xpath(".//div[contains(text(),'Введите корректный адрес')]");
    private final By incorrectInputPhoneNumber = By.xpath(".//div[contains(text(),'Введите корректный номер')]");

    public boolean checkIncorrectNameTrue(){
        return driver.findElement(incorrectInputName).isDisplayed();
    }

    public boolean checkIncorrectLastNameTrue(){
        return driver.findElement(incorrectInputLastName).isDisplayed();
    }

    public boolean checkIncorrectAddressTrue(){
        return driver.findElement(incorrectInputAddress).isDisplayed();
    }

    public boolean checkIncorrectPhoneNumberTrue(){
        return driver.findElement(incorrectInputPhoneNumber).isDisplayed();
    }

}
