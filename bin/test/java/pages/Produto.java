package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Produto extends PageObject {

	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	@FindBy(xpath = "//div[@data-idvariacao='151785']")
	WebElement tamanho;
	
	@FindBy(xpath = "//div[@class = 'price-current']")
	WebElement preco;
	
	public Produto(WebDriver driver) {
		super(driver);
	}

	public void clicarTamanho() {
		tamanho.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//body/div[9]/main[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[3]/label[1]/div[1]/img[1]")));
	}
	
	public String lerPreco() {
		return preco.getText();
	}
}
