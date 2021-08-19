import com.persado.oss.quality.stevia.selenium.core.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GiftCardPageObject extends WebComponent {

    public enum GiftCardPageLocators{
        STANDARD_CARD_DESIGN("css=button[id='gc-customization-type-button-Designs']"),
        THANK_YOU_CARD_DESIGN("css=img[alt='Thank you Stamped Letter']"),
        SELECTED_CARD("//span[@class='a-button a-button-toggle a-button-selected']//button");
        /*CUSTOM_CARD_DESIGN("css=button[id='gc-customization-type-button-Upload']"),
        AMAZON_LOGO_CARD_DESIGN("css=img[alt='Amazon Logo']"),
        HAPPY_BIRTHDAY_CARD_DESIGN("css=img[alt='Birthday Cupcakes']"),
        YOU_ARE_STAR_CARD_DESIGN("css=img[alt='You Are a Star, Burst']"),
        TEACHER_CARD_DESIGN("css=img[alt='Best Teacher Apples']")*/

        private String myCard;

        GiftCardPageLocators(String card){
            myCard = card;
        }

        public String get(){
            return myCard;
        }

    }

    public void selectStandardGiftCardDesign (){
        controller().press(GiftCardPageObject.GiftCardPageLocators.STANDARD_CARD_DESIGN.get());
    }

    public void selectThankYouGiftCardDesign (){
        controller().press(GiftCardPageObject.GiftCardPageLocators.THANK_YOU_CARD_DESIGN.get());
    }

    public void selectGiftCardDesign (String standardOrCustomCardDesign, String cardDesign){
        if (standardOrCustomCardDesign.equals("STANDARD_CARD_DESIGN"))
            this.selectStandardGiftCardDesign();
        if (cardDesign.equals("THANK_YOU_CARD_DESIGN"))
            this.selectThankYouGiftCardDesign();
    }

    public double getGiftCardvalue(){
        List<WebElement> elements = controller().findElements(GiftCardPageObject.GiftCardPageLocators.SELECTED_CARD.get());
        String value = elements.get(0).getAttribute("value");
        double giftCardPrice = Float.parseFloat(value);

        return giftCardPrice;
    }

}
