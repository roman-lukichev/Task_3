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
import steps.PersonalSteps;
import testdata.register.UserDataFactory;
import utils.CleanupExtension;

@Epic("Stellar Burger App")
@Feature("Personal Account")
public class PersonalTest {
    UserRequest userRequest;
    PersonalSteps personalSteps;
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
        personalSteps = new PersonalSteps(driverExtension.getDriver());
        loginSteps = new LoginSteps(driverExtension.getDriver());
        UserApi.doRegisterUser(userRequest);
        CleanupExtension.addUserToDeletionList(userRequest);
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет»")
    public void goToPersonalAccountPageSuccess(){
        loginSteps.goToLoginPageAndLogin(userRequest);
        personalSteps.goToPersonalAccountPage();
    }

    @Test
    @DisplayName("Выход из аккаунта")
    public void logOutSuccess(){
        loginSteps.goToLoginPageAndLogin(userRequest);
        personalSteps.logOut();
    }
}
