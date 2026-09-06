package Lesson_10;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Epic("Финансовые сервисы")
@Feature("Услуга пополнения без комиссии")
@Owner("Zhuk-V")
public class Tests {
    private WebDriver driver;
    private WebDriverWait wait;
    private CommissionFreeTopUpService payment;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.mts.by/");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree"))).click();
        payment = new CommissionFreeTopUpService(driver);
    }

    @Test
    @Story("Проверка форматов полей и плейсхолдеров")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Услуги связи")
    @Description("Проверка корректности плейсхолдеров")
    public void checkPlaceholdersInServiceSectionTest() {
        payment.selectCategory(CommissionFreeTopUpService.CATEGORY_COMMUNICATION)
                .assertServiceSection();
    }

    @Test
    @Story("Проверка форматов полей и плейсхолдеров")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Домашний интернет")
    @Description("Проверка отображения плейсхолдеров полей в блоке 'Домашний интернет'")
    public void homeInternetTest() {
        payment.selectCategory(CommissionFreeTopUpService.CATEGORY_HOME_INTERNET)
                .assertHomeInternet();
    }

    @Test
    @Story("Проверка форматов полей и плейсхолдеров")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Рассрочка")
    @Description("Проверка отображения номер счета на 44, суммы и e-mail в блоке 'Рассрочка'")
    public void instalmentTest() {
        payment.selectCategory(CommissionFreeTopUpService.CATEGORY_INSTALMENT)
                .assertInstalment();
    }

    @Test
    @Story("Проверка форматов полей и плейсхолдеров")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Задолженность")
    @Description("Проверка отображения номер счета на 2073, суммы и e-mail в блоке 'Задолженность'")
    public void debtTest() {
        payment.selectCategory(CommissionFreeTopUpService.CATEGORY_DEBT)
                .assertDebt();
    }

    @Test
    @Story("Проведение оплаты и интеграция с платежной системой")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проведение платежа и проверка фрейма оплаты (Задание 2)")
    @Description("Заполнение формы, перенаправление во фрейм и валидация реквизитов платежной системы")
    public void replenishment() {
        payment.fillElements();

        payment.assertPaymentCorrectText();
        payment.assertPaymentCorrectPlaceholder();
        payment.assertPaymentLogos();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
