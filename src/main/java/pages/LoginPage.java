package pages;

import elements.LoginFormElement;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final LoginFormElement loginFormElement;

    private final WebDriver webDriver;

    public LoginPage(final WebDriver webDriver) {
        webDriver.get("http://localhost:8080/login");
        this.webDriver = webDriver;
        loginFormElement = new LoginFormElement(webDriver);
    }

    public UsersPage login(final String login, final String password, final boolean remember) {
        loginFormElement.login(login, password, remember);
        return new UsersPage(webDriver);
    }
}
