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
import steps.ConstructorSteps;
import steps.LoginSteps;
import testdata.register.UserDataFactory;
import utils.CleanupExtension;

@Epic("Stellar Burger App")
@Feature("Constructor")
public class ConstructorTest {
    UserRequest userRequest;
    LoginSteps loginSteps;
    ConstructorSteps constructorSteps;
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
        constructorSteps = new ConstructorSteps(driverExtension.getDriver());
        UserApi.doRegisterUser(userRequest);
        CleanupExtension.addUserToDeletionList(userRequest);
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void goToConstructorFromPersonalAccountPageSuccess(){
        loginSteps.goToLoginPageAndLogin(userRequest);
        constructorSteps.goToConstructorFromPersonalAccountPage();
    }

    @Test
    @DisplayName("Переход к разделу Булки")
    public void selectBunSectionSuccess(){
        loginSteps.goToLoginPageAndLogin(userRequest);
        constructorSteps.selectBunSection();
    }

    @Test
    @DisplayName("Переход к разделу Соусы")
    public void selectSauceSectionSuccess(){
        loginSteps.goToLoginPageAndLogin(userRequest);
        constructorSteps.selectSauceSection();
    }

    @Test
    @DisplayName("Переход к разделу Начинки")
    public void selectFillingSectionSuccess(){
        loginSteps.goToLoginPageAndLogin(userRequest);
        constructorSteps.selectFillingSection();
    }
}
