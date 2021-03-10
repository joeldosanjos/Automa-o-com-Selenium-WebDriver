package petz;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.Home;
import pages.Lista;
import pages.Produto;

public class ComprarProduto {
	
	// 3.1 - Atributos
	String url; 	  // Endereço do site-alvo
	WebDriver driver; // Objeto do Selenium WebDriver
	
	Home home;   	 // Objeto herdando a classe Home
	Lista lista; 	 // Objeto herdando a classe Lista
	Produto produto; // Objeto herdando a classe Produto
	
	// 3.2 - Métodos ou Funções
	@Before // Antes do Teste
	public void iniciar() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        
		url = "https://www.petz.com.br"; // Endereço da Petz		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		driver = new ChromeDriver(options); // Inicializa o ChromeDriver com opções do Chrome
		
		driver.manage().window().maximize(); // Maximizar a janela do browser
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS); // Espera implícita de 30 segundos
	
		home = new Home(driver);   	   // Instanciar a classe Home
		lista = new Lista(driver); 	   // Instanciar a classe Lista
		produto = new Produto(driver); // Instanciar a classe Produto
	}
	
	@After // Depois do Teste
	public void finalizar() {
		driver.quit();
	}

	
	@Dado("^que acesso o site Petz$")
	public void que_acesso_o_site_Petz() {
		driver.get(url); // Abre o site da Petz
		System.out.println("Passo 1");
	}

	@Quando("^busco por \"([^\"]*)\" e pressiono Enter$")
	public void busco_por_e_pressiono_Enter(String produto) {
		home.buscarProdutoComEnter(produto); // Busca por "coleira" e aperta enter
		System.out.println("Passo 2");
	}

	@Entao("^exibe uma lista de produtos relacionados com \"([^\"]*)\"$")
	public void exibe_uma_lista_de_produtos_relacionados_com(String produto) {
		assertEquals("RESULTADOS PARA \"" + produto.toUpperCase() + "\"", lista.lerCabecalhoResultado());
		System.out.println("Passo 3");
	}

	@Quando("^escolho \"([^\"]*)\"$")
	public void escolho(String produto) {
		lista.clicarNoProduto(produto);
		System.out.println("Passo 4");
	}

	@Entao("^exibe para o tamanho P o preco de \"([^\"]*)\"$")
	public void exibe_para_o_o_preco_de(String preco) {
		produto.clicarTamanho();
		assertEquals(preco, produto.lerPreco());
	}
	
}
