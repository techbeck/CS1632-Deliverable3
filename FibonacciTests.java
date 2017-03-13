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

public class FibonacciTests {
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

// This test tests the value 1 on the fibonacci page.
  @Test
  public void testFibonacci1() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Fibonacci")).click();
    driver.findElement(By.id("tb1")).clear();
    driver.findElement(By.id("tb1")).sendKeys("1");
    driver.findElement(By.id("sub")).click();
    assertEquals("Fibonacci of 1 is 1!", driver.findElement(By.cssSelector("h2")).getText());
  }
// This test tests the value -1 on the fibonacci page.
  @Test
  public void testFibonacciNegative() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Fibonacci")).click();
    driver.findElement(By.id("tb1")).clear();
    driver.findElement(By.id("tb1")).sendKeys("-1");
    driver.findElement(By.id("sub")).click();
    assertEquals("Fibonacci of -1 is 1!", driver.findElement(By.cssSelector("h2")).getText());
  }
// This test tests the value 0 on the fibonacci page.
  @Test
  public void testFibonacciZero() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Fibonacci")).click();
    driver.findElement(By.id("tb1")).clear();
    driver.findElement(By.id("tb1")).sendKeys("0");
    driver.findElement(By.id("sub")).click();
    assertEquals("Fibonacci of 0 is 1!", driver.findElement(By.cssSelector("h2")).getText());
  }
// This test tests the value '%' on the fibonacci page. This is an invalid value and should return 1.
  @Test
  public void testFibonacciInvalidValue() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Fibonacci")).click();
    driver.findElement(By.id("tb1")).clear();
    driver.findElement(By.id("tb1")).sendKeys("%");
    driver.findElement(By.id("sub")).click();
    assertEquals("Fibonacci of % is 1!", driver.findElement(By.cssSelector("h2")).getText());
  }
// This test tests an empty text box on the fibonacci page. This is an invalid value and should return 1.
  @Test
  public void testFibonacciEmpty() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Fibonacci")).click();
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    assertEquals("Fibonacci of is 1!", driver.findElement(By.cssSelector("h2")).getText());
  }
// This test tests the value 5 on the fibonacci page.
  @Test
  public void testFibonacciBasic() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Fibonacci")).click();
    driver.findElement(By.id("tb1")).clear();
    driver.findElement(By.id("tb1")).sendKeys("5");
    driver.findElement(By.id("sub")).click();
    assertEquals("Fibonacci of 5 is 8!", driver.findElement(By.cssSelector("h2")).getText());
  }
// This test tests the value 100 on the fibonacci page.
  @Test
  public void testFibonacci100() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Fibonacci")).click();
    driver.findElement(By.id("tb1")).clear();
    driver.findElement(By.id("tb1")).sendKeys("100");
    driver.findElement(By.id("sub")).click();
    assertEquals("Fibonacci of 100 is 354224848179261915075!", driver.findElement(By.cssSelector("h2")).getText());
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
