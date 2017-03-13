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

public class HelloTests {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new HtmlUnitDriver();
    java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF); 
    baseUrl = "https://cs1632ex.herokuapp.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  // Tests basic /hello functionality
  @Test
  public void testBaseHello() throws Exception {
    driver.get(baseUrl + "/hello");
    assertEquals("Hello CS1632, from Prof. Laboon!", driver.findElement(By.cssSelector("h2")).getText());
  }

  // Tests /hello/Jazzy functionality
  @Test
  public void testHelloWord() throws Exception {
    driver.get(baseUrl + "/hello/Jazzy");
    assertEquals("Hello CS1632, from Jazzy!", driver.findElement(By.cssSelector("h2")).getText());
  }

  // Tests /hello/1632 functionality
  @Test
  public void testHelloNumber() throws Exception {
    driver.get(baseUrl + "/hello/1632");
    assertEquals("Hello CS1632, from 1632!", driver.findElement(By.cssSelector("h2")).getText());
  }

  // Tests /hello// functionality
  @Test
  public void testHelloSlash() throws Exception {
    driver.get(baseUrl + "/hello//");
    assertEquals("Hello CS1632, from /!", driver.findElement(By.cssSelector("h2")).getText());
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
