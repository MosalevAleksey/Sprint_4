import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;


// Класс с автотестом
@RunWith(Parameterized.class)
public class Test1 {

    private final String text;
    private final By button;
    private final By button2;


    public Test1(String text, By button, By button2) {
        this.text = text;
        this.button = button;
        this.button2 = button2;
    }

    @Parameterized.Parameters
    public static Object[][] checkTexst() {
        return new Object[][]{
                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", HomePageElement.qustionsButton0, HomePageElement.textButton0},
                {"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", HomePageElement.qustionsButton2, HomePageElement.textButton2},
                {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", HomePageElement.qustionsButton1, HomePageElement.textButton1},
                {"Только начиная с завтрашнего дня. Но скоро станем расторопнее.", HomePageElement.qustionsButton3, HomePageElement.textButton3},
                {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", HomePageElement.qustionsButton4, HomePageElement.textButton4},
                {"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", HomePageElement.qustionsButton5, HomePageElement.textButton5},
                {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", HomePageElement.qustionsButton6, HomePageElement.textButton6},
                {"Да, обязательно. Всем самокатов! И Москве, и Московской области.", HomePageElement.qustionsButton7, HomePageElement.textButton7},
        };
    }

    @Test
    public void checkText() {
        // драйвер для браузера Chrome
        //System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
        // WebDriver driver = new ChromeDriver();
        //Драйвер Chrome без UI.
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        WebDriver driver = new ChromeDriver(options);

        //драйвер для браузера FirefoxDriver
        //System.setProperty("webdriver.gecko.driver", "C:\\WebDriver\\bin\\geckodriver.exe");
        //WebDriver driver = new FirefoxDriver();
        //Драйвер без UI.
        //FirefoxOptions options = new FirefoxOptions();
        //options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        //WebDriver driver = new FirefoxDriver(options);

        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru");

        // создай объект класса страницы авторизации
        HomePageElement objHomePageElement = new HomePageElement(driver);


        // Вызвали метод возврата текста вопроса
        String aktiv = objHomePageElement.returnTextQustionsButton(button, button2);
        Assert.assertEquals(text, aktiv);

        driver.quit();
    }
}
