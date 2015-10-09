package pl.spring.demo.seleniumTest.pages;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import pl.spring.demo.seleniumTest.abstractPage.PageObject;


@PageObject
public class AuthorPage {

	private String adress;

	@FindBy(tagName="input")
	private WebElement searchField;
	@FindBy(css=".btn-default")
	private WebElement searchButton;
	@FindAll(@FindBy(css=".tablemMargin"))
	private List<WebElement> resultList;

	public List<WebElement> getResultList() {
		return resultList;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	
	


	

	
}
