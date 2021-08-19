import com.persado.oss.quality.stevia.selenium.core.WebComponent;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AmazonPageObject extends WebComponent {

    public enum MainAmazonPageLocators{
        AMAZON_GIFT_CARD_OPTION("css=a[href='/gift-cards/b/?ie=UTF8&node=2238192011&ref_=nav_cs_gc_4fb606b1a14b44e4823e00c03fc71f47']"),
        PRINT_AT_HOME_OPTION("css=img[alt='Print at home']"),
        ADD_TO_CART("css=input[id='gc-buy-box-atc']"),
        GO_TO_CART("css=a[id='hlb-view-cart-announce']"),
        ITEM_VALUE("//*[@data-item-count=\"1\"]/div[4]/div/div[2]/p/span");

        private String myLocator;

        MainAmazonPageLocators(String locator){

            myLocator = locator;
        }

        public String get(){
            return myLocator;
        }

    }

    /*public void inputSearchText (String text){
        controller().input(AmazonPageObject.Locators.INPUT_GOOGLE_SEARCH.get(), text);
    }*/

    public void selectGiftCardOption(){
        controller().press(AmazonPageObject.MainAmazonPageLocators.AMAZON_GIFT_CARD_OPTION.get());
    }

    public void selectPrintAtHomeOption(){
        controller().press(AmazonPageObject.MainAmazonPageLocators.PRINT_AT_HOME_OPTION.get());
    }

    public void addToCart(){
        controller().press(MainAmazonPageLocators.ADD_TO_CART.get());
    }

    public void goToCart(){
        controller().press(MainAmazonPageLocators.GO_TO_CART.get());
    }

    public double getItemValue(){
        List<WebElement> elements = controller().findElements(AmazonPageObject.MainAmazonPageLocators.ITEM_VALUE.get());
        String value = elements.get(0).getText().replace("$", "");
        double subtotalPrice = Float.parseFloat(value);

        return subtotalPrice;
    }
}
