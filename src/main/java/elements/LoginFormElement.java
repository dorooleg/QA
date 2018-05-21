package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginFormElement {

    private WebDriver webDriver;

    private WebElement loginInput;

    private WebElement passwordInput;

    private WebElement rememberCheckBox;

    private WebElement loginButton;

    public LoginFormElement(WebDriver webDriver) {
        this.webDriver = webDriver;
        loginInput = webDriver.findElement(By.id("id_l.L.login"));
        passwordInput = webDriver.findElement(By.id("id_l.L.password"));
        rememberCheckBox = webDriver.findElement(By.id("id_l.L.rememberMe"));
        loginButton = webDriver.findElement(By.id("id_l.L.loginButton"));
    }

    public void login(final String login, final String password, boolean remember) {
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        if (!remember) {
            rememberCheckBox.click();
        }
        loginButton.click();
    }
}
