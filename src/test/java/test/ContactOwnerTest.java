package test;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.HomePage;
import pages.propertiesPage;
import utils.Base;

public class ContactOwnerTest extends Base{
	
	HomePage prop;
	propertiesPage propselect;
  @Test
  @Description("Verify product selection from menu")
	@Severity(SeverityLevel.CRITICAL)
  public void contactOwner() throws Exception  {
	  //String name = "pune";

	  prop  = new HomePage();
	  prop.searchApartment();
	  
	  propselect = new propertiesPage();
	  propselect.clickOwnerDetailsAndCaptureScreenshot();
  }
}
