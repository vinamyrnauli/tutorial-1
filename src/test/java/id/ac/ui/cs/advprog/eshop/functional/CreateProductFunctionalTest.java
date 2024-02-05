package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)

public class CreateProductFunctionalTest {
    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setupTest() {
        baseUrl = String.format("%s:%d", testBaseUrl, serverPort);
    }

    @Test
    void CreateProduct_isCorrect(ChromeDriver driver) throws Exception {
        driver.get(baseUrl + "/product/list");

        WebElement createProductButton = driver.findElement(By.linkText("Create Product"));
        createProductButton.click();

        WebElement nameProductInput = driver.findElement(By.id("nameInput"));
        nameProductInput.clear();
        nameProductInput.sendKeys("Testing");

        WebElement quantityProductInput = driver.findElement(By.id("quantityInput"));
        quantityProductInput.clear();
        quantityProductInput.sendKeys("4");

        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
        submitButton.click();

        WebElement productNameInTable = driver.findElement(By.xpath("//tr[last()]/td[1]"));
        String productName = productNameInTable.getText();
        assertEquals("Testing", productName);

        WebElement productQuantityInTable = driver.findElement(By.xpath("//tr[last()]/td[2]"));
        String productQuantity = productQuantityInTable.getText();
        assertEquals("4", productQuantity);
    }

    @Test
    void testNegativeQuantity(ChromeDriver driver) {
        driver.get(baseUrl + "/product/list");

        WebElement createProductButton = driver.findElement(By.linkText("Create Product"));
        createProductButton.click();

        WebElement nameProductInput = driver.findElement(By.id("nameInput"));
        nameProductInput.clear();
        nameProductInput.sendKeys("Halo Tes");

        WebElement quantityProductInput = driver.findElement(By.id("quantityInput"));
        quantityProductInput.clear();
        quantityProductInput.sendKeys("-3");

        // Execute the JavaScript function to update the button state
        ((JavascriptExecutor) driver).executeScript("updateSubmitButton()");

        // Assert that the button is disabled
        assertFalse(driver.findElement(By.id("submitButton")).isEnabled());
    }
}