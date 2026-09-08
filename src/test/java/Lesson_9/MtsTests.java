package Lesson_9;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsTests {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.mts.by/");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree"))).click();
    }

    // 1. Проверить название указанного блока
    @Test
    public void testOnlineRefillTitle() {
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(text(), 'Онлайн пополнение')]")
        ));

        String actualTitle = title.getText().replace("\n", " ").trim();
        assertEquals("ОНЛАЙН ПОПОЛНЕНИЕ БЕЗ КОМИССИИ", actualTitle);
    }

    // 2. Проверить наличие логотипов платёжных систем
    @Test
    public void testPaymentLogos() {
        String[] logos = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"};

        for (String altText : logos) {
            WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//img[@alt='" + altText + "']")
            ));
            assertTrue(logo.isDisplayed());
        }
    }

    // 3. Проверить работу ссылки «Подробнее о сервисе»
    @Test
    public void testAboutServiceLink() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(), 'Подробнее о сервисе')]")
        ));
        link.click();

        wait.until(ExpectedConditions.urlContains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
        assertTrue(driver.getCurrentUrl().contains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
    }

    // 4. Заполнить поля и проверить работу кнопки «Продолжить»
    @Test
    public void testContinueButtonInServices() {
        WebElement phone = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Номер телефона']")
        ));
        phone.sendKeys("297777777");

        WebElement sum = driver.findElement(By.id("connection-sum"));
        sum.sendKeys("10");

        WebElement email = driver.findElement(By.id("connection-email"));
        email.sendKeys("vladzuk71@gmail.com");

        WebElement button = driver.findElement(By.xpath("//button[text()='Продолжить']"));
        button.click();

        WebElement payFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//iframe[contains(@src, 'bepaid') or contains(@class, 'iframe')]")
        ));
        assertTrue(payFrame.isDisplayed());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}