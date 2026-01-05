package test;

import api.request.UserRequest;
import config.DriverExtension;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import pages.RegisterPage;
import testdata.register.UserDataFactory;
import utils.CleanupExtension;

import static utils.CleanupExtension.addUserToDeletionList;

@Epic("Stellar Burger App")
@Feature("Register")
public class RegisterTest {
    RegisterPage registerPage;
    //создаем WebDriver в начале и закрываем его в конце каждого теста
    @RegisterExtension
    private final DriverExtension driverExtension = new DriverExtension();
    //удаляем созданные аккаунты в конце каждого теста
    @RegisterExtension
    private final CleanupExtension cleanupExtension = new CleanupExtension();

    @BeforeEach
    public void setup() {
        registerPage = new RegisterPage(driverExtension.getDriver());
    }

    @Test
    @DisplayName("Регистрация пользователя с валидными данными")
    public void shouldRegisterUserWithValidData(){
        UserRequest userRequest = UserDataFactory.generateValidUserData();
        //тест
        registerPage.open();
        registerPage.registerUserWithValidData(userRequest);
        //добавляю созданного пользователя в список на удаление
        addUserToDeletionList(userRequest);
        }

    @Test
    @DisplayName("Регистрация пользователя с паролем < 6 символов")
    public void registrationWithShortPasswordFails(){
        registerPage.open();
        registerPage.registerUserWithInvalidData(UserDataFactory.generateUserDataWithShortPassword());
    }
}
