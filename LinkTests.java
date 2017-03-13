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

public class LinkTests {
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

// This test tests the links on the Home page to see if they have the correct href tag.
  @Test
  public void testHomeLinks() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("CS1632 D3 Home")).click();
    assertEquals(baseUrl+ "/", driver.findElement(By.linkText("CS1632 D3 Home")).getAttribute("href"));
    assertEquals(baseUrl+ "/fact", driver.findElement(By.linkText("Factorial")).getAttribute("href"));
    assertEquals(baseUrl+ "/fib", driver.findElement(By.linkText("Fibonacci")).getAttribute("href"));
    assertEquals(baseUrl+ "/hello", driver.findElement(By.linkText("Hello")).getAttribute("href"));
    assertEquals(baseUrl+ "/cathy", driver.findElement(By.linkText("Cathedral Pics")).getAttribute("href"));
  }
// This test tests the links on the Factorial page to see if they have the correct href tag.
  @Test
  public void testFactorialLinks() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Factorial")).click();
    assertEquals(baseUrl+ "/", driver.findElement(By.linkText("CS1632 D3 Home")).getAttribute("href"));
    assertEquals(baseUrl+ "/fact", driver.findElement(By.linkText("Factorial")).getAttribute("href"));
    assertEquals(baseUrl+ "/fib", driver.findElement(By.linkText("Fibonacci")).getAttribute("href"));
    assertEquals(baseUrl+ "/hello", driver.findElement(By.linkText("Hello")).getAttribute("href"));
    assertEquals(baseUrl+ "/cathy", driver.findElement(By.linkText("Cathedral Pics")).getAttribute("href"));
  }
// This test tests the links on the Fibonacci page to see if they have the correct href tag.
  @Test
  public void testFibonacciLinks() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Fibonacci")).click();
    assertEquals(baseUrl+ "/", driver.findElement(By.linkText("CS1632 D3 Home")).getAttribute("href"));
    assertEquals(baseUrl+ "/fact", driver.findElement(By.linkText("Factorial")).getAttribute("href"));
    assertEquals(baseUrl+ "/fib", driver.findElement(By.linkText("Fibonacci")).getAttribute("href"));
    assertEquals(baseUrl+ "/hello", driver.findElement(By.linkText("Hello")).getAttribute("href"));
    assertEquals(baseUrl+ "/cathy", driver.findElement(By.linkText("Cathedral Pics")).getAttribute("href"));
  }
// This test tests the links on the Hello page to see if they have the correct href tag.
  @Test
  public void testHelloLinks() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Hello")).click();
    assertEquals(baseUrl+ "/", driver.findElement(By.linkText("CS1632 D3 Home")).getAttribute("href"));
    assertEquals(baseUrl+ "/fact", driver.findElement(By.linkText("Factorial")).getAttribute("href"));
    assertEquals(baseUrl+ "/fib", driver.findElement(By.linkText("Fibonacci")).getAttribute("href"));
    assertEquals(baseUrl+ "/hello", driver.findElement(By.linkText("Hello")).getAttribute("href"));
    assertEquals(baseUrl+ "/cathy", driver.findElement(By.linkText("Cathedral Pics")).getAttribute("href"));
  }
// This test tests the links on the Cathy page to see if they have the correct href tag.
  @Test
  public void testCathyLinks() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Cathedral Pics")).click();
    assertEquals(baseUrl+ "/", driver.findElement(By.linkText("CS1632 D3 Home")).getAttribute("href"));
    assertEquals(baseUrl+ "/fact", driver.findElement(By.linkText("Factorial")).getAttribute("href"));
    assertEquals(baseUrl+ "/fib", driver.findElement(By.linkText("Fibonacci")).getAttribute("href"));
    assertEquals(baseUrl+ "/hello", driver.findElement(By.linkText("Hello")).getAttribute("href"));
    assertEquals(baseUrl+ "/cathy", driver.findElement(By.linkText("Cathedral Pics")).getAttribute("href"));
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
