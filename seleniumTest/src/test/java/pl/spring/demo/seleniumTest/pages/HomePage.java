package pl.spring.demo.seleniumTest.pages;


import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import pl.spring.demo.seleniumTest.abstractPage.PageObject;

@PageObject
public class HomePage {

	private String adress;

	@FindBy(css = "a[class='navbar-brand']")
	private WebElement starterKitLink;

	@FindAll(@FindBy(css = ".navbar-nav a"))
	private List<WebElement> navbarLinks;

	@FindAll(@FindBy(css = ".list-group-item a"))
	private List<WebElement> listDialog;

	public List<WebElement> getListDialog() {
		return listDialog;
	}

	public void setListDialog(List<WebElement> listDialog) {
		this.listDialog = listDialog;
	}

	public WebElement getStarterKitLink() {
		return starterKitLink;
	}

	public void setStarterKitLink(WebElement starterKitLink) {
		this.starterKitLink = starterKitLink;
	}

	public List<WebElement> getNavbarLinks() {
		return navbarLinks;
	}

	public void setNavbarLinks(List<WebElement> navbarLinks) {
		this.navbarLinks = navbarLinks;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
}
