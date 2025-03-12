package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public String elemento = "//*[@id=\"textBalance\"]";

    public String btnTransferencia = "//*[@id=\"btn-TRANSFERÊNCIA\"]/span/img";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void validarSaldo(String valorEsperado) {
        String atual = driver.findElement(By.xpath(elemento)).getText();
        Assert.assertEquals(valorEsperado, atual);
    }

    public void clicarPorXpath(String elemento) {
        driver.findElement(By.xpath(elemento)).click();

    }

}
