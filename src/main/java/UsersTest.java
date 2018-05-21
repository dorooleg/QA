import elements.CreateUserFormElement;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;
import pages.UsersPage;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class UsersTest {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", Paths.get("src", "main", "java", "geckodriver.exe").toAbsolutePath().toString());
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void singleUserTest() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        UsersPage usersPage = loginPage.login("root", "1", false);
        createUser(usersPage.createUser(), "example", "pswd");
        usersPage.goToUsers();
        Assert.assertTrue(usersPage.getUsersTable().containsByLoginColumn("example"));
        usersPage.getUsersTable().deleteByLoginColumn("example");
        Thread.sleep(5000);
    }

    @Test
    public void manyUsersTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        UsersPage usersPage = loginPage.login("root", "1", false);
        createUser(usersPage.createUser(), "example", "pswd");
        usersPage.goToUsers();
        createUser(usersPage.createUser(), "example2", "pswd");
        usersPage.goToUsers();
        Assert.assertTrue(usersPage.getUsersTable().containsByLoginColumn("example"));
        usersPage.getUsersTable().deleteByLoginColumn("example");
        Thread.sleep(1000);
        Assert.assertTrue(usersPage.getUsersTable().containsByLoginColumn("example2"));
        usersPage.getUsersTable().deleteByLoginColumn("example2");
        Thread.sleep(5000);
    }

    @Test
    public void failedCreateUser() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        UsersPage usersPage = loginPage.login("root", "1", false);
        createUser(usersPage.createUser(), "example", "pswd");
        usersPage.goToUsers();
        CreateUserFormElement userForm = usersPage.createUser();
        createUser(userForm, "example", "pswd");
        Assert.assertEquals("Value should be unique: login", usersPage.getErrorPopup().getText());
        userForm.cancel();
        Assert.assertTrue(usersPage.getUsersTable().containsByLoginColumn("example"));
        usersPage.getUsersTable().deleteByLoginColumn("example");
        Thread.sleep(5000);
    }

    public void createUser(CreateUserFormElement form, String name, String password) {
        form.typeLogin(name);
        form.typePassword(password);
        form.typeConfirmPassword(password);
        form.ok();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
