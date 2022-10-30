import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

// Класс страницы авторизации
class QaScooterPageElement {

    private WebDriver driver;
    // Кнопка "Заказать" Hader
    private By orderButtonHader = By.className("Button_Button__ra12g");
    // Кнопка «Статус заказа»
    private By statusButton = By.className("Header_Link__1TAG7");
    // Кнопка "Заказать" midel
    private By orderButtonMidel = By.className("Button_Middle__1CSJM");

    public QaScooterPageElement(WebDriver driver) {
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
}
// Класс с автотестом
@RunWith(Parameterized.class)
public class TestClass {

    private final String text;
    private final By button;
    private final By button2;

    // Блок Вопросы о важном
    // Кнопка сколько стоит
    private static By qustionsButton0 = By.id("accordion__heading-0");
    //Текст кнопки
    private static By textButton0 = By.id("accordion__panel-0");
    // Кнопка Хочу несколько сомакатов
    private static By qustionsButton1 = By.id("accordion__heading-1");
    //Текст кнопки
    private static By textButton1 = By.id("accordion__panel-1");
    // Кнопка Как рассчитывается время аренды?
    private static By qustionsButton2 = By.id("accordion__heading-2");
    //Текст кнопки
    private static By textButton2 = By.id("accordion__panel-2");
    // Кнопка Можно ли заказать самокат прямо на сегодня?
    private static By qustionsButton3 = By.id("accordion__heading-3");
    //Текст кнопки
    private static By textButton3 = By.id("accordion__panel-3");
    // Кнопка Можно ли продлить заказ или вернуть самокат раньше?
    private static By qustionsButton4 = By.id("accordion__heading-4");
    //Текст кнопки
    private static By textButton4 = By.id("accordion__panel-4");
    // Кнопка Вы привозите зарядку вместе с самокатом?
    private static By qustionsButton5 = By.id("accordion__heading-5");
    //Текст кнопки
    private static By textButton5 = By.id("accordion__panel-5");
    // Кнопка Можно ли отменить заказ?
    private static By qustionsButton6 = By.id("accordion__heading-6");
    //Текст кнопки
    private static By textButton6 = By.id("accordion__panel-6");
    // Кнопка Я жизу за МКАДом, привезёте?
    private static By qustionsButton7 = By.id("accordion__heading-7");
    //Текст кнопки
    private static By textButton7 = By.id("accordion__panel-7");

    public TestClass(String text, By button, By button2) {
        this.text = text;
        this.button = button;
        this.button2 = button2;
    }

    @Parameterized.Parameters
    public static Object[][] checkTexst() {
        return new Object[][]{
                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", qustionsButton0, textButton0},
                {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", qustionsButton1, textButton1},
                {"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", qustionsButton2, textButton2},
                {"Только начиная с завтрашнего дня. Но скоро станем расторопнее.", qustionsButton3, textButton3},
                {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", qustionsButton4, textButton4},
                {"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", qustionsButton5, textButton5},
                {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", qustionsButton6, textButton6},
                {"Да, обязательно. Всем самокатов! И Москве, и Московской области.", qustionsButton7, textButton7},
        };
    }

    @Test
    public void checkText() {

        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");

        // драйвер для браузера Chrome
        WebDriver driver = new ChromeDriver();


        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru");

        // создай объект класса страницы авторизации
        QaScooterPageElement objQaScooterPageElement = new QaScooterPageElement(driver);


        // Вызвали метод возврата текста вопроса
        String aktiv = objQaScooterPageElement.returnTextQustionsButton(button, button2);
        Assert.assertEquals(text, aktiv);

        driver.quit();
    }
}
