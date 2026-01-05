package pages;

import constants.UrlConstants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base_pom.BasePage;

public class PersonalPage extends BasePage {

    private final By exitButton = By.xpath("//button[text()='Выход']");
    private final By constructorButton = By.xpath("//p[text()='Конструктор']");
    //конструктор
    public PersonalPage(WebDriver driver) {
        super(driver);
    }

    @Step("Перейти в личный кабинет")
    public void open (){
        driver.get(UrlConstants.PERSONAL_ACCOUNT_URL);
    }

    public void waitForPersonalAccountPageToLoad(){
        waitForPageToLoad(UrlConstants.PERSONAL_ACCOUNT_URL, "Личный кабинет");
    }

    public void waitVisibilityExitButton(){
        waitVisibilityOfElement(exitButton, "кнопка Выход");
    }

    public void clickExitButton(){
        clickElement(exitButton, "кнопка Выхода");
    }

    public void clickConstructorButton(){
        clickElement(constructorButton, "кнопка Конструктор");
    }

}
