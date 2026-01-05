package test;

import api.methods.UserApi;
import api.request.UserRequest;
import config.DriverExtension;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import steps.LoginSteps;
import testdata.register.UserDataFactory;
import utils.CleanupExtension;

@Epic("Stellar Burger App")
@Feature("Login")
public class LoginTest {
    UserRequest userRequest;
    LoginSteps loginSteps;
    //создаем WebDriver в начале и закрываем его в конце каждого теста
    @RegisterExtension
    private final DriverExtension driverExtension = new DriverExtension();
    //удаляем созданные аккаунты в конце каждого теста
    @RegisterExtension
    private final CleanupExtension cleanupExtension = new CleanupExtension();

    @BeforeEach
    public void setup() {
        userRequest = UserDataFactory.generateValidUserData();
        loginSteps = new LoginSteps(driverExtension.getDriver());
        UserApi.doRegisterUser(userRequest);
        CleanupExtension.addUserToDeletionList(userRequest);
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginViaLoginButtonOnMainPage(){
        loginSteps.goToLoginPageByLoginButtonOnMainPage();
        loginSteps.login(userRequest);
    }

    @Test
    @DisplayName("вход через кнопку «Личный кабинет»")
    public void loginViaPersonalAccountButton(){
        loginSteps.goToLoginPageByPersonalAccountButton();
        loginSteps.login(userRequest);
    }

    @Test
    @DisplayName("вход через кнопку «Войти» в форме регистрации")
    public void loginViaLoginButtonOnRegistrationPage(){
        loginSteps.goToLoginPageByLoginButtonOnRegistrationPage();
        loginSteps.login(userRequest);
    }

    @Test
    @DisplayName("вход через кнопку «Войти» в форме восстановления пароля")
    public void loginViaLoginButtonOnForgotPasswordPage(){
        loginSteps.goToLoginPageByLoginButtonOnForgotPasswordPage();
        loginSteps.login(userRequest);
    }
}
