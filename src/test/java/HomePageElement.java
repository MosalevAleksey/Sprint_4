import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

// класс элементов и методов Home
public class HomePageElement {
    private WebDriver driver;
    // Кнопка "Заказать" Hader
    public static By orderButtonHader = By.className("Button_Button__ra12g");
    // Кнопка "Заказать" midel
    public static By orderButtonMidel = By.className("Button_Middle__1CSJM");

    // Блок Вопросы о важном
    // Кнопка сколько стоит
    public static By qustionsButton0 = By.id("accordion__heading-0");
    //Текст кнопки
    public static By textButton0 = By.id("accordion__panel-0");
    // Кнопка Хочу несколько сомакатов
    public static By qustionsButton1 = By.id("accordion__heading-1");
    //Текст кнопки
    public static By textButton1 = By.id("accordion__panel-1");
    // Кнопка Как рассчитывается время аренды?
    public static By qustionsButton2 = By.id("accordion__heading-2");
    //Текст кнопки
    public static By textButton2 = By.id("accordion__panel-2");
    // Кнопка Можно ли заказать самокат прямо на сегодня?
    public static By qustionsButton3 = By.id("accordion__heading-3");
    //Текст кнопки
    public static By textButton3 = By.id("accordion__panel-3");
    // Кнопка Можно ли продлить заказ или вернуть самокат раньше?
    public static By qustionsButton4 = By.id("accordion__heading-4");
    //Текст кнопки
    public static By textButton4 = By.id("accordion__panel-4");
    // Кнопка Вы привозите зарядку вместе с самокатом?
    public static By qustionsButton5 = By.id("accordion__heading-5");
    //Текст кнопки
    public static By textButton5 = By.id("accordion__panel-5");
    // Кнопка Можно ли отменить заказ?
    public static By qustionsButton6 = By.id("accordion__heading-6");
    //Текст кнопки
    public static By textButton6 = By.id("accordion__panel-6");
    // Кнопка Я жизу за МКАДом, привезёте?
    public static By qustionsButton7 = By.id("accordion__heading-7");
    //Текст кнопки
    public static By textButton7 = By.id("accordion__panel-7");

    public HomePageElement(WebDriver driver) {
        this.driver = driver;
    }
// методы для получения текста под кнопкой с вопросом вход локатор кнопки локатор поля текста

    public String returnTextQustionsButton(By qustionsButton, By textButton) {
        WebElement element = driver.findElement(qustionsButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(qustionsButton).click();
        new WebDriverWait(driver, 3);

        return driver.findElement(textButton).getText();
    }

    // Метод для нажатия на кнопку заказа в Heder или Midl
    public void clickOrderButton(By Button) {
        WebElement element = driver.findElement(Button);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(Button).click();
    }


}
