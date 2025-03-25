package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.CadastroPage;
import page.HomePage;
import page.LoginPage;

import java.time.Duration;

public class LoginStep {

    WebDriver driver;
    LoginPage loginPage;
    CadastroPage cadastroPage;
    HomePage homePage;

    @Dado("que eu esteja logado no pugbank com email: {string} e a senha: {string}")
    public void queEuEstejaLogadoNoPugbankComEmailEASenha(String email, String senha) {
        loginPage.fazerLogin(email, senha);
    }

    @Quando("carregar a homepage")
    public void carregarAHomepage() {
        loginPage.validarLogin();
    }

    @Entao("validar se o saldo é igual: {string}")
    public void validarSeOSaldoEIgual(String valor) {
        homePage.validarSaldo("Saldo em conta R$ " + valor);
    }

    @Dado("que eu possua cadastro no pugbank o email: {string}, nome: {string} e a senha: {string}")
    public void queEuPossuaCadastroNoPugbankOEmailNomeEASenha(String email, String nome, String senha) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        loginPage = new LoginPage(driver);
        cadastroPage = new CadastroPage(driver);
        homePage = new HomePage(driver);
        driver.get("http://localhost:3000/");

        cadastroPage.clicarPorXpath(cadastroPage.btnRegistrar);
        cadastroPage.preencherValorPorXpath(cadastroPage.campoEmail, email);
        cadastroPage.preencherValorPorXpath(cadastroPage.campoNome, nome);
        cadastroPage.preencherValorPorXpath(cadastroPage.campoSenha, senha);
        cadastroPage.preencherValorPorXpath(cadastroPage.campoConfirmacaoSenha, senha);
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
