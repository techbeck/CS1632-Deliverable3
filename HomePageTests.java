//package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HomePageTests {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new HtmlUnitDriver();
    java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF); 
    baseUrl = "https://cs1632ex.herokuapp.com";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

// This test tests that the string "Used for CS1632... (et cetera)" is on the first page as defined by Req. 1.
  @Test
  public void testUsedStringReq1() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("CS1632 D3 Home")).click();
    assertEquals("Used for CS1632 Software Quality Assurance, taught by Bill Laboon", driver.findElement(By.cssSelector("div.row > p.lead")).getText());
  }
// This test tests that the string "Welcome, friend... (et cetera)" is on the first page as defined by Req. 1.
// Needs Regex for spacing and to assure that the message exists (among the other messages)
  @Test
  public void testPureCalculationStringReq1() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("CS1632 D3 Home")).click();
    assertTrue(driver.findElement(By.cssSelector("p.lead")).getText().matches("^[\\s\\S]*Welcome, friend,[\\s\\S]*to a land of pure calculation\\.[\\s\\S]*$"));
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
