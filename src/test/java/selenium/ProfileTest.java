package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProfileTest {

    @Test
    public void addAndUpdateAndDeleteEmployee() {
        WebDriver driver = new SafariDriver();
        driver.get("http://localhost:8080/mycompany_war_exploded/company/main");
        try {
            assertEquals("Главная", driver.getTitle());

            driver.findElement(By.linkText("Новый Работник")).click();
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.titleIs("Новый Работник"));
            assertEquals("http://localhost:8080/mycompany_war_exploded/company/new_employee_form", driver.getCurrentUrl());

            WebElement firstName = driver.findElement(By.id("firstName"));
            firstName.sendKeys("Aleksandr");
            WebElement lastName = driver.findElement(By.id("lastName"));
            lastName.sendKeys("Poveletsky");
            WebElement email = driver.findElement(By.id("email"));
            email.sendKeys("aleks_pov@mail.ru");
            WebElement address = driver.findElement(By.id("address"));
            address.sendKeys("Noginsk");
            WebElement education = driver.findElement(By.id("education"));
            education.sendKeys("MSU");
            WebElement selfDescription = driver.findElement(By.id("address"));
            selfDescription.sendKeys("Love Dilshod, he is best");

            driver.findElement(By.tagName("button")).click();
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.urlContains("new_employee_personaldata"));

            WebElement salary = driver.findElement(By.id("salary"));
            salary.sendKeys("1500");
            Select select = new Select(driver.findElement(By.id("tmpJobId")));
            select.selectByValue("6");

            driver.findElement(By.tagName("button")).click();
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.titleIs("Профиль"));

            WebElement tableEmployee = driver.findElements(By.tagName("table")).get(0);
            assertEquals("Frontend Developer", tableEmployee.findElements(By.tagName("td")).get(3).getText());
            assertEquals("1500.0", tableEmployee.findElements(By.tagName("td")).get(5).getText());

            WebElement tablePersonaldata = driver.findElements(By.tagName("table")).get(1);
            assertEquals("Aleksandr", tablePersonaldata.findElements(By.tagName("td")).get(1).getText());
            assertEquals("Poveletsky", tablePersonaldata.findElements(By.tagName("td")).get(3).getText());
            assertEquals("MSU", tablePersonaldata.findElements(By.tagName("td")).get(11).getText());


            driver.findElement(By.linkText("Повысить")).click();
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.titleIs("Изменения Профиля"));
            assertTrue( driver.getCurrentUrl().contains("http://localhost:8080/mycompany_war_exploded/company/employee_promote_form"));

            WebElement newSalary = driver.findElement(By.id("salary"));
            newSalary.sendKeys("2500");
            Select newSelect = new Select(driver.findElement(By.id("tmpJobId")));
            newSelect.selectByValue("2");

            driver.findElement(By.tagName("button")).click();
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.titleIs("Профиль"));

            WebElement newTableEmployee = driver.findElements(By.tagName("table")).get(0);
            assertEquals("Manager", newTableEmployee.findElements(By.tagName("td")).get(3).getText());
            assertEquals("2500.0", newTableEmployee.findElements(By.tagName("td")).get(5).getText());


            driver.findElement(By.linkText("Изменить")).click();
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.titleIs("Изменения Профиля"));
            assertTrue( driver.getCurrentUrl().contains("http://localhost:8080/mycompany_war_exploded/company/profile_update_form"));

            WebElement newPhone = driver.findElement(By.id("phone"));
            newPhone.sendKeys("88005553535");
            WebElement newEducation = driver.findElement(By.id("education"));
            newEducation.sendKeys("MIREA");

            driver.findElement(By.tagName("button")).click();
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.titleIs("Профиль"));

            WebElement newTablePersonaldata = driver.findElements(By.tagName("table")).get(1);
            assertEquals("88005553535", newTablePersonaldata.findElements(By.tagName("td")).get(5).getText());
            assertEquals("MIREA", newTablePersonaldata.findElements(By.tagName("td")).get(11).getText());

            WebElement newTableJobHistory = driver.findElements(By.tagName("table")).get(3);
            assertEquals("Frontend Developer", newTableJobHistory.findElements(By.tagName("td")).get(0).getText());
            assertEquals("1500.0", newTableJobHistory.findElements(By.tagName("td")).get(3).getText());


            driver.findElement(By.linkText("Удалить (Уволить)")).click();

        } finally {
            driver.close();
        }
    }
    @Test
    public void UpdateEmployeeDepartments() throws InterruptedException {
        WebDriver driver = new SafariDriver();
        driver.get("http://localhost:8080/mycompany_war_exploded/company/main");
        try {
            assertEquals("Главная", driver.getTitle());
            driver.findElement(By.linkText("1")).click();
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.titleIs("Профиль"));
            assertEquals("http://localhost:8080/mycompany_war_exploded/company/profile/1", driver.getCurrentUrl());

            driver.findElement(By.linkText("Добавить")).click();
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.titleIs("Добавить отделение"));
            assertEquals("http://localhost:8080/mycompany_war_exploded/company/add_employee_department_form?id=1", driver.getCurrentUrl());

            Select select = new Select(driver.findElement(By.id("tmpJobId")));
            select.selectByValue("4");

            driver.findElement(By.tagName("button")).click();
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.titleIs("Профиль"));

            WebElement tableDepartments = driver.findElements(By.tagName("table")).get(2);
            assertTrue(tableDepartments.findElements(By.tagName("td")).get(2).getText().contains("Research"));

            try {
                driver.findElements(By.linkText("Удалить")).get(1).click();
                wait = new WebDriverWait(driver, 1);
                wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.linkText("Удалить"))));
            } catch (TimeoutException ignored) { }

            WebElement newtableDepartments = driver.findElements(By.tagName("table")).get(2);
            assertFalse(newtableDepartments.findElements(By.tagName("td")).get(2).getText().contains("Research"));


            driver.findElement(By.linkText("Добавить")).click();
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.titleIs("Добавить отделение"));
            Select newSelect = new Select(driver.findElement(By.id("tmpJobId")));
            newSelect.selectByValue("-1");

            driver.findElement(By.tagName("button")).click();
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.titleIs("Профиль"));

            WebElement newtableDepartments2 = driver.findElements(By.tagName("table")).get(2);
            assertFalse(newtableDepartments2.findElements(By.tagName("td")).get(2).getText().contains("--Please Select"));

        } finally {
            driver.close();
        }
    }
}