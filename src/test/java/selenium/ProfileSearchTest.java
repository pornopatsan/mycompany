package selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class ProfileSearchTest {

    @Test
    public void addAndUpdateAndDeleteEmployee() {
        WebDriver driver = new SafariDriver();
        driver.get("http://localhost:8080/mycompany_war_exploded/company/main");
        try {
            assertEquals("Главная", driver.getTitle());
            driver.findElement(By.linkText("Искать работников")).click();
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.titleIs("Поиск"));
            assertEquals("http://localhost:8080/mycompany_war_exploded/company/search", driver.getCurrentUrl());


        } finally {
            driver.close();
        }
    }
}