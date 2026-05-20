import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.After;
import org.junit.Before;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    @Before
    public void startBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    @After
    public void closeBrowser() {
        browser.close();
        playwright.close();
    }
}
