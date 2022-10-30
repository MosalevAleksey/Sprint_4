import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestMakeOrderChrome {
    //релевантные значения для заполнения формы
    private final String NAME = "Сергей";
    private final String SURNAME = "Иванов";
    private final String ADRESS = "Москва Крассная площадь";
    private final String METRO = "Бульвар Рокоссовского";
    private final String TELEPHONE = "89680341276";

    @Test
    public void Testorder() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
        //драйвер для браузера Chrome
        WebDriver driver = new ChromeDriver();
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru");

        // создай объект класса страницы для входа
        TestMakeOrder.QaScooterPageElement objQaScooterPageElement = new TestMakeOrder.QaScooterPageElement(driver);


        // вызываем метод клик кнопка заказать Hader
        objQaScooterPageElement.clickHedarOrderButton();
        // создай объект класса заполнения заказа
        TestMakeOrder.OrderPage objOrderPage = new TestMakeOrder.OrderPage(driver);
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
        String text = driver.findElement(objOrderPage.orderstatus).getText();
        System.out.println(text);
        Assert.assertThat(text, CoreMatchers.containsString("Заказ оформлен"));


        driver.quit();
    }
}