package config;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;

//класс расширение для DriverFactory позволяющий компактно реализовать аннотации:
//@AfterEach для создания и настройки драйвера в начале теста
//@BeforeEach для закрытия браузера в конце теста
public class DriverExtension implements BeforeEachCallback, AfterEachCallback {
    private final DriverFactory driverFactory = new DriverFactory();

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        driverFactory.getDriver().quit();
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        driverFactory.setupDriver();
    }

    public WebDriver getDriver() {
        return driverFactory.getDriver();
    }
}
