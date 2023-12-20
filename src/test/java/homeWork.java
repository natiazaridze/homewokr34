import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class homeWork {


    @Test
    public void myTest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();



        By sortDropdown = By.className("product_sort_container");
        driver.findElement(sortDropdown).click();

        Select selectSortDropdown = new Select(driver.findElement(sortDropdown));
        int sortDropdownSize = selectSortDropdown.getOptions().size();

        for(int i = 0; i < sortDropdownSize; i++ ){
            sortDropdown = By.className("product_sort_container");
            selectSortDropdown = new Select(driver.findElement(sortDropdown));

            WebDriverWait waitForDropdown = new WebDriverWait(driver, Duration.ofSeconds(5));
            waitForDropdown.until(ExpectedConditions.elementToBeClickable(sortDropdown));

            selectSortDropdown.selectByIndex(i);



        }





    }
}
