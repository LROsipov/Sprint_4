package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import core.BasePage;

import javax.annotation.Nonnull;

// Класс главной страницы
public class MainPage extends BasePage {

    // Локатор кнопки закзать вверху страницы
    @FindBy(xpath = "//div[contains(@class, 'Header_Nav')]//button[text()='Заказать']")
    private WebElement orderInHeader;
    // Локатор списка FAQ
    @FindBy(xpath = "//div[text()='Вопросы о важном']")
    private WebElement listFaq;
    @FindBy(xpath = "//div[contains(@class, 'Home_Finish')]//button[text()='Заказать']")
    private WebElement orderInFooter;
    /**
     * Кликает по кнопке заказать
     *
     * @param button  положение кнопки (1 вверху, другая цифра внизу)
     */
    public void clickOrderButton(int button)  {
        if (button == 1) {
        orderInHeader.click();}
        else {
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",orderInFooter);
            orderInFooter.click();
        }
    }
    // Метод прокрутки старницы к списку FAQ
    public void scrollToListFaq(){
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",listFaq); }
    // Метод сравнения текста в  списке FAQ . Проскролили до элемента и сравнили.
    public void checkTextInFaq(@Nonnull String caption, @Nonnull String selectText) {
        WebElement  headerText  = driver.findElement(By.xpath(String.format("//div[text()='%s']", caption)));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",headerText);
        headerText.click();
        WebElement textElement = driver.findElement(By.xpath(String.format("//div[text()='%s']/../../div/p", caption)));
        Assert.assertEquals( selectText, textElement.getText());
    }
   public MainPage() {
       PageFactory.initElements(driver,this);
    }
}
