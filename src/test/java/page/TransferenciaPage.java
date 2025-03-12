package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TransferenciaPage {

    WebDriver driver;

    public String campoNumeroDaConta = "//body/div[@id='__next']/div[1]/div[3]/form[1]/div[1]/div[1]/input[1]";

    public String campoDigito = "//body/div[@id='__next']/div[1]/div[3]/form[1]/div[1]/div[2]/input[1]";

    public String campoValorTransferencia = "//body/div[@id='__next']/div[1]/div[3]/form[1]/div[2]/input[1]";

    public String campoDescricao = "//body/div[@id='__next']/div[1]/div[3]/form[1]/div[3]/input[1]";

    public String btnTransferirAgora = "//button[contains(text(),'Transferir agora')]";

    public TransferenciaPage(WebDriver driver) {
        this.driver = driver;
    }


    public void preencherValorPorXpath(String elemento, String valor) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> d.findElement(By.xpath(elemento)).isDisplayed());
        driver.findElement(By.xpath(elemento)).sendKeys(valor);
    }

    public void clicarPorXpath(String elemento) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> d.findElement(By.xpath(elemento)).isDisplayed());
        driver.findElement(By.xpath(elemento)).click();
    }

    public void transferenciaFeitaComSucesso() {
        String msgErro = "Erro ao validar a transferencia";
        String msgSucesso = "Transferencia realizada com sucesso";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> d.getPageSource().contains(msgSucesso));
        Assert.assertTrue(msgErro, driver.getPageSource().contains(msgSucesso));
    }
}
