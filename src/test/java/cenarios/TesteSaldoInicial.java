package cenarios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.CadastroPage;
import page.HomePage;
import page.LoginPage;

import java.time.Duration;

public class TesteSaldoInicial {

    WebDriver driver;
    LoginPage loginPage;
    CadastroPage cadastroPage;
    HomePage homePage;

    @Before
    public void before() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        loginPage = new LoginPage(driver);
        cadastroPage = new CadastroPage(driver);
        homePage = new HomePage(driver);

        driver.get("http://localhost:3000/");
    }

    @Test
    public void testeSaldoInicial() {

        cadastroPage.clicarPorXpath(cadastroPage.btnRegistrar);
        cadastroPage.preencherValorPorXpath(cadastroPage.campoEmail, "lut@gmail.com");
        cadastroPage.preencherValorPorXpath(cadastroPage.campoNome, "Miguel Machado");
        cadastroPage.preencherValorPorXpath(cadastroPage.campoSenha, "123456");
        cadastroPage.preencherValorPorXpath(cadastroPage.campoConfirmacaoSenha, "123456");
        cadastroPage.clicarPorXpath(cadastroPage.btnContaComSaldoToggle);
        cadastroPage.clicarPorXpath(cadastroPage.btnCadastrar);
        cadastroPage.validarContaCriadaComSucesso();
        cadastroPage.clicarPorXpath(cadastroPage.btnFechar);

        loginPage.preecherValorPorXpath(loginPage.campEmail, "lut@gmail.com");
        loginPage.preecherValorPorXpath(loginPage.campSenha, "123456");
        loginPage.clicarPorXpath(loginPage.btnAcessar);
        loginPage.validarLogin();

        homePage.validarSaldo("Saldo em conta R$ 1.000,00");
    }
    @After
    public void after() {
        driver.quit();
    }
}
