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

public class FactorialTests {
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

  // Tests factorial functionality with a negative number
  @Test
  public void testFactorialNeg1() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Factorial")).click();
    driver.findElement(By.name("value")).clear();
    driver.findElement(By.name("value")).sendKeys("-1");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    assertEquals("Factorial of -1 is 1!", driver.findElement(By.cssSelector("h2")).getText());
  }

  // Tests factorial functionality with 0
  @Test
  public void testFactorial0() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Factorial")).click();
    driver.findElement(By.name("value")).clear();
    driver.findElement(By.name("value")).sendKeys("0");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    assertEquals("Factorial of 0 is 1!", driver.findElement(By.cssSelector("h2")).getText());
  }

  // Tests factorial functionality with 1
  @Test
  public void testFactorial1() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Factorial")).click();
    driver.findElement(By.name("value")).clear();
    driver.findElement(By.name("value")).sendKeys("1");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    assertEquals("Factorial of 1 is 1!", driver.findElement(By.cssSelector("h2")).getText());
  }

  // Tests factorial functionality with a value between 1 and 100
  @Test
  public void testFactorial5() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Factorial")).click();
    driver.findElement(By.name("value")).clear();
    driver.findElement(By.name("value")).sendKeys("5");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    assertEquals("Factorial of 5 is 120!", driver.findElement(By.cssSelector("h2")).getText());
  }

  // Tests factorial functionality with 100
  @Test
  public void testFactorial100() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Factorial")).click();
    driver.findElement(By.name("value")).clear();
    driver.findElement(By.name("value")).sendKeys("100");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    assertEquals("Factorial of 100 is 93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000!", driver.findElement(By.cssSelector("h2")).getText());
  }

  // Tests factorial functionality with 101
  @Test
  public void testFactorial101() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Factorial")).click();
    driver.findElement(By.name("value")).clear();
    driver.findElement(By.name("value")).sendKeys("101");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    assertEquals("Factorial of 101 is 1!", driver.findElement(By.cssSelector("h2")).getText());
  }

  // Tests factorial functionality with nothing in the text box
  @Test
  public void testFactorialEmpty() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Factorial")).click();
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    assertEquals("Factorial of is 1!", driver.findElement(By.cssSelector("h2")).getText());
  }

  // Tests factorial functionality with a percent sign in the text box
  @Test
  public void testFactorialPerc() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Factorial")).click();
    driver.findElement(By.name("value")).clear();
    driver.findElement(By.name("value")).sendKeys("%");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    assertEquals("Factorial of % is 1!", driver.findElement(By.cssSelector("h2")).getText());
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
