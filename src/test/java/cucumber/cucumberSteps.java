package cucumber;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import entidades.Entidades;
import jdbc.CrudBanco;
import junit.framework.Assert;

public class cucumberSteps {

	private WebDriver driver;

	public CrudBanco banco = new CrudBanco();
	public List<Entidades> listaResultado = banco.consultarTodos();

	@Before("@start")
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/yohan/Desktop/WorkSpace/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Given("^que eu estou na pagina inicial da porto seguros$")
	public void abrirPaginaInicial() throws Throwable {
		driver.navigate().to("https://www.portoseguro.com.br");
	}

	@When("^eu clicar no link faca uma cotacao$")
	public void clicarLinkFacaUmaCotacao() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/nav/div[3]/a"))
				.click();
	}

	@Then("^deverei validar se estou na pagina de iniciar cotacao$")
	public void validarSeEstouNaPaginaCotacao() throws Throwable {
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL,
				"https://www.portoseguro.com.br/calcule-e-contrate");
	}

	@When("^informar um nome Válido$")
	public void informarNomeValido() throws Throwable {
		for (Entidades usuario : listaResultado) {

			driver.findElement(By.name("proponente.nomeProponente")).sendKeys(
					usuario.getNome());
		}
	}

	@And("^informar um cpf Válido$")
	public void informarCpfValido() throws Throwable {
		for (Entidades usuario : listaResultado) {

			driver.findElement(By.name("numeroCpf")).sendKeys(usuario.getCpf());
		}
	}

	@And("^informar um email Válido$")
	public void informarEmailValido() {
		for (Entidades usuario : listaResultado) {

			driver.findElement(By.name("proponente.descricaoEmailProponente"))
					.sendKeys(usuario.getEmail());
		}

	}
}