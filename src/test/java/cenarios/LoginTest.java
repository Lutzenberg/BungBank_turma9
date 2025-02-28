package cenarios;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.CadastroPage;
import page.LoginPage;

import java.time.Duration;

public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;
    CadastroPage cadastroPage;

    @Before
    public void before() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts();
        loginPage = new LoginPage(driver);
        cadastroPage = new CadastroPage(driver);
        driver.get("http://localhost:3000/");
    }

    @Test
    public void testLogin() {

        cadastroPage.clicarPorXpath(cadastroPage.btnRegistrar);
        cadastroPage.preecherValorPorXpath(cadastroPage.campoEmail, "lut@gmail.com");
        cadastroPage.preecherValorPorXpath(cadastroPage.campoNome, "Miguel Machado");
        cadastroPage.preecherValorPorXpath(cadastroPage.campoSenha, "123456");
        cadastroPage.preecherValorPorXpath(cadastroPage.campoConfirmacaoSenha, "123456");
        cadastroPage.clicarPorXpath(cadastroPage.btnContaComSaldoToggle);
        cadastroPage.clicarPorXpath(cadastroPage.btnCadastrar);
        cadastroPage.validarCotaCriaComucesso();
        cadastroPage.clicarPorXpath(cadastroPage.btnFechar);

        loginPage.preecherValorPorXpath(loginPage.campEmail, "lut@gmail.com");
        loginPage.preecherValorPorXpath(loginPage.campSenha, "123456");
        loginPage.clicarPorXpath(loginPage.btnAcessar);
        loginPage.validarLogin();

    }
}
