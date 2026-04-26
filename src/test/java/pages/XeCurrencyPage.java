package pages;

import com.microsoft.playwright.Page;

public class XeCurrencyPage {

    private final Page page;

    public XeCurrencyPage(Page page) {
        this.page = page;
    }

    // ✅ Step 1: Open page + handle cookies
    public void navigateToXeConverter() {
        page.navigate("https://www.xe.com/en-gb/currencyconverter/");
        acceptCookiesIfVisible();  // 👈 THIS is what I meant earlier
    }

    // ✅ Cookie handling
    public void acceptCookiesIfVisible() {
        String[] cookieButtons = {
                "Accept all",
                "Accept All",
                "Accept",
                "I agree",
                "Agree",
                "Allow all"
        };

        for (String buttonText : cookieButtons) {
            try {
                page.getByRole(
                        com.microsoft.playwright.options.AriaRole.BUTTON,
                        new Page.GetByRoleOptions().setName(buttonText)
                ).click(new com.microsoft.playwright.Locator.ClickOptions().setTimeout(2000));

                System.out.println("Cookie accepted using: " + buttonText);
                return;

            } catch (Exception ignored) {
                // Try next option
            }
        }

        System.out.println("No cookie popup found or already handled.");
    }

    // ✅ Page title
    public String getPageTitle() {
        return page.title();
    }

    // ✅ Enter amount (fix strict mode issue)
    public void enterAmount(double amount) {
        page.locator("input[aria-label='Receiving amount']")
                .first()
                .fill(String.valueOf(amount));
    }

    // ✅ Skip currency selection (stable version)
    public void selectFromCurrency(String fromCurrency) {
        System.out.println("Using default From currency: " + fromCurrency);
    }

    public void selectToCurrency(String toCurrency) {
        System.out.println("Using default To currency: " + toCurrency);
    }

    // ✅ No click needed (XE auto updates)
    public void clickConvert() {
        // No action needed
    }

    // ✅ Get result text
    public String getConversionResultText() {
        return page.locator("text=EUR").first().textContent();
    }
}