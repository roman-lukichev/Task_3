package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.*;

public class ConstructorSteps {
    private final MainPage mainPage;
    private final PersonalPage personalPage;

    public ConstructorSteps(WebDriver driver) {
        mainPage = new MainPage(driver);
        personalPage = new PersonalPage(driver);
    }

    @Step("Переход из Личного кабинета в конструктор")
    public void goToConstructorFromPersonalAccountPage(){
        personalPage.open();
        personalPage.clickConstructorButton();
        mainPage.waitForMainPageToLoad();
        mainPage.waitVisibilityOfMakeOrderButton();
    }

    @Step("Выбрать раздел булки")
    public void selectBunSection(){
        mainPage.selectBunSection();
    }

    @Step("Выбрать раздел соусы")
    public void selectSauceSection(){
        mainPage.selectSauceSection();
    }

    @Step("Выбрать раздел начинки")
    public void selectFillingSection(){
        mainPage.selectFillingSection();
    }
}
