package steps;

import api.request.UserRequest;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.*;

public class LoginSteps {
    private final MainPage mainPage;
    private final LoginPage loginPage;
    private final RegisterPage registerPage;
    private final ForgotPasswordPage forgotPasswordPage;

    public LoginSteps(WebDriver driver) {
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
    }

    @Step("Перейти на страницу входа по кнопке \"Войти в аккаунт\" на главной")
    public void goToLoginPageByLoginButtonOnMainPage() {
        mainPage.open();
        mainPage.clickOnLoginButton();
    }

    @Step("Перейти на страницу входа через кнопку \"Личный Кабинет\" на главной")
    public void goToLoginPageByPersonalAccountButton() {
        mainPage.open();
        mainPage.clickOnPersonalAccountButton();
    }

    @Step("Перейти на страницу входа через кнопку \"Войти\" в форме регистрации")
    public void goToLoginPageByLoginButtonOnRegistrationPage() {
        registerPage.open();
        registerPage.clickOnLoginButton();
    }

    @Step("Перейти на страницу входа через кнопку \"Войти\" в форме восстановления пароля")
    public void goToLoginPageByLoginButtonOnForgotPasswordPage() {
        forgotPasswordPage.open();
        forgotPasswordPage.clickOnLoginButton();
    }

    @Step("Войти в аккаунт с валидными данными")
    public void login(UserRequest userRequest) {
        loginPage.loginUserWithValidDataSuccess(userRequest);
        mainPage.waitVisibilityOfMakeOrderButton();
    }

    @Step("Перейти на страницу входа и войти в аккаунт")
    public void goToLoginPageAndLogin(UserRequest userRequest) {
        loginPage.open();
        loginPage.loginUserWithValidDataSuccess(userRequest);
    }



}
