package Page;

import Core.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.annotation.Nonnull;

// Класс главной страницы
public class MainPage extends BasePage {

    // Локатор кнопки закзать вверху страницы
    @FindBy(xpath = "//div[contains(@class, 'Header_Nav')]//button[text()='Заказать']")
    private WebElement orderInHeader;
    // Локатор списка FAQ
    @FindBy(xpath = "//div[text()='Вопросы о важном']")
    private WebElement listFaq;
    @FindBy(xpath = "//div[contains(@class, 'Header_Nav')]//button[text()='Заказать']")
    private WebElement orderButton;
    // Метод клика по кнопке заказать вверху страницы
    public void clickOrderInHeader() {
        orderInHeader.click();
    }
    public OrderForScooterPage openLoginPage(){
        orderButton.click();
        return new OrderForScooterPage();
    }
    // Метод прокрутки старницы к списку FAQ
    public void scrollToListFaq(){
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",listFaq); }
    // Метод cравнения текста в  списке FAQ . Проскролили до элемента и сравнили.
    public void checkTextInFaq(@Nonnull String caption, @Nonnull String selectText) {
        WebElement  headerText  = driver.findElement(By.xpath(String.format("//div[text()='%s']", caption)));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",headerText);
        headerText.click();
        WebElement textElement = driver.findElement(By.xpath(String.format("//div[text()='%s']/../../div/p", caption)));
        Assert.assertEquals(textElement.getText(), selectText);
    }
   public MainPage() {
       PageFactory.initElements(driver,this);
    }
}
