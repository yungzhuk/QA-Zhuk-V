package Lesson_10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommissionFreeTopUpService {
    private final WebDriver driver;
    private WebDriverWait wait;

    public static final String CATEGORY_COMMUNICATION = "Услуги связи";
    public static final String CATEGORY_HOME_INTERNET = "Домашний интернет";
    public static final String CATEGORY_INSTALMENT = "Рассрочка";
    public static final String CATEGORY_DEBT = "Задолженность";

    private final By PHONE = By.xpath("//input[@placeholder='Номер телефона']");
    private final By SUM = By.xpath("//input[@placeholder='Сумма']");
    private final By EMAIL = By.xpath("//input[@placeholder='E-mail для отправки чека']");
    private final By ACCOUNT_NUMBER44 = By.xpath("//input[@placeholder='Номер счета на 44']");
    private final By ACCOUNT_NUMBER = By.xpath("//input[@placeholder='Номер счета на 2073']");
    private final By DROPDOWN_ARROW = By.xpath("//span[@class='select__arrow']");

    private final By BUTTON = By.xpath("//button[@class='button button__default ']");

    private final By PAYMENT_WINDOW = By.xpath("//iframe[contains(@src, 'bepaid') or contains(@class, 'iframe')]");
    private final By PAYMENT_SUM = By.xpath("//span[contains(text(), 'BYN')]");
    private final By PAYMENT_SUM_BUTTON = By.xpath("//span[contains(., 'Оплатить') and contains(., 'BYN')]");

    private final By PAYMENT_PHONE_TEXT = By.xpath("//span[contains(text(), 'Оплата:')]");
    private final By PAYMENT_LOGO_VISA = By.xpath("//img[contains(@src, 'visa-system.svg')]");
    private final By PAYMENT_LOGO_MASTERCARD = By.xpath("//img[contains(@src, 'mastercard-system.svg')]");
    private final By PAYMENT_LOGO_BELKART = By.xpath("//img[contains(@src, 'belkart-system.svg')]");
    private final By PAYMENT_LOGO_MIR = By.xpath("//img[contains(@src, 'mir-system-ru.svg')]");

    private final By PAYMENT_PLACEHOLDER_CARD_NUMBER = By.xpath("//label[contains(text(), 'Номер карты')]");
    private final By PAYMENT_PLACEHOLDER_EXPIRATION_DATE = By.xpath("//label[contains(text(), 'Срок действия')]");
    private final By PAYMENT_PLACEHOLDER_CVC = By.xpath("//label[contains(text(), 'CVC')]");
    private final By PAYMENT_PLACEHOLDER_HOLDER = By.xpath("//label[contains(text(), 'Имя и фамилия')]");

    public CommissionFreeTopUpService(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public CommissionFreeTopUpService selectCategory(String categoryName) {
        WebElement arrow = wait.until(ExpectedConditions.elementToBeClickable(DROPDOWN_ARROW));
        arrow.click();

        By categoryLocator = By.xpath("//p[@class='select__option' and text()='" + categoryName + "']");
        WebElement category = wait.until(ExpectedConditions.elementToBeClickable(categoryLocator));
        category.click();

        return this;
    }

    public String getPlaceholderText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator))
                .getAttribute("placeholder");
    }

    public void assertPlaceholder(By locator, String expected) {
        assertEquals(expected, getPlaceholderText(locator));
    }

    public void assertServiceSection() {
        assertPlaceholder(PHONE, "Номер телефона");
        assertPlaceholder(SUM, "Сумма");
        assertPlaceholder(EMAIL, "E-mail для отправки чека");
    }

    public void assertHomeInternet() {
        assertServiceSection(); // плейсхолделы одни и те же
    }

    public void assertInstalment() {
        assertPlaceholder(ACCOUNT_NUMBER44, "Номер счета на 44");
        assertPlaceholder(SUM, "Сумма");
        assertPlaceholder(EMAIL, "E-mail для отправки чека");
    }

    public void assertDebt() {
        assertPlaceholder(ACCOUNT_NUMBER, "Номер счета на 2073");
        assertPlaceholder(SUM, "Сумма");
        assertPlaceholder(EMAIL, "E-mail для отправки чека");
    }

    // часть 2
    public void fillField(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator))
                .sendKeys(text);
    }

    public void fillElements() {
        fillField(PHONE, "297777777");
        fillField(SUM, "10");
        fillField(EMAIL, "vladzuk71@gmail.com");
        WebElement buttonClick = wait.until(ExpectedConditions.elementToBeClickable(BUTTON));
        buttonClick.click();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(PAYMENT_WINDOW));
    }

    public String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator))
                .getText().trim();
    }

    public void assertPaymentText(By locator, String expected) {
        assertEquals(expected, getText(locator));
    }

    // проверяем корректное отображение суммы и номера телефона в тексте
    public void assertPaymentCorrectText() {
        String actualText = getText(PAYMENT_PHONE_TEXT);

        assertTrue(actualText.contains("Оплата: Услуги связи"),
                "Текст должен содержать 'Оплата: Услуги связи'");
        assertTrue(actualText.contains("Номер:375297777777"),
                "Текст должен содержать 'Номер:375297777777'");

        String actualSum = getText(PAYMENT_SUM);
        assertTrue(actualSum.contains("10.00 BYN"),
                "Сумма должна содержать '10.00 BYN'");

        String actualButton = getText(PAYMENT_SUM_BUTTON);
        assertTrue(actualButton.contains("Оплатить"),
                "Кнопка должна содержать 'Оплатить'");
        assertTrue(actualButton.contains("10.00 BYN"),
                "Кнопка должна содержать '10.00 BYN'");
    }

    // проверяем плейсхолдеры
    public String getPaymentLabelText(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        String text = element.getText().trim();
        return text;
    }

    public void assertPaymentCorrectPlaceholder() {
        assertEquals("Номер карты", getPaymentLabelText(PAYMENT_PLACEHOLDER_CARD_NUMBER));
        assertEquals("Срок действия", getPaymentLabelText(PAYMENT_PLACEHOLDER_EXPIRATION_DATE));
        assertEquals("CVC", getPaymentLabelText(PAYMENT_PLACEHOLDER_CVC));
        assertEquals("Имя и фамилия на карте", getPaymentLabelText(PAYMENT_PLACEHOLDER_HOLDER));
    }

    public void assertPaymentLogos() {
        By[] logos = {PAYMENT_LOGO_VISA, PAYMENT_LOGO_MASTERCARD, PAYMENT_LOGO_BELKART, PAYMENT_LOGO_MIR};

        for (By logoLocator : logos) {
            WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(logoLocator));
            assertTrue(logo.isDisplayed(), "Логотип не отображается: " + logoLocator);
        }
    }



}
