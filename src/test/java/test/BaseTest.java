package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CartDetailPage;
import pages.HomePage;
import utils.Driver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BaseTest {

    public Driver driver;
    public HomePage homePage;
    public CartDetailPage cartDetailPage;

    @BeforeMethod
    public void startup() throws Exception {

        Path confDir = Paths.get(new File("target/images").getAbsolutePath());
        Files.createDirectories(confDir);

        driver = new Driver();
        homePage = new HomePage(driver);
        cartDetailPage = new CartDetailPage(driver);
    }

    @AfterMethod
    public void tearDownTest() {
        driver.closeDriver();
    }


}
