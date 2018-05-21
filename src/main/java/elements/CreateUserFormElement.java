package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.fail;

public class CreateUserFormElement {

    private final WebDriver webDriver;

    private final WebElement loginInput;

    private final WebElement passwordInput;

    private final WebElement confirmPasswordInput;

    private final WebElement forceChangeCheckbox;

    private final WebElement fullNameInput;

    private final WebElement emailInput;

    private final WebElement jabberInput;

    private final WebElement closeButton;

    private final WebElement okButton;

    private final WebElement cancelButton;

    public CreateUserFormElement(final WebDriver webDriver) throws InterruptedException {
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (webDriver.findElement(By.id("id_l.U.cr.login")).isDisplayed()) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }
        this.webDriver = webDriver;
        loginInput = webDriver.findElement(By.xpath("//*[@id=\"id_l.U.cr.login\"]"));
        passwordInput = webDriver.findElement(By.xpath("//*[@id=\"id_l.U.cr.password\"]"));
        confirmPasswordInput = webDriver.findElement(By.xpath("//*[@id=\"id_l.U.cr.confirmPassword\"]"));
        forceChangeCheckbox = webDriver.findElement(By.xpath("//*[@id=\"id_l.U.cr.forcePasswordChange\"]"));
        fullNameInput = webDriver.findElement(By.xpath("//*[@id=\"id_l.U.cr.fullName\"]"));
        emailInput = webDriver.findElement(By.xpath("//*[@id=\"id_l.U.cr.email\"]"));
        jabberInput = webDriver.findElement(By.xpath("//*[@id=\"id_l.U.cr.jabber\"]"));
        closeButton = webDriver.findElement(By.xpath("//*[@id=\"id_l.U.cr.closeCreateUserDlg\"]"));
        okButton = webDriver.findElement(By.xpath("//*[@id=\"id_l.U.cr.createUserOk\"]"));
        cancelButton = webDriver.findElement(By.xpath("//*[@id=\"id_l.U.cr.createUserCancel\"]"));
    }

    public void typeLogin(final String login) {
        loginInput.sendKeys(login);
    }

    public void typePassword(final String password) {
        passwordInput.sendKeys(password);
    }

    public void typeConfirmPassword(final String confirmPassword) {
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    public void setForceChange(final boolean forceChange) {
        if (forceChange) {
            forceChangeCheckbox.click();
        }
    }

    public void typeFullName(final String fullName) {
        fullNameInput.sendKeys(fullName);
    }

    public void typeEmailInput(final String email) {
        emailInput.sendKeys(email);
    }

    public void typeJabberInput(final String jabber) {
        jabberInput.sendKeys(jabber);
    }

    public void close() {
        closeButton.click();
    }

    public void cancel() {
        cancelButton.click();
    }

    public void ok() {
        okButton.click();
    }


}
