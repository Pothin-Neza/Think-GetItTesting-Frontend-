package com.thinkgetit.frontend;

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
        boolean isCI = System.getenv("CI") != null;

        // Runs headlessly on GitHub, but pops open the browser UI locally for you
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(isCI)  );
                page = browser.newPage();
    }

    @After
    public void closeBrowser() {
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();

        }
    }
}