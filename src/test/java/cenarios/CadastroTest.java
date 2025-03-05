package cenarios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.CadastroPage;

import java.time.Duration;

public class CadastroTest {

    WebDriver driver;
    CadastroPage cadastroPage;

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        cadastroPage = new CadastroPage(driver);
        driver.get("http://localhost:3000/");
    }

    @Test
    public void testeCadastro() {

        cadastroPage.clicarPorXpath(cadastroPage.btnRegistrar);
        cadastroPage.preecherValorPorXpath(cadastroPage.campoEmail, "lut@gmail.com");
        cadastroPage.preecherValorPorXpath(cadastroPage.campoNome, "Miguel Machado");
        cadastroPage.preecherValorPorXpath(cadastroPage.campoSenha, "123456");
        cadastroPage.preecherValorPorXpath(cadastroPage.campoConfirmacaoSenha, "123456");
        cadastroPage.clicarPorXpath(cadastroPage.btnContaComSaldoToggle);
        cadastroPage.clicarPorXpath(cadastroPage.btnCadastrar);
        cadastroPage.validarContaCriadaComSucesso();
        cadastroPage.clicarPorXpath(cadastroPage.btnFechar);
    }

    @After
    public void after() {
        driver.quit();

    }
}
