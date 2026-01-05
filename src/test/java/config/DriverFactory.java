package config;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;

//класс для создания и настройки WebDriver в зависимости от параметра browser
@Getter
public class DriverFactory {
    private WebDriver driver;

    //метод для настройки драйвера в зависимости от параметра browser
    public void setupDriver() {
        String browser = System.getProperty("browser", "chrome").toLowerCase(Locale.ROOT);
        switch (browser) {
            case "firefox":
                setupFirefoxDriver();
                break;
            case "chrome":
            default:
                setupChromeDriver();
                break;
        }
    }

    //метод настройки драйвера для Chrome
    public void setupChromeDriver() {
        driver = new ChromeDriver();
    }
    //метод настройки драйвера для Firefox
    public void setupFirefoxDriver() {
        driver = new FirefoxDriver();
    }

}
