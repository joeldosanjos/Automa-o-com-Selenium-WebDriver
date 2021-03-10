package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Lista extends PageObject {
	
	// @FindBy(xpath = "//h3[contains(text(),'Coleira Petz Azul para Cães')]")
	// private WebElement produtoDesejado;
	
	@FindBy(xpath = "/html[1]/body[1]/div[9]/div[2]/div[2]/div[2]/div[1]/h1[1]")
	WebElement cabecalhoResultado;
	

	public Lista(WebDriver driver) {
		super(driver);
	}
	
	public void clicarNoProduto(String produto) {
		// produtoDesejado.click();
		
		// Encontrar produto dinamicamente, conforme especificado no arquivo .feature:
		WebElement ProdutoDesejado = driver.findElement(By.xpath("//h3[contains(text(),'" + produto + "')]"));
		ProdutoDesejado.click();
	}
	
	public String lerCabecalhoResultado() {
		// WebElement CabecalhoResultado = driver.findElement(By.cssSelector("h2Categoria.nomeCategoria"));	
		return cabecalhoResultado.getText();
	}
}
