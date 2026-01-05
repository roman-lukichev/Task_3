package pages;

import constants.UrlConstants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base_pom.BasePage;

public class ForgotPasswordPage extends BasePage {
    private final By loginButton = By.xpath("//a[@href='/login' and text()='Войти']");

    //конструктор
    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открыть страницу восстановления пароля")
    public void open (){
        driver.get(UrlConstants.FORGOT_PASSWORD_URL);
    }

    public void clickOnLoginButton(){
        clickElement(loginButton, "кнопка Войти");
    }

}
