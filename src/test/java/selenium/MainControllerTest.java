package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainControllerTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addEmployee() {
        WebDriver driver = new SafariDriver();
        driver.get("http://localhost:8080/mycompany_war_exploded/company/main");
        try {
            assertEquals("Главная", driver.getTitle());

            driver.findElement(By.linkText("Новый Работник")).click();
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.titleIs("Новый Работник"));
            assertEquals("http://localhost:8080/mycompany_war_exploded/company/new_employee_form", driver.getCurrentUrl());

            driver.findElement(By.tagName("input")).click();
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.titleIs("Главная"));
            assertEquals("http://localhost:8080/mycompany_war_exploded/company/main", driver.getCurrentUrl());
        } finally {
            driver.close();
        }
    }
}