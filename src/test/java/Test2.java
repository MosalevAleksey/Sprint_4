import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

// Класс с автотестом
@RunWith(Parameterized.class)
public class Test2 {

    //релевантные значения для заполнения формы
    private final By BUTTON;
    private final String NAME;
    private final String SURNAME;
    private final String ADRESS;
    йййprivate final String TELEPHONE;
    private final String TEXT;

    public Test2(By button, String name, String surname, String adress, String telephone, String text) {
        this.BUTTON = button;
        this.NAME = name;
        this.SURNAME = surname;
        this.ADRESS = adress;
        this.TELEPHONE = telephone;
        this.TEXT = text;
    }

    @Parameterized.Parameters
    public static Object[][] checkTexst() {
        return new Object[][]{

                {HomePageElement.orderButtonMidel, "Сергей", "Иванов", "Горки дом 4", "88127569885","Заказ оформлен"},
                {HomePageElement.orderButtonHader, "Сергей", "Иванов", "Горки дом 4", "88127569885","Заказ оформлен"},
        };
    }

    @Test
    public void Testorder() {

        //Драйвер FirefoxDriver без UI.
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        WebDriver driver = new FirefoxDriver(options);
        //драйвер для браузера FirefoxDriver
        //System.setProperty("webdriver.gecko.driver", "C:\\WebDriver\\bin\\geckodriver.exe");
        //WebDriver driver = new FirefoxDriver();
        //Драйвер Chrome без UI.
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        //WebDriver driver = new ChromeDriver(options);
        //драйвер для браузера Chrome
        //System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
        // WebDriver driver = new ChromeDriver();


        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru");

        // создай объект класса страницы для входа
        HomePageElement objQaScooterPageElement = new HomePageElement(driver);


        // вызываем метод клик кнопка заказать Hader
        objQaScooterPageElement.clickOrderButton(BUTTON);
        // создай объект класса заполнения заказа
        OrderPageElement objOrderPage = new OrderPageElement(driver);
        //метод ожидания поля формы
        objOrderPage.waitForLoadProfileName();
        //метод заполнения Name
        objOrderPage.clickEditProfile(objOrderPage.name, NAME);
        //метод заполнения SURNAME
        objOrderPage.clickEditProfile(objOrderPage.surname, SURNAME);
        //метод заполнения ADRESS
        objOrderPage.clickEditProfile(objOrderPage.adress, ADRESS);
        //метод заполнения Metro
        objOrderPage.selectChooseText(objOrderPage.metroStation, objOrderPage.metroStation1);
        //метод заполнения TELEPHONE
        objOrderPage.clickEditProfile(objOrderPage.phoneNmber, TELEPHONE);
        //метод дАЛЕЕ
        objOrderPage.clickNextButton(objOrderPage.nextButton);
        //метод ожидания поля формы
        objOrderPage.waitForLoadProfileName();
        //метод заполнения Metro
        objOrderPage.selectChooseText(objOrderPage.dataRental, objOrderPage.dataRental1);
        //метод заполнения Metro
        objOrderPage.selectChooseText(objOrderPage.rentalPeriod, objOrderPage.rentalPeriod1);
        //метод выбора цвета
        objOrderPage.selectButtonOrColorChekbox(objOrderPage.blackCheckBox);
        //метод заполнения коммит
        objOrderPage.clickEditProfile(objOrderPage.commitToDeliver, TELEPHONE);
        //метод Заказать
        objOrderPage.clickNextButton(objOrderPage.nextButton1);
        //метод сделать заказ Да?
        objOrderPage.clickNextButton(objOrderPage.yesButton);

        // Проверь, что нашёлся элемент с текстом оформленного заказа

        System.out.println(driver.findElement(objOrderPage.orderstatus).getText());
        Assert.assertThat(driver.findElement(objOrderPage.orderstatus).getText(), CoreMatchers.containsString(TEXT));


        driver.quit();
    }
}

