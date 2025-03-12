package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CadastroPage {

    WebDriver driver;
    public String conta;
    public String digito;

    public CadastroPage(WebDriver driver) {
        this.driver = driver;
    }

    public String campoEmail = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/input";

    public String campoNome = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[3]/input";

    public String campoSenha = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[4]/div/input";

    public String campoConfirmacaoSenha = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[5]/div/input";

    public String btnContaComSaldoToggle = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[6]/label";

    public String btnCadastrar = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/button";

    public String btnRegistrar = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[2]";

    public String btnFechar = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/a[1]";

    public String msgContaCriada = "//*[@id=\"modalText\"]";


    public void preencherValorPorXpath(String elemento, String valor) {
        driver.findElement(By.xpath(elemento)).clear();
        driver.findElement(By.xpath(elemento)).sendKeys(valor);
    }

    public void clicarPorXpath(String elemento) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> d.findElement(By.xpath(elemento)).isDisplayed());
        driver.findElement(By.xpath(elemento)).click();
    }

    public void validarContaCriadaComSucesso() {
        Assert.assertTrue(driver.getPageSource().contains("foi criada com sucesso"));
    }

    public void cadatrarNovaConta(String email, String nome, String senha) {
        clicarPorXpath(btnRegistrar);
        preencherValorPorXpath(campoEmail, email);
        preencherValorPorXpath(campoNome, nome);
        preencherValorPorXpath(campoSenha, senha);
        preencherValorPorXpath(campoConfirmacaoSenha, (senha));
        clicarPorXpath(btnContaComSaldoToggle);
        clicarPorXpath(btnCadastrar);
        validarContaCriadaComSucesso();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> d.findElement(By.xpath(msgContaCriada)).isDisplayed());
        String mensagemCadastro = driver.findElement(By.xpath(msgContaCriada)).getText();
        String[] numConta = mensagemCadastro.split("conta|foi");
        String txtContaEdigito = numConta[1].trim();
        String[] contaDigito = txtContaEdigito.split("-");
        this.conta = contaDigito[0];
        this.digito = contaDigito[1];
        clicarPorXpath(btnFechar);

    }

}



