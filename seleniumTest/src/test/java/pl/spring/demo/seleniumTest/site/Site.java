package pl.spring.demo.seleniumTest.site;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import pl.spring.demo.seleniumTest.abstractPage.PageObject;
import pl.spring.demo.seleniumTest.pages.AuthorPage;
import pl.spring.demo.seleniumTest.pages.BookPage;
import pl.spring.demo.seleniumTest.pages.HomePage;

@PageObject
public class Site {

	@Autowired
	private WebDriver driver;

	@Value("${server}")
	private String serviceAdress;
	@Value("${server.home}")
	private String home;
	@Value("${server.bookList}")
	private String bookList;
	@Value("${server.bookAdd}")
	private String bookAdd;
	@Value("${server.bookEdit}")
	private String bookEdit;
	@Value("${server.authorList}")
	private String authorList;
	@Value("${server.authorAdd}")
	private String authorAdd;
	@Value("${server.authorEdit}")
	private String authorEdit;
	@Value("${server.component1}")
	private String component1;
	@Value("${server.component2}")
	private String component2;

	@Autowired
	private HomePage homePage;
	@Autowired
	private AuthorPage authorPage;
	@Autowired
	private BookPage bookPage;

	public HomePage gotoHomePage() {
		driver.get(serviceAdress);
		homePage.setAdress(serviceAdress + home);
		return homePage;
	}

	public AuthorPage gotoAuthorPage() {
		driver.get(serviceAdress + authorList);
		driver.navigate().refresh();
		authorPage.setAdress(serviceAdress + authorList);
		return authorPage;
	}

	public BookPage gotoBookPage() {
		driver.get(serviceAdress + bookList);
		driver.navigate().refresh();
		bookPage.setAdress(serviceAdress + bookList);
		return bookPage;
	}

	public String getCurrentAdress() {
		return driver.getCurrentUrl();
	}

	public String getServiceAdress() {
		return serviceAdress;
	}

	public void setServiceAdress(String serviceAdress) {
		this.serviceAdress = serviceAdress;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void switchDriverToActive() {
		driver.switchTo().activeElement();
	}

	public WebElement getModalWindow(By until) {
		WebDriverWait block = new WebDriverWait(getDriver(), 10);
		WebElement modal = block.until(ExpectedConditions.visibilityOfElementLocated(until));
		return modal;
	}

	public void printAllchild(WebElement x) {
		List<WebElement> childs = x.findElements(By.cssSelector("*"));
		childs.stream().forEach(w -> {
			System.out.println(w.getText());
		});
	}

	public String getHome() {
		return home;
	}

	public String getBookList() {
		return bookList;
	}

	public String getBookAdd() {
		return bookAdd;
	}

	public String getBookEdit() {
		return bookEdit;
	}

	public String getAuthorList() {
		return authorList;
	}

	public String getAuthorAdd() {
		return authorAdd;
	}

	public String getAuthorEdit() {
		return authorEdit;
	}

	public HomePage getHomePage() {
		return homePage;
	}

	public AuthorPage getAuthorPage() {
		return authorPage;
	}

	public BookPage getBookPage() {
		return bookPage;
	}

	public String getComponent1() {
		return component1;
	}

	public String getComponent2() {
		return component2;
	}

}