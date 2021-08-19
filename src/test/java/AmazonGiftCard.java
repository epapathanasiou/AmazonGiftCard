import com.persado.oss.quality.stevia.spring.SteviaTestBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonGiftCard extends SteviaTestBase {

    @Autowired
    protected AmazonPageObject amazonPageObject;

    @Autowired
    protected GiftCardPageObject giftCardPageObject;

    @Test
    public void selectAmazonGiftCard(){

        //Select the Gift Card Option
        amazonPageObject.selectGiftCardOption();

        //Select the Print At Home Option
        amazonPageObject.selectPrintAtHomeOption();

        //Select the Standard Design as well as the third option card
        giftCardPageObject.selectGiftCardDesign("STANDARD_CARD_DESIGN", "THANK_YOU_CARD_DESIGN");

        //Get the value of the selected card
        double cardValue = giftCardPageObject.getGiftCardvalue();

        //Select the Add to Card option
        amazonPageObject.addToCart();

        //Select the Cart option
        amazonPageObject.goToCart();

        //Get the value of the item
        double cartSubtotal = amazonPageObject.getItemValue();

        //Test fails if the value of the selected card isn't equal with the value of subtotal
        if (!(cardValue == cartSubtotal))
            Assert.fail();
    }
}
