package pages;

import constants.UrlConstants;
import io.qameta.allure.Step;
import api.request.UserRequest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base_pom.BasePage;

public class RegisterPage extends BasePage {

    private final By nameInput = By.xpath("//form//div[./label[text()='Имя']]//input");
    private final By emailInput = By.xpath("//form//div[./label[text()='Email']]//input");
    private final By passwordInput = By.xpath("//form//div[./label[text()='Пароль']]//input");
    private final By registerButton = By.xpath("//form//button[text()='Зарегистрироваться']");
    private final By errorText = By.cssSelector("p.input__error");
    private final By loginButton = By.xpath("//a[@href='/login' and text()='Войти']");

    //конструктор
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    //метод открывающий страницу регистрации
    @Step("Открыть страницу регистрации")
    public void open (){
        driver.get(UrlConstants.REGISTER_URL);
    }

    @Step("Заполнение формы регистрации")
    public void fillRegistrationForm(UserRequest data){
        fillInput(nameInput, "name", data.getName());
        fillInput(emailInput, "email", data.getEmail());
        fillInput(passwordInput, "password", data.getPassword());
    }

    public void registerUserWithValidData(UserRequest data){
        fillRegistrationForm(data);
        clickElement(registerButton, "кнопка регистрации");
        waitForPageToLoad(UrlConstants.LOGIN_URL, "страница входа");
    }
    public void registerUserWithInvalidData(UserRequest data){
        fillRegistrationForm(data);
        clickElement(registerButton, "кнопка регистрации");
        waitVisibilityOfElement(errorText, "текст валидации");
    }

    public void clickOnLoginButton(){
        clickElement(loginButton, "кнопка Войти");
    }
}
