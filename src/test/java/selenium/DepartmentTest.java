package selenium;

import com.google.common.base.Predicate;
import company.dao.DepartmentDao;
import company.hibernate.DepartmentEntity;
import company.service.DepartmentService;
import org.apache.commons.collections.functors.FalsePredicate;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class DepartmentTest {

    @Test
    public void addAndUpdateAndDeleteDepartment() {
        WebDriver driver = new SafariDriver();
        driver.get("http://localhost:8080/mycompany_war_exploded/company/main");
        try {
            assertEquals("Главная", driver.getTitle());

            driver.findElement(By.linkText("Board of Directors")).click();
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.titleIs("Отделение"));
            assertEquals("http://localhost:8080/mycompany_war_exploded/company/department/1", driver.getCurrentUrl());

            driver.findElement(By.linkText("Game Development")).click();
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.urlContains("department/2"));
            assertEquals("http://localhost:8080/mycompany_war_exploded/company/department/2", driver.getCurrentUrl());

            driver.findElement(By.linkText("Добавить")).click();
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.titleIs("Новое Отеделение"));

            WebElement name1 = driver.findElement(By.id("name"));
            name1.sendKeys("Game: Life");
            WebElement description1 = driver.findElement(By.id("description"));
            name1.sendKeys("Develop game of Life");
            Select select1 = new Select(driver.findElement(By.id("tmpOfficeId")));
            select1.selectByValue("");

            driver.findElement(By.tagName("button")).click();
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.titleIs("Отделение"));


            assertTrue(driver.findElement(By.linkText("Board of Directors")).getText().contains("Board of Directors"));
            assertTrue(driver.findElements(By.tagName("table")).get(0).findElements(By.tagName("td")).get(3).getText().contains("Game Development"));
            assertFalse(driver.findElements(By.tagName("table")).get(1).getText().contains("Game: Life"));


            driver.findElement(By.linkText("Добавить")).click();
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.titleIs("Новое Отеделение"));

            WebElement name2 = driver.findElement(By.id("name"));
            name2.sendKeys("Game: Life");
            WebElement description2 = driver.findElement(By.id("description"));
            description2.sendKeys("Develop game of Life");
            Select select2 = new Select(driver.findElement(By.id("tmpOfficeId")));
            select2.selectByValue("1");

            driver.findElement(By.tagName("button")).click();
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.titleIs("Отделение"));

            assertTrue(driver.findElement(By.linkText("Game Development")).getText().contains("Game Development"));
            assertTrue(driver.findElements(By.tagName("table")).get(0).findElements(By.tagName("td")).get(3).getText().contains("Game: Life"));


            driver.findElement(By.linkText("Добавить")).click();
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.titleIs("Новое Отеделение"));

            WebElement name3 = driver.findElement(By.id("name"));
            name3.sendKeys("Game: Life - Scenery");
            WebElement description3 = driver.findElement(By.id("description"));
            description3.sendKeys("Develop Scenery of game of Life");
            Select select3 = new Select(driver.findElement(By.id("tmpOfficeId")));
            select3.selectByValue("1");

            driver.findElement(By.tagName("button")).click();
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.titleIs("Отделение"));

            assertTrue(driver.findElement(By.linkText("Game: Life")).getText().contains("Game: Life"));
            assertTrue(driver.findElements(By.tagName("table")).get(0).findElements(By.tagName("td")).get(3).getText().contains("Game: Life - Scenery"));

            try {
                driver.findElement(By.linkText("Game: Life")).click();
                wait = new WebDriverWait(driver, 1);
                wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.linkText("На главную"))));
            } catch (TimeoutException ignored) { }

            try {
                driver.findElement(By.linkText("Удалить")).click();
                wait = new WebDriverWait(driver, 1);
                wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.linkText("На главную"))));
            } catch (TimeoutException ignored) { }

            assertTrue(driver.findElement(By.linkText("Board of Directors")).getText().contains("Board of Directors"));
            assertTrue(driver.findElements(By.tagName("table")).get(0).findElements(By.tagName("td")).get(3).getText().contains("Game Development"));
            assertTrue(driver.findElements(By.tagName("table")).get(1).getText().contains("Game: Life - Scenery"));

            try {
                driver.findElement(By.linkText("Game: Life - Scenery")).click();
                wait = new WebDriverWait(driver, 1);
                wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.linkText("На главную"))));
            } catch (TimeoutException ignored) { }

            try {
                driver.findElement(By.linkText("Удалить")).click();
                wait = new WebDriverWait(driver, 1);
                wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.linkText("На главную"))));
            } catch (TimeoutException ignored) { }

            assertTrue(driver.findElement(By.linkText("Board of Directors")).getText().contains("Board of Directors"));
            assertTrue(driver.findElements(By.tagName("table")).get(0).findElements(By.tagName("td")).get(3).getText().contains("Game Development"));
            assertFalse(driver.findElements(By.tagName("table")).get(1).getText().contains("Game: Life - Scenery"));
            assertFalse(driver.findElements(By.tagName("table")).get(1).getText().contains("Game: Life"));

        } finally {
            driver.close();
        }
    }
}
