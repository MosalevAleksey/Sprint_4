import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

//  Класс  Элементов и методов  страницы заказать
public class OrderPageElement {

        private WebDriver driver;
        // Поле имя
        By name = By.xpath("//input[@placeholder='* Имя']");
        //Поле фамилия
        By surname = By.xpath("//input[@placeholder='* Фамилия']");
        // Поле Адрес
        By adress = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
        //Поле Станция метро
        By metroStation = By.xpath("//input[@placeholder='* Станция метро']");
        //Поле поле выбора метро
        By metroStation1 = By.className("select-search__select");
        //Поле Телефон: на него позвонит курьер
        By phoneNmber = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
        // кнопка Далее
        By nextButton = By.xpath("/html/body/div/div/div[2]/div[3]/button");
        //Поле  Когда привезти самокат
        By dataRental = By.xpath("//input[@placeholder='* Когда привезти самокат']");
        //Поле  Когда привезти самокат календарь
        By dataRental1 = By.className("react-datepicker-popper");
        //Поле  Срок аренды
        By rentalPeriod = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div/div[1]");
        //Поле  Когда привезти самокат календарь
        By rentalPeriod1 = By.className("Dropdown-menu");
        //Поле  Цвет самаката поле чек боксов Белый черный
        By blackCheckBox = By.id("black");
        By whiteCheckBox = By.id("grey");
        // Поле Комментарий для курьера
        By commitToDeliver = By.xpath("//input[@placeholder='Комментарий для курьера']");
        // кнопка хотите оформить заказ "далее"
        By nextButton1 = By.xpath("/html/body/div/div/div[2]/div[3]/button[2]");
        // кнопка хотите оформить заказ "Да"
        By yesButton = By.xpath("//button[text()='Да']");
        // поле статус заказа
        By orderstatus = By.xpath("//div[text()='Заказ оформлен']");


        public OrderPageElement(WebDriver driver) {
            this.driver = driver;
        }

        // метод ожидания прогрузки данных клиента
        public void waitForLoadProfileName() {
            new WebDriverWait(driver, 10);
        }

        // метод для нажатия на поле ввода и заолнения  формы
        public void clickEditProfile(By weblocator, String text) {
            driver.findElement(weblocator).click();
            new WebDriverWait(driver, 3);
            driver.findElement(weblocator).sendKeys(text);
        }

        public void clickNextButton(By weblocator) {
            driver.findElement(weblocator).click();
        }

        // метод заполнения выпадающих форм
        public void selectChooseText(By weblocator, By weblocator1) {
            driver.findElement(weblocator).click();
            new WebDriverWait(driver, 3);
            driver.findElement(weblocator1).click();
            // Select drpElement = new Select(driver.findElement(weblocator1));
            // drpElement.selectByVisibleText(METRO);
        }

        // метод для нажатия кнопки или chexbox цвет самаката
        public void selectButtonOrColorChekbox(By weblocator) {
            driver.findElement(weblocator).click();

        }
    }


