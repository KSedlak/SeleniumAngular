package pl.spring.demo.seleniumTest.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;


import pl.spring.demo.seleniumTest.abstractPage.PageObject;
import pl.spring.demo.seleniumTest.site.Site;

@PageObject
public class BookPage {

	private String adress;

	@FindBy(tagName="input")
	private WebElement searchField;
	@FindBy(css=".btn-default")
	private WebElement searchButton;
	@FindBy(css=".btn-default+.btn-default")
	private WebElement addButton;
	@FindAll(@FindBy(css=".tablemMargin"))
	private List<WebElement> resultList;

	public List<WebElement> getResultList() {
		return resultList;
	}


	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getAdress() {
		return adress;
	}


	public WebElement getAddButton() {
		return addButton;
	}


	public void setAddButton(WebElement addButton) {
		this.addButton = addButton;
	}

	
	public void addBook(Site site){
		String name="Jan";
		String lastName="Kowalski";
		BookPage page = site.gotoBookPage();
		String send="Selenium Testing";
		page.getAddButton().click();
		
		WebElement modal=site.getModalWindow(By.className("ng-scope"));
		WebElement field=modal.findElement(By.name("modalBookTitle"));
		WebElement footer=modal.findElement(By.cssSelector(".modal-footer"));
		WebElement save =footer.findElement(By.cssSelector(".btn-success"));
		WebElement addAuthor=modal.findElement(By.cssSelector(".btn-xs"));
		
		field.sendKeys(send);
		addAuthor.click();
		
		WebElement addAuthorModal=site.getModalWindow(By.className("ng-scope"));
		WebElement authorNameField=addAuthorModal.findElement(By.name("modalAuthorName"));
		WebElement authorLastNameField=addAuthorModal.findElement(By.name("modalAuthorlastName"));
		WebElement footerAuthorModal=addAuthorModal.findElement(By.cssSelector(".modal-footer"));
		WebElement saveAuthor =footerAuthorModal.findElement(By.xpath("//button[contains(@ng-click,'ok') and text()='Dodaj']"));
		
		authorNameField.sendKeys(name);
		authorLastNameField.sendKeys(lastName);		
		
		saveAuthor.click();
		modal = site.getModalWindow(By.name("form.BookAddForm"));
		
		save.click();
		site.getModalWindow(By.className("tablemMargin"));
	}
}
