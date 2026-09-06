package Lesson_10;

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

    @DisplayName("Услуги связи")
    @Test
    public void checkPlaceholdersInServiceSectionTest() {
        payment.selectCategory(CommissionFreeTopUpService.CATEGORY_COMMUNICATION)
                .assertServiceSection();
    }

    @DisplayName("Домашний интернет")
    @Test
    public void homeInternetTest() {
        payment.selectCategory(CommissionFreeTopUpService.CATEGORY_HOME_INTERNET)
                .assertHomeInternet();
    }

    @DisplayName("Рассрочка")
    @Test
    public void instalmentTest() {
        payment.selectCategory(CommissionFreeTopUpService.CATEGORY_INSTALMENT)
                .assertInstalment();
    }

    @DisplayName("Задолженность")
    @Test
    public void debtTest() {
        payment.selectCategory(CommissionFreeTopUpService.CATEGORY_DEBT)
                .assertDebt();
    }

    @DisplayName("Задание 2")
    @Test
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
