package pages;

import constants.UrlConstants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base_pom.BasePage;

public class MainPage extends BasePage {

    private final By personalAccountButton = By.xpath("//a[@href='/account']//p[text()='Личный Кабинет']");
    private final By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By makeOrderButton = By.xpath("//button[text()='Оформить заказ']");
    private final By bunSectionSelected = By.xpath("//div[contains(@class, 'tab_tab_type_current') and normalize-space(.) = 'Булки']");
    private final By sauceSectionSelected = By.xpath("//div[contains(@class, 'tab_tab_type_current') and normalize-space(.) = 'Соусы']");
    private final By fillingSectionSelected = By.xpath("//div[contains(@class, 'tab_tab_type_current') and normalize-space(.) = 'Начинки']");
    private final By bunSection = By.xpath("//div[normalize-space(.) = 'Булки']");
    private final By sauceSection = By.xpath("//div[normalize-space(.) = 'Соусы']");
    private final By fillingSection = By.xpath("//div[normalize-space(.) = 'Начинки']");

    //конструктор
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открыть главную страницу")
    public void open (){
        driver.get(UrlConstants.BASE_URL);
    }

    public void clickOnPersonalAccountButton(){
        clickElement(personalAccountButton, "кнопка Личный кабинет");
    }

    public void clickOnLoginButton(){
        clickElement(loginButton, "кнопка Войти в аккаунт");
    }

    public void waitForMainPageToLoad(){
        waitForPageToLoad(UrlConstants.BASE_URL, "главная страница");
    }

    public void waitVisibilityOfMakeOrderButton(){
        waitVisibilityOfElement(makeOrderButton, "кнопка Оформить заказ");
    }

    public void selectBunSection(){
        clickElement(sauceSection, "раздел соусы");
        clickElement(bunSection, "раздел булки");
        waitVisibilityOfElement(bunSectionSelected, "раздел булки c тегом tab_tab_type_current");
    }

    public void selectSauceSection(){
        clickElement(sauceSection, "раздел соусы");
        waitVisibilityOfElement(sauceSectionSelected, "раздел соусы c тегом tab_tab_type_current");
    }

    public void selectFillingSection(){
        clickElement(fillingSection, "раздел начинки");
        waitVisibilityOfElement(fillingSectionSelected, "раздел начинки c тегом tab_tab_type_current");
    }

}
