package page;

import core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderForRentPage extends BasePage {
    // Локатор поля когда привезти
    @FindBy(xpath = "//input[@placeholder='* Когда привезти самокат']")
    private WebElement dateField;
    // Локатор поля срок аренды
    @FindBy(xpath = "//div[text()='* Срок аренды']")
    private WebElement rentalField;
    // Локатор для выбора срока аренды
    @FindBy(xpath = "//div[text()='четверо суток']")
    private WebElement dateRental;
    // Локатор кнопки Заказать
    @FindBy(xpath = "//div[contains(@class,'Order_Buttons')]//button[text()='Заказать']")
    private WebElement ordersButton;
    // Локатор копки Подтвержедния заказа
    @FindBy(xpath = "//button[text()='Да']")
    private WebElement buttonYesConfirmation;
    // Локатор окна с данными заказа
    @FindBy(xpath = "//div[text()='Заказ оформлен']")
    private WebElement dataOrder;

    // Метод заполнения поля когда привезти
    public void inputDate(String date) {
        dateField.sendKeys(date, Keys.ENTER); }
    // Метод заполнения поля срока аренды
    public void dateRenta () throws InterruptedException {
            rentalField.click();
            dateRental.click(); }
        // Метод нажатия на кнопку Заказать
        public void clickOrder () {
            ordersButton.click();
        }
        // Метод нажатия на кнопку подтвержения заказа
        public void clickButtonYesConfirmation () {
            buttonYesConfirmation.click();
        }
        // Метод ожидания появления окна c данными заказа
        public void waitForDataOrder () {
            dataOrder.isDisplayed();
        }
    public OrderForRentPage() {
            PageFactory.initElements(driver, this);
        }
}
