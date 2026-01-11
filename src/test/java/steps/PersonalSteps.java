package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.*;

public class PersonalSteps {
    private final MainPage mainPage;
    private final LoginPage loginPage;
    private final PersonalPage personalPage;

    public PersonalSteps(WebDriver driver) {
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        personalPage = new PersonalPage(driver);
    }

    @Step("Отсутствие возможности войти в Личный кабинет после выхода из аккаунта")
    public void tryGoToPersonalAccountPageReturnLogin(){
        personalPage.open();
        loginPage.waitForLoginPageToLoad();
    }

    @Step("Переход в Личный кабинет")
    public void goToPersonalAccountPage(){
        mainPage.clickOnPersonalAccountButton();
        personalPage.waitForPersonalAccountPageToLoad();
        personalPage.waitVisibilityExitButton();
    }

    @Step("Выход из аккаунта по кнопке «Выйти» в личном кабинете")
    public void logOut(){
        personalPage.open();
        personalPage.waitVisibilityExitButton();
        personalPage.clickExitButton();
        loginPage.waitForLoginPageToLoad();
        tryGoToPersonalAccountPageReturnLogin();
    }
}
