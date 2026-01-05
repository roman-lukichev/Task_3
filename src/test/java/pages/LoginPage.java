package pages;

import api.request.UserRequest;
import constants.UrlConstants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base_pom.BasePage;

public class LoginPage extends BasePage {

    private final By emailInput = By.xpath("//form//div[./label[text()='Email']]//input");
    private final By passwordInput = By.xpath("//form//div[./label[text()='Пароль']]//input");
    private final By loginButton = By.xpath("//form//button[text()='Войти']");

    //конструктор
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //метод открывающий страницу регистрации
    @Step("Открыть страницу входа")
    public void open (){
        driver.get(UrlConstants.LOGIN_URL);
    }

    @Step("Заполнение формы входа")
    public void fillInputs(UserRequest data){
        fillInput(emailInput, "email", data.getEmail());
        fillInput(passwordInput, "password", data.getPassword());
    }

    public void loginUserWithValidDataSuccess(UserRequest data){
        fillInputs(data);
        clickElement(loginButton, "кнопка входа");
        waitForPageToLoad(UrlConstants.BASE_URL, "главная страница");
    }

    public void waitForLoginPageToLoad(){
        waitForPageToLoad(UrlConstants.LOGIN_URL, "страница входа");
    }
}
