package cenarios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.CadastroPage;
import page.HomePage;
import page.LoginPage;
import page.TransferenciaPage;

import java.time.Duration;

public class TransferenciaTest {

    WebDriver driver;
    LoginPage loginPage;
    CadastroPage cadastroPage;
    TransferenciaPage transferenciaPage;
    HomePage homePage;

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        loginPage = new LoginPage(driver);
        cadastroPage = new CadastroPage(driver);
        transferenciaPage = new TransferenciaPage(driver);
        homePage = new HomePage(driver);
        driver.get("http://localhost:3000/transfer");
    }

    @Test
    public void testeTransferecia() {

        cadastroPage.cadatrarNovaConta("teste@gmail.com", "Jose", "123456");
        String conta1 = cadastroPage.conta;
        String digito1 = cadastroPage.digito;
        cadastroPage.cadatrarNovaConta("teste2@gmail.com", "João", "123456");
        String conta2 = cadastroPage.conta;
        String digito2 = cadastroPage.digito;
        System.out.println(conta2 + digito2);
        loginPage.fazerLogin("teste@gmail.com", "123456");
        homePage.clicarPorXpath(homePage.btnTransferencia);
        transferenciaPage.preencherValorPorXpath(transferenciaPage.campoNumeroDaConta, conta2);
        transferenciaPage.preencherValorPorXpath(transferenciaPage.campoDigito, digito2);
        transferenciaPage.preencherValorPorXpath(transferenciaPage.campoValorTransferencia, "500.00");
        transferenciaPage.preencherValorPorXpath(transferenciaPage.campoDescricao, "QA Academy");
        transferenciaPage.clicarPorXpath(transferenciaPage.btnTransferirAgora);
        transferenciaPage.transferenciaFeitaComSucesso();
    }

    @After
    public void after() {
        driver.quit();
    }
}
