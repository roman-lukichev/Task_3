package pages.base_pom;

import constants.Constants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //метод нажатия на элемент
    @Step("Нажатие на [{elementName}]")
    public void clickElement(By element, String elementName){
        driver.findElement(element).click();
    }

    //метод ввода значения в Input
    @Step("Заполнение поля [{fieldName}] значением [{text}]")
    public void fillInput(By input, String fieldName, String text){
        driver.findElement(input).sendKeys(text);
    }

    //метод ожидания загрузки страницы
    @Step("Ожидание загрузки [{pageName}]")
    public void waitForPageToLoad(String url, String pageName){
        new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.urlToBe(url));
    }

    //метод ожидания появления элемента на странице
    @Step("Ожидание появления [{elementName}]")
    public void waitVisibilityOfElement(By element, String elementName){
        new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
