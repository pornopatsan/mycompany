package selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

            driver.findElement(By.linkText("Показать Всех!")).click();
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.titleIs("Результаты"));
            assertEquals("http://localhost:8080/mycompany_war_exploded/company/search_results", driver.getCurrentUrl());

            WebElement allEmployeeTable = driver.findElement(By.tagName("table"));
            assertTrue(allEmployeeTable.getText().contains("Ksenia"));
            assertTrue(allEmployeeTable.getText().contains("Emma"));
            assertTrue(allEmployeeTable.getText().contains("Stanislav"));
            assertTrue(allEmployeeTable.getText().contains("Dilshod"));


            driver.findElement(By.linkText("Назад")).click();
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.titleIs("Поиск"));
            assertEquals("http://localhost:8080/mycompany_war_exploded/company/search", driver.getCurrentUrl());

            WebElement firstName1 = driver.findElement(By.id("firstName"));
            firstName1.sendKeys("Ksenia");
            WebElement lastName1 = driver.findElement(By.id("lastName"));
            lastName1.sendKeys("Kriger");

            driver.findElement(By.tagName("button")).click();
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.titleIs("Результаты"));

            WebElement result1Table = driver.findElement(By.tagName("table"));
            assertTrue(result1Table.getText().contains("Ksenia"));
            assertTrue(result1Table.getText().contains("Kriger"));
            assertFalse(result1Table.getText().contains("Dilshod"));
            assertFalse(result1Table.getText().contains("Stanislav"));


            driver.findElement(By.linkText("Назад")).click();
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.titleIs("Поиск"));
            assertEquals("http://localhost:8080/mycompany_war_exploded/company/search", driver.getCurrentUrl());

            WebElement jobId2 = driver.findElement(By.id("jobId"));
            jobId2.sendKeys("9");

            driver.findElement(By.tagName("button")).click();
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.titleIs("Результаты"));

            WebElement result2Table = driver.findElement(By.tagName("table"));
            assertTrue(result2Table.getText().contains("Security"));
            assertFalse(result2Table.getText().contains("President"));
            assertFalse(result2Table.getText().contains("Scenarist"));


            driver.findElement(By.linkText("Назад")).click();
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.titleIs("Поиск"));
            assertEquals("http://localhost:8080/mycompany_war_exploded/company/search", driver.getCurrentUrl());

            WebElement salaryDownLimit3 = driver.findElement(By.id("salaryDownLimit"));
            salaryDownLimit3.sendKeys("1000");
            WebElement salaryUpLimit3 = driver.findElement(By.id("salaryUpLimit"));
            salaryUpLimit3.sendKeys("2000");

            driver.findElement(By.tagName("button")).click();
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.titleIs("Результаты"));
            WebElement result3Table = driver.findElement(By.tagName("table"));
            assertTrue(Double.parseDouble(result3Table.findElements(By.tagName("td")).get(4).getText()) > 1000.0);
            assertTrue(Double.parseDouble(result3Table.findElements(By.tagName("td")).get(4).getText()) < 2000.0);


            driver.findElement(By.linkText("Назад")).click();
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.titleIs("Поиск"));
            assertEquals("http://localhost:8080/mycompany_war_exploded/company/search", driver.getCurrentUrl());

            WebElement departmentId4 = driver.findElement(By.id("departmentId"));
            departmentId4.sendKeys("5");

            driver.findElement(By.tagName("button")).click();
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.titleIs("Результаты"));

            WebElement result4Table = driver.findElement(By.tagName("table"));
            driver.findElements(By.linkText("Профиль")).get(0).click();
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.titleIs("Профиль"));
            assertTrue(driver.getCurrentUrl().contains("http://localhost:8080/mycompany_war_exploded/company/profile/"));
            WebElement result4Table2 = driver.findElements(By.tagName("table")).get(2);
            assertTrue(result4Table2.getText().contains("Game: Chess"));


        } finally {
            driver.close();
        }
    }
}