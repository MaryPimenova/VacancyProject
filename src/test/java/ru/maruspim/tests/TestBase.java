package ru.maruspim.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.maruspim.helpers.Attach;
import ru.maruspim.pages.*;
import ru.maruspim.utils.RandomUtils;

public class TestBase {
    MZTAMainPageComponent mztaMainPageComponent = new MZTAMainPageComponent();
    MZTADownloadPageComponent mztaDownloadPageComponent = new MZTADownloadPageComponent();
    MZTAProductionPageComponent mztaProductionPageComponent = new MZTAProductionPageComponent();
    MZTACartPageComponent mztaCartPageComponent = new MZTACartPageComponent();
    MZTARegistrationPageComponent mztaRegistrationPageComponent = new MZTARegistrationPageComponent();
    RandomUtils randomUtils = new RandomUtils();

    @BeforeAll
    static void beforeAll() {

        Configuration.pageLoadStrategy = "eager";
        String selenoidUrl = System.getProperty("selenoid_url");
        String userLoginPassword = System.getProperty("user_login_password");
        selenoidUrl = selenoidUrl.replaceAll("https://", "");
        Configuration.remote = "https://" + userLoginPassword + "@" + selenoidUrl;
        Configuration.baseUrl = System.getProperty("base_url", "https://www.mzta.ru");

        String[] browser = System.getProperty("browser", "chrome:100.0").split(":");
        Configuration.browser = browser[0];
        Configuration.browserVersion = browser[1];
        Configuration.browserSize = System.getProperty("browser_size", "1920x1080");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
