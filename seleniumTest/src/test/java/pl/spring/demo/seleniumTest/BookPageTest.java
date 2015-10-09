package pl.spring.demo.seleniumTest;


import java.util.List;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import pl.spring.demo.seleniumTest.pages.BookPage;
import pl.spring.demo.seleniumTest.site.Site;
import pl.spring.demo.seleniumTest.testCore.SeleniumTestCase;

public class BookPageTest extends SeleniumTestCase {

	@Autowired
	private Site site;

	@Test
	public void testSiteAdress() {
		BookPage page = site.gotoBookPage();

		Assert.assertEquals(page.getAdress(), site.getCurrentAdress());

	}

	@Test
	public void testSearchElement() {
		String search = "Potop";
		BookPage page = site.gotoBookPage();
		page.getSearchField().sendKeys(search);
		page.getSearchButton().click();

		List<WebElement> tableRows = page.getResultList();
		Boolean res = tableRows.stream().map(p -> p.getText()).collect(Collectors.toList()).contains(search);

		Assert.assertTrue(res);

	}

	@Test
	public void testAddModalShow() {
		BookPage page = site.gotoBookPage();
		page.getAddButton().click();
		WebDriverWait block = new WebDriverWait(site.getDriver(), 10);
		WebElement modal = block.until(ExpectedConditions.visibilityOfElementLocated(By.name("form.BookAddForm")));
		Boolean result=modal.isDisplayed();

		Assert.assertTrue(result);
	}
	
	@Test
	public void testAddModalBookWithoutAuthor() {
		BookPage page = site.gotoBookPage();
		String send="Potop";
		page.getAddButton().click();
		WebDriverWait block = new WebDriverWait(site.getDriver(), 10);
		WebElement modal = block.until(ExpectedConditions.visibilityOfElementLocated(By.className("ng-scope")));
	
		WebElement field=modal.findElement(By.name("modalBookTitle"));
		field.sendKeys(send);
		WebElement footer=modal.findElement(By.cssSelector(".modal-footer"));
		WebElement save =footer.findElement(By.cssSelector(".btn-success"));
		Boolean result=!save.isEnabled();

		Assert.assertTrue(result);	
		
	}
	
	@Test
	public void testAddAuthorInsertKeysAndTryClickEmpytLast() {
		String name="Jan";
		String lastName="";
		BookPage page = site.gotoBookPage();
		String send="Potop";
		page.getAddButton().click();
		
		WebElement modal=site.getModalWindow(By.className("ng-scope"));
		WebElement field=modal.findElement(By.name("modalBookTitle"));
		WebElement addAuthor=modal.findElement(By.cssSelector(".btn-xs"));
		
		field.sendKeys(send);
		addAuthor.click();
		
		WebElement addAuthorModal=site.getModalWindow(By.className("ng-scope"));
		WebElement authorNameField=addAuthorModal.findElement(By.name("modalAuthorName"));
		WebElement authorLastNameField=addAuthorModal.findElement(By.name("modalAuthorlastName"));
		WebElement footerAuthorModal=addAuthorModal.findElement(By.cssSelector(".modal-footer"));
		WebElement saveAuthor =footerAuthorModal.findElement(By.cssSelector(".btn-success"));
		
		authorNameField.sendKeys(name);
		authorLastNameField.sendKeys(lastName);
		
		Boolean result=!saveAuthor.isEnabled();

		Assert.assertTrue(result);	
		
	}
	@Test
	public void testAddAuthorInsertKeysAndTryClickEmptyFirst() {
		String name="";
		String lastName="Kowalski";
		BookPage page = site.gotoBookPage();
		String send="Potop";
		page.getAddButton().click();
		
		WebElement modal=site.getModalWindow(By.className("ng-scope"));
		WebElement field=modal.findElement(By.name("modalBookTitle"));
		WebElement addAuthor=modal.findElement(By.cssSelector(".btn-xs"));
		
		field.sendKeys(send);
		addAuthor.click();
		
		WebElement addAuthorModal=site.getModalWindow(By.className("ng-scope"));
		WebElement authorNameField=addAuthorModal.findElement(By.name("modalAuthorName"));
		WebElement authorLastNameField=addAuthorModal.findElement(By.name("modalAuthorlastName"));
		WebElement footerAuthorModal=addAuthorModal.findElement(By.cssSelector(".modal-footer"));
		WebElement saveAuthor =footerAuthorModal.findElement(By.cssSelector(".btn-success"));
		
		authorNameField.sendKeys(name);
		authorLastNameField.sendKeys(lastName);
		
		Boolean result=!saveAuthor.isEnabled();

		Assert.assertTrue(result);	
		
	}
	@Test
	public void testAddAuthorInsertKeysAndTryClickNumericFirst() {
		String name="324324124123";
		String lastName="Kowalski";
		BookPage page = site.gotoBookPage();
		String send="Potop";
		page.getAddButton().click();
		
		WebElement modal=site.getModalWindow(By.className("ng-scope"));
		WebElement field=modal.findElement(By.name("modalBookTitle"));
		WebElement addAuthor=modal.findElement(By.cssSelector(".btn-xs"));
		
		field.sendKeys(send);
		addAuthor.click();
		
		WebElement addAuthorModal=site.getModalWindow(By.className("ng-scope"));
		WebElement authorNameField=addAuthorModal.findElement(By.name("modalAuthorName"));
		WebElement authorLastNameField=addAuthorModal.findElement(By.name("modalAuthorlastName"));
		WebElement footerAuthorModal=addAuthorModal.findElement(By.cssSelector(".modal-footer"));
		WebElement saveAuthor =footerAuthorModal.findElement(By.cssSelector(".btn-success"));
		
		authorNameField.sendKeys(name);
		authorLastNameField.sendKeys(lastName);
		
		Boolean result=!saveAuthor.isEnabled();

		Assert.assertTrue(result);	
		
	}
	@Test
	public void testAddAuthorInsertKeysAndTryClickNumericLast() {
		String name="Jan";
		String lastName="423534534";
		BookPage page = site.gotoBookPage();
		String send="Potop";
		page.getAddButton().click();
		
		WebElement modal=site.getModalWindow(By.className("ng-scope"));
		WebElement field=modal.findElement(By.name("modalBookTitle"));
		WebElement addAuthor=modal.findElement(By.cssSelector(".btn-xs"));
		
		field.sendKeys(send);
		addAuthor.click();
		
		WebElement addAuthorModal=site.getModalWindow(By.className("ng-scope"));
		WebElement authorNameField=addAuthorModal.findElement(By.name("modalAuthorName"));
		WebElement authorLastNameField=addAuthorModal.findElement(By.name("modalAuthorlastName"));
		WebElement footerAuthorModal=addAuthorModal.findElement(By.cssSelector(".modal-footer"));
		WebElement saveAuthor =footerAuthorModal.findElement(By.cssSelector(".btn-success"));
		
		authorNameField.sendKeys(name);
		authorLastNameField.sendKeys(lastName);
		
		Boolean result=!saveAuthor.isEnabled();
		
		Assert.assertTrue(result);	
		
	}
	@Test
	public void testAddAuthorInsertKeysAndTryClickTooShort() {
		String name="J";
		String lastName="A";
		BookPage page = site.gotoBookPage();
		String send="Potop";
		page.getAddButton().click();
		
		WebElement modal=site.getModalWindow(By.className("ng-scope"));
		WebElement field=modal.findElement(By.name("modalBookTitle"));
		WebElement addAuthor=modal.findElement(By.cssSelector(".btn-xs"));
		
		field.sendKeys(send);
		addAuthor.click();
		
		WebElement addAuthorModal=site.getModalWindow(By.className("ng-scope"));
		WebElement authorNameField=addAuthorModal.findElement(By.name("modalAuthorName"));
		WebElement authorLastNameField=addAuthorModal.findElement(By.name("modalAuthorlastName"));
		WebElement footerAuthorModal=addAuthorModal.findElement(By.cssSelector(".modal-footer"));
		WebElement saveAuthor =footerAuthorModal.findElement(By.cssSelector(".btn-success"));
		
		authorNameField.sendKeys(name);
		authorLastNameField.sendKeys(lastName);
		

		
		Boolean result=!saveAuthor.isEnabled();

		Assert.assertTrue(result);	
		
	}
	
	@Test
	public void testAddBookPassed() {
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
		
		List<WebElement> tableRows = page.getResultList();
		Boolean res = tableRows.stream().map(p -> p.getText()).collect(Collectors.toList()).contains(send);
		Assert.assertTrue(res);	
	}
	
	@Test
	public void testAddBookToShortTitle() {
		String name="Jan";
		String lastName="Kowalski";
		BookPage page = site.gotoBookPage();
		String send="S";
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
		
		Assert.assertTrue(!save.isEnabled());	
	}
	
	@Test
	public void testEditBook() {
		//given
	
		BookPage page = site.gotoBookPage();
		page.getSearchButton().click();
		
		WebElement editButton=site.getDriver().findElements(By.xpath("//button[@class='btn  btn-sm btn-primary']")).get(0);
		//when
		editButton.click();
		//then
		WebDriverWait block = new WebDriverWait(site.getDriver(), 10);
		WebElement modal = block.until(ExpectedConditions.visibilityOfElementLocated(By.name("form.BookAddForm")));
		Boolean result=modal.isDisplayed();

		Assert.assertTrue(result);

	}
	
	@Test
	public void testEditAndDeleteAuthorThenTrySave() {
		//given
	
		BookPage page = site.gotoBookPage();
		page.getSearchButton().click();
		
		WebElement editButton=site.getDriver().findElements(By.xpath("//button[@class='btn  btn-sm btn-primary']")).get(0);
		//when
		editButton.click();
		//then
		WebDriverWait block = new WebDriverWait(site.getDriver(), 10);
		WebElement modal = block.until(ExpectedConditions.visibilityOfElementLocated(By.name("form.BookAddForm")));
		
		WebElement deleteAuthorFromBook=modal.findElement(By.xpath("//button[@class='btn btn-xs btn-danger']"));
		deleteAuthorFromBook.click();
		WebElement save=site.getDriver().findElement(By.xpath("//div[@class='modal-footer']/button[@class='btn btn-success']"));
		
		Assert.assertTrue(!save.isEnabled());

	}
	@Test
	public void testDeleteBook() {
		//given
		Actions actionObject = new Actions(site.getDriver());
		BookPage page = site.gotoBookPage();
		page.addBook(site);
		
		actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.F5).keyUp(Keys.CONTROL).perform();
		page.getSearchButton().click();
		List<WebElement> deleteButtons=site.getDriver().findElements(By.xpath("//button[@class='btn btn-sm btn-danger tablemMargin']"));
		int deleteButtonsSizeBeforeDeleteRow=deleteButtons.size();
		//when
		deleteButtons.get(0).click();
		actionObject.keyDown(Keys.CONTROL).sendKeys(Keys.F5).keyUp(Keys.CONTROL).perform();
		page.getSearchButton().click();
		List<WebElement> deleteButtonsAfter=site.getDriver().findElements(By.xpath("//button[@class='btn btn-sm btn-danger tablemMargin']"));
		int deleteButtonsSizeAfterDeleteRow=deleteButtonsAfter.size();
		//then
		Assert.assertEquals( deleteButtonsSizeBeforeDeleteRow-1, deleteButtonsSizeAfterDeleteRow);



	}
}
