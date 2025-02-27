package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastroPage {

    WebDriver driver;

    public CadastroPage(WebDriver driver) {
        this.driver = driver;
    }

    public String campoEmail = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/input";

    public String campoNome = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[3]/input";

    public String campoSenha = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[4]/div/input";

    public String campoConfirmacaoSenha = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[5]/div/input";

    public String btnContaComSaldoToggle = "//*[@id=\"toggleAddBalance\"]";

    public String btnCadastrar = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/button";

    public String btnRegistrar = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[2]";

    public void preecherValorPorXpath(String elemento, String valor) {
        driver.findElement(By.xpath(elemento)).sendKeys(valor);
    }

    public void clicarPorXpath(String elemento) {
        driver.findElement(By.xpath(elemento)).click();
    }

    public void validarCotaCriaComucesso(){
        Assert.assertTrue(driver.getPageSource().contains("foi criada com sucesso"));
    }
}
