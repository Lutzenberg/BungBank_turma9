package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public String campEmail = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[1]/input";

    public String campSenha = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[2]/div/input";

    public String btnAcessar = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[1]";


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void preecherValorPorXpath(String elemento, String valor) {
        driver.findElement(By.xpath(elemento)).sendKeys(valor);
    }

    public void clicarPorXpath(String elemento) {
        driver.findElement(By.xpath(elemento)).click();

    }

    public void validarLogin() {
        Assert.assertTrue(driver.getPageSource().contains(" Assert.assertTrue(driver."));
    }

}
