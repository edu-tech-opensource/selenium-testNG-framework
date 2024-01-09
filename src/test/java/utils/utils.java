package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class utils {
    public WebDriver driver;

    public utils(WebDriver driver){
        this.driver = driver;
    }

    public void switchWindowToChild(){
        Set<String> screen1 = driver.getWindowHandles();
        Iterator<String> one = screen1.iterator();
        String parentWindow = one.next();
        String childWindow = one.next();
        driver.switchTo().window(childWindow); // switch to child window
    }
    /**
     * Waits until the specified element is present in the DOM and returns it.
     *
     * @param driver           The WebDriver instance.
     * @param locator          The By locator strategy to identify the element.
     * @param timeoutInSeconds The maximum time to wait for the element to be present, in seconds.
     * @return WebElement representing the located element.
     */
    public static WebElement waitForElementPresence(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Sets the implicit wait for the WebDriver instance.
     *
     * @param duration The time to wait for an element to be present before throwing an exception.
     */
    public  void setImplicitWait(Duration duration) {
        driver.manage().timeouts().implicitlyWait(duration);
    }


    public WebElement waitUntilElementIsClickable(By locator, int timeInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds))
                .until(driver -> {
                    WebElement element = driver.findElement(locator);
                    return element.isEnabled() ? element : null;
                });
    }

    /**
     * Waits for an element to be clickable within a specified timeout.
     *
     * @param driver           WebDriver instance.
     * @param locator          By object representing the element locator.
     * @param timeoutInSeconds Timeout duration in seconds.
     */
    public static void waitForElementClickable(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Waits for an element to be visible within a specified timeout.
     *
     * @param driver           WebDriver instance.
     * @param locator          By object representing the element locator.
     * @param timeoutInSeconds Timeout duration in seconds.
     */
    public static void waitForElementVisible(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Clicks on an element after waiting for it to be clickable.
     *
     * @param driver  WebDriver instance.
     * @param locator By object representing the element locator.
     */
    public static void clickElement(WebDriver driver, By locator) {
        waitForElementClickable(driver, locator, 10);
        driver.findElement(locator).click();
    }

    /**
     * Enters text into a text field after waiting for it to be visible.
     *
     * @param driver  WebDriver instance.
     * @param locator By object representing the element locator.
     * @param text    Text to be entered into the text field.
     */
    public static void enterText(WebDriver driver, By locator, String text) {
        waitForElementVisible(driver, locator, 10);
        driver.findElement(locator).sendKeys(text);
    }

    /**
     * Gets the text from an element after waiting for it to be visible.
     *
     * @param driver  WebDriver instance.
     * @param locator By object representing the element locator.
     * @return Text content of the element.
     */
    public static String getText(WebDriver driver, By locator) {
        waitForElementVisible(driver, locator, 10);
        return driver.findElement(locator).getText();
    }

    /**
     * Waits for a page to load completely.
     *
     * @param driver WebDriver instance.
     * @param timeoutInSeconds Timeout duration in seconds.
     */
    public static void waitForPageToLoad(WebDriver driver, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(webDriver ->
                ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    /**
     * Switches to a new window based on its title.
     *
     * @param driver WebDriver instance.
     * @param windowTitle Title of the window to switch to.
     */
    public static void switchToWindowByTitle(WebDriver driver, String windowTitle) {
        String currentWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals(windowTitle)) {
                return;
            }
        }
        driver.switchTo().window(currentWindow);
    }

    /**
     * Executes JavaScript code.
     *
     * @param driver WebDriver instance.
     * @param script JavaScript code to execute.
     * @param args   Arguments to pass to the JavaScript code.
     * @return The result of the JavaScript execution.
     */
    public static Object executeJavaScript(WebDriver driver, String script, Object... args) {
        return ((JavascriptExecutor) driver).executeScript(script, args);
    }

    /**
     * Scrolls the page to bring an element into view.
     *
     * @param driver  WebDriver instance.
     * @param element WebElement to scroll into view.
     */
    public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Handles an alert pop-up by accepting it.
     *
     * @param driver WebDriver instance.
     */
    public static void acceptAlert(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    /**
     * Handles an alert pop-up by dismissing it.
     *
     * @param driver WebDriver instance.
     */
    public static void dismissAlert(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
    }

    /**
     * Switches to a frame based on its locator.
     *
     * @param driver WebDriver instance.
     * @param frameLocator By object representing the frame locator.
     */
    public static void switchToFrame(WebDriver driver, By frameLocator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
    }

    /**
     * Finds a cell value in a table based on row and column indexes.
     *
     * @param driver WebDriver instance.
     * @param tableLocator By object representing the table locator.
     * @param rowIndex Index of the row (0-based).
     * @param columnIndex Index of the column (0-based).
     * @return The text content of the specified cell.
     */
    public static String getTableCellValue(WebDriver driver, By tableLocator, int rowIndex, int columnIndex) {
        WebElement table = driver.findElement(tableLocator);
        WebElement row = table.findElements(By.tagName("tr")).get(rowIndex);
        WebElement cell = row.findElements(By.tagName("td")).get(columnIndex);
        return cell.getText();
    }

    /**
     * Navigates to the next page in a paginated table.
     *
     * @param driver    WebDriver instance.
     * @param nextButtonLocator By object representing the locator for the "Next" button.
     */
    public static void goToNextPage(WebDriver driver, By nextButtonLocator) {
        WebElement nextButton = driver.findElement(nextButtonLocator);
        if (nextButton.isEnabled()) {
            nextButton.click();
        } else {
            System.out.println("Next button is disabled; already on the last page.");
            // You might want to throw an exception or log an error based on your application's behavior.
        }
    }
}
