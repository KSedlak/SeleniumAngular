package pl.spring.demo.seleniumTest;


import java.util.List;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import pl.spring.demo.seleniumTest.pages.AuthorPage;
import pl.spring.demo.seleniumTest.site.Site;
import pl.spring.demo.seleniumTest.testCore.SeleniumTestCase;

public class AuthorPageTest extends SeleniumTestCase {
	 
	 @Autowired
	 private Site site;
	 
	 
	 
	 @Test
	 public void testSiteAdress() {
		AuthorPage page=site.gotoAuthorPage();

		Assert.assertEquals(page.getAdress(), site.getCurrentAdress());
		
	 }
	 
	 @Test
	 public void testSearchElement() {
		 	String search="Kowalski";
			AuthorPage page=site.gotoAuthorPage();
			page.getSearchField().sendKeys(search);
			page.getSearchButton().click();
			
			List<WebElement> tableRows = page.getResultList();
			Boolean res=tableRows.stream().map(p->p.getText()).collect(Collectors.toList()).contains(search);

			Assert.assertTrue(res);
			
	 }
	 
	 @Test
	 public void testSearchElementDynamicUpdate() {
		 	String search="Jan";
			AuthorPage page=site.gotoAuthorPage();
			page.getSearchField().sendKeys(search);
			page.getSearchButton().click();
			List<WebElement> tableRows = page.getResultList();
			int sizeBefore=tableRows.size();
			page.getSearchField().sendKeys("ko");
			tableRows = page.getResultList();
			int after=tableRows.size();
			Assert.assertTrue(after<sizeBefore);
			
	 }
}
	 
	 
	